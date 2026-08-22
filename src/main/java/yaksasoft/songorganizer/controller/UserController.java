package yaksasoft.songorganizer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yaksasoft.songorganizer.entity.dto.response.UserResponse;
import yaksasoft.songorganizer.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                userService.getById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        return ResponseEntity.ok(
                userService.getAll()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }
}