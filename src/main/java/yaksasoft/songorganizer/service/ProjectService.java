package yaksasoft.songorganizer.service;


import org.springframework.transaction.annotation.Transactional;
import yaksasoft.songorganizer.entity.Project;
import yaksasoft.songorganizer.entity.dto.request.ProjectCreateRequest;
import yaksasoft.songorganizer.entity.dto.response.ProjectResponse;
import yaksasoft.songorganizer.entity.enums.ProjectStatus;

import java.util.List;

public interface ProjectService {

    ProjectResponse create(ProjectCreateRequest request);

    ProjectResponse getById(Long id);


    @Transactional
    ProjectResponse updateStatus(ProjectStatus status, Long id);

    List<ProjectResponse> getAll();

    void delete(Long id);

    @Transactional(readOnly = true)
    Project getOwnedProject(Long projectId);
}