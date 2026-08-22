package yaksasoft.songorganizer.entity.dto;

public record RegisterRequest(String email,
                              String username,
                              String password,
                              String firstName,
                              String lastName) {
}
