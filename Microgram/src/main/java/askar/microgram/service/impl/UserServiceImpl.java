package askar.microgram.service.impl;

import askar.microgram.dto.UserDto;
import askar.microgram.dto.UserProfileDto;
import askar.microgram.models.User;
import askar.microgram.repository.FollowRepository;
import askar.microgram.repository.UserRepository;
import askar.microgram.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    @Override
    public User register(UserDto userDto) {
        log.info("Registering user {}", userDto);

        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already in use" + userDto.getUsername());
        }

        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already in use" + userDto.getEmail());
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullName());
        user.setBio(userDto.getBio());

        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        log.info("Finding user {}", username);
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User findByEmail(String email) {
        log.info("Finding user {}", email);
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User findById(Long id) {
        log.info("Finding user {}", id);
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserDto> search(String search) {
        log.info("Searching user {}", search);
        return userRepository.findByUsernameContainingIgnoreCaseOrFullNameContainingIgnoreCaseOrEmailContainingIgnoreCase(search, search, search)
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public UserProfileDto getProfile(Long id, String username) {
        log.info("Getting user {}", id);

        User user = findByUsername(username);
        UserProfileDto dto = new UserProfileDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setFullName(user.getFullName());
        dto.setBio(user.getBio());
        dto.setAvatar(user.getAvatar());
        dto.setFollowersCount(user.getFollowers().size());
        dto.setFollowingCount(user.getFollowing().size());
        return dto;
    }

    @Override
    public UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setFullName(user.getFullName());
        dto.setAvatar(user.getAvatar());
        return dto;
    }

}
