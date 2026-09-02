package yaksasoft.songorganizer.service;

import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {
    String uploadPhoto(MultipartFile file, String folderName);
}
