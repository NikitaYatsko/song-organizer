package yaksasoft.songorganizer.entity.dto;

import yaksasoft.songorganizer.entity.enums.ProjectStatus;

import java.time.LocalDateTime;
import java.util.List;

public record ProjectResponse(
        Long id,
        String projectName,
        ProjectStatus status,
        LocalDateTime deadline,
        LocalDateTime createdAt,
        String ownerEmail
) {
}