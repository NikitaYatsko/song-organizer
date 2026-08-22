package yaksasoft.songorganizer.entity.dto;

public record LoginRequest(
        String email,
        String password
) {
}