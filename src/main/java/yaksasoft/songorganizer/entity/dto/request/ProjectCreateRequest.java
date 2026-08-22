package yaksasoft.songorganizer.entity.dto.request;

import yaksasoft.songorganizer.entity.enums.ProjectStatus;

import java.time.LocalDateTime;

public record ProjectCreateRequest(
        String projectName,
        ProjectStatus status,
        LocalDateTime deadline
) {
}