package yaksasoft.songorganizer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
