package yaksasoft.songorganizer.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import yaksasoft.songorganizer.entity.User;
import yaksasoft.songorganizer.entity.dto.response.UserProfileResponse;
import yaksasoft.songorganizer.entity.enums.ErrorMessages;
import yaksasoft.songorganizer.exception.UserNotFoundException;
import yaksasoft.songorganizer.mapper.UserMapper;
import yaksasoft.songorganizer.repository.UserRepository;
import yaksasoft.songorganizer.service.CurrentUserService;
import yaksasoft.songorganizer.service.PhotoService;

@RequiredArgsConstructor
@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PhotoService photoService;


    @Override
    public UserProfileResponse getCurrentUserProfile() {
        User user = getUserFromContext();
        return userMapper.getMappedUserProfile(user);
    }

    @Override
    public void uploadProfilePhoto(MultipartFile file) {
        User user = getUserFromContext();
        String imageUrl = photoService.uploadPhoto(file, "song-organizer-user-profile-photo");
        user.setImageUrl(imageUrl);
        userRepository.save(user);
    }

    @Override
    public User getUserFromContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new UserNotFoundException(ErrorMessages.USER_NOT_FOUND.getMessage());
        }
        String email = authentication.getName();
        return userRepository.findByEmail(email).orElseThrow(
                () -> new UserNotFoundException(ErrorMessages.USER_NOT_FOUND.getMessage()));
    }
}
