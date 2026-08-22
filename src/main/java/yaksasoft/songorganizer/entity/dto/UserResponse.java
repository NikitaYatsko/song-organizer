package yaksasoft.songorganizer.entity.dto;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String email,
        String username,
        String firstName,
        String lastName,
        LocalDateTime createdAt
) {
}