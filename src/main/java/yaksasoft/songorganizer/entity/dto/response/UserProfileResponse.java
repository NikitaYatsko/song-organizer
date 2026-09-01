package yaksasoft.songorganizer.entity.dto.response;

import java.time.LocalDate;

public record UserProfileResponse(
        Long id,
        String email,
        String username,
        String firstName,
        String lastName,
        String description,
        String imageUrl,
        LocalDate createdAt
) {
}
