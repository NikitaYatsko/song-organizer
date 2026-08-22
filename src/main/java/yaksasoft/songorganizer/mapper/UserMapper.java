package yaksasoft.songorganizer.mapper;

import org.springframework.stereotype.Component;
import yaksasoft.songorganizer.entity.User;
import yaksasoft.songorganizer.entity.dto.UserResponse;

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
}