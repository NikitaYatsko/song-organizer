package yaksasoft.songorganizer.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import yaksasoft.songorganizer.entity.User;
import yaksasoft.songorganizer.entity.dto.response.UserProfileResponse;
import yaksasoft.songorganizer.entity.enums.ErrorMessages;
import yaksasoft.songorganizer.exception.UserNotFoundException;
import yaksasoft.songorganizer.mapper.UserMapper;
import yaksasoft.songorganizer.repository.UserRepository;
import yaksasoft.songorganizer.service.CurrentUserService;

@RequiredArgsConstructor
@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserProfileResponse getCurrentUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null && authentication.isAuthenticated();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(ErrorMessages.USER_NOT_FOUND.getMessage()));
        return userMapper.getMappedUserProfile(user);
    }
}
