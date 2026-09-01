package yaksasoft.songorganizer.mapper;

import org.springframework.stereotype.Component;
import yaksasoft.songorganizer.entity.User;
import yaksasoft.songorganizer.entity.dto.response.UserProfileResponse;
import yaksasoft.songorganizer.entity.dto.response.UserResponse;

@Component
public class UserMapper {
    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getCreatedAt()
        );
    }

    public UserProfileResponse getMappedUserProfile(User user) {
        return new UserProfileResponse(
                user.getId(),
                user.getEmail(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getDescription(),
                user.getImageUrl(),
                user.getCreatedAt().toLocalDate()
        );

    }
}