package yaksasoft.songorganizer.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import yaksasoft.songorganizer.service.PhotoService;

import java.util.Map;
@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final Cloudinary cloudinary;

    @SneakyThrows
    @Override
    public String uploadPhoto(MultipartFile file, String folderName) {
        if(file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }
        Map<String, Object> result = cloudinary.uploader().upload(
                file.getBytes(),
                ObjectUtils.asMap("folder", folderName)
        );

        return result.get("secure_url").toString();
    }
}
