package askar.microgram.service;

import askar.microgram.dto.UserDto;
import askar.microgram.dto.UserProfileDto;
import askar.microgram.models.User;

import java.util.List;

public interface UserService {
    User register(UserDto userDto);

    User findByUsername(String username);

    User findByEmail(String email);

    User findById(Long id);

    List<UserDto> search(String search);

    UserProfileDto getProfile(Long id, String username);

    UserDto toDto(User user);
}
