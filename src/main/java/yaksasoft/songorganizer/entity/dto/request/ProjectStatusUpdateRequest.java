package yaksasoft.songorganizer.entity.dto.request;

import yaksasoft.songorganizer.entity.enums.ProjectStatus;

public record ProjectStatusUpdateRequest(
        ProjectStatus status
) {
}