package yaksasoft.songorganizer.entity.dto;

import yaksasoft.songorganizer.entity.enums.ProjectStatus;

public record ProjectStatusUpdateRequest(
        ProjectStatus status
) {
}