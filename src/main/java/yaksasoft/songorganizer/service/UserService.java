package yaksasoft.songorganizer.service;

import yaksasoft.songorganizer.entity.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse getById(Long id);

    List<UserResponse> getAll();

    void delete(Long id);
}
