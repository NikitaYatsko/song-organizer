package yaksasoft.songorganizer.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import yaksasoft.songorganizer.entity.User;
import yaksasoft.songorganizer.entity.dto.response.AuthResponse;
import yaksasoft.songorganizer.entity.dto.request.LoginRequest;
import yaksasoft.songorganizer.entity.dto.request.RegisterRequest;
import yaksasoft.songorganizer.repository.UserRepository;
import yaksasoft.songorganizer.service.jwt.JwtService;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("Email already exists");
        }

        if (userRepository.existsByUsername(request.username())) {
            throw new RuntimeException("Username already exists");
        }

        User user = User.builder()
                .email(request.email())
                .username(request.username())
                .passwordHash(passwordEncoder.encode(request.password()))
                .firstName(request.firstName())
                .lastName(request.lastName())
                .build();

        userRepository.save(user);

        return new AuthResponse(
                jwtService.generateToken(user.getEmail())
        );
    }

    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        return new AuthResponse(
                jwtService.generateToken(request.email())
        );
    }
}