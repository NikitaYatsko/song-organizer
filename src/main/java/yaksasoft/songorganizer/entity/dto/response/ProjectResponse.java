package yaksasoft.songorganizer.entity.dto.response;

import yaksasoft.songorganizer.entity.enums.ProjectStatus;

import java.time.LocalDateTime;

public record ProjectResponse(
        Long id,
        String projectName,
        ProjectStatus status,
        LocalDateTime deadline,
        LocalDateTime createdAt,
        String ownerEmail
) {
}