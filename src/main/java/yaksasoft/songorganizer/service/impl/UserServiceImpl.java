package yaksasoft.songorganizer.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yaksasoft.songorganizer.entity.User;
import yaksasoft.songorganizer.entity.dto.response.UserResponse;
import yaksasoft.songorganizer.exception.UserNotFoundException;
import yaksasoft.songorganizer.mapper.UserMapper;
import yaksasoft.songorganizer.repository.UserRepository;
import yaksasoft.songorganizer.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override

    public UserResponse getById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return userMapper.toResponse(user);
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public void delete(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        userRepository.delete(user);
    }
}