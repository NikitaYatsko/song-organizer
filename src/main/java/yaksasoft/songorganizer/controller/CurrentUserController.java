package yaksasoft.songorganizer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yaksasoft.songorganizer.entity.dto.response.UserProfileResponse;
import yaksasoft.songorganizer.service.CurrentUserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/me")
public class CurrentUserController {

    private final CurrentUserService userService;

    @GetMapping
    public ResponseEntity<UserProfileResponse> getCurrentUser() {
        return ResponseEntity.ok(userService.getCurrentUserProfile());
    }

    @PostMapping("/profile-photo")
    public ResponseEntity<Void>  uploadProfilePhoto(@RequestBody MultipartFile file) {
       userService.uploadProfilePhoto(file);
       return ResponseEntity.ok().build();
    }
}
