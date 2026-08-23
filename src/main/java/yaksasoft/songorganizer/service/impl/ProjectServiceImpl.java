package yaksasoft.songorganizer.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yaksasoft.songorganizer.entity.Project;
import yaksasoft.songorganizer.entity.User;
import yaksasoft.songorganizer.entity.dto.request.ProjectCreateRequest;
import yaksasoft.songorganizer.entity.dto.response.ProjectResponse;
import yaksasoft.songorganizer.entity.enums.ErrorMessages;
import yaksasoft.songorganizer.entity.enums.ProjectStatus;
import yaksasoft.songorganizer.exception.ProjectNotFoundException;
import yaksasoft.songorganizer.exception.UserNotFoundException;
import yaksasoft.songorganizer.mapper.ProjectMapper;
import yaksasoft.songorganizer.repository.ProjectRepository;
import yaksasoft.songorganizer.repository.UserRepository;
import yaksasoft.songorganizer.service.ProjectService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;

    @Override
    @Transactional
    public ProjectResponse create(ProjectCreateRequest request) {
        User currentUser = getCurrentUser();

        Project project = Project.builder()
                .projectName(request.projectName())
                .status(request.status() == null
                        ? ProjectStatus.IDEA
                        : request.status())
                .deadline(request.deadline())
                .owner(currentUser)
                .createdAt(LocalDateTime.now())
                .build();

        Project savedProject = projectRepository.save(project);

        return projectMapper.toResponse(savedProject);
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectResponse getById(Long projectId) {
        Project project = getOwnedProject(projectId);

        return projectMapper.toResponse(project);
    }

    @Override
    @Transactional
    public ProjectResponse updateStatus(
            ProjectStatus status,
            Long projectId
    ) {
        Project project = getOwnedProject(projectId);

        project.setStatus(status);

        return projectMapper.toResponse(project);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectResponse> getAll() {
        User currentUser = getCurrentUser();

        return projectRepository.findAllByOwnerId(currentUser.getId())
                .stream()
                .map(projectMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public void delete(Long projectId) {
        Project project = getOwnedProject(projectId);

        projectRepository.delete(project);
    }

    @Transactional(readOnly = true)
    @Override
    public Project getOwnedProject(Long projectId) {
        User currentUser = getCurrentUser();

        return projectRepository
                .findByIdAndOwnerId(projectId, currentUser.getId())
                .orElseThrow(() -> new ProjectNotFoundException(
                        ErrorMessages.PROJECT_NOT_FOUND.getMessage()
                ));
    }

    private User getCurrentUser() {
        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(
                        ErrorMessages.USER_NOT_FOUND.getMessage()
                ));
    }
}