package yaksasoft.songorganizer.service;

import org.springframework.web.multipart.MultipartFile;
import yaksasoft.songorganizer.entity.User;
import yaksasoft.songorganizer.entity.dto.response.UserProfileResponse;

public interface CurrentUserService {
    UserProfileResponse getCurrentUserProfile();
    void uploadProfilePhoto(MultipartFile file);
    User getUserFromContext();

}
