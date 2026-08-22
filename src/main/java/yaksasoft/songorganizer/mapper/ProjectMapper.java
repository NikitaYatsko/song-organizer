package yaksasoft.songorganizer.mapper;

import org.springframework.stereotype.Component;
import yaksasoft.songorganizer.entity.Project;

import yaksasoft.songorganizer.entity.dto.ProjectResponse;


@Component
public class ProjectMapper {

    public ProjectResponse toResponse(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getProjectName(),
                project.getStatus(),
                project.getDeadline(),
                project.getCreatedAt(),
                project.getOwner().getEmail()

        );
    }
}