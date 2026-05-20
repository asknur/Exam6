package askar.microgram.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;

    @NotBlank
    @Size(min = 4, max = 50, message = "Should be name")
    private String username;

    @Email
    private String email;

    @NotBlank
    @Size(min = 2, max = 10, message = "Length must be >= 2 and <= 10")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).+$",
            message = "Should be password")
    private String password;

    private String fullName;

    private String avatar;

    private String bio;

}
