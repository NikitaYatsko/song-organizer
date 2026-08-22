package yaksasoft.songorganizer.entity.dto;

import yaksasoft.songorganizer.entity.enums.ProjectStatus;

import java.time.LocalDateTime;

public record ProjectCreateRequest(
        String projectName,
        ProjectStatus status,
        LocalDateTime deadline
) {
}