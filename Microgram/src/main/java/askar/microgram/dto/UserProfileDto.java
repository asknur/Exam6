package askar.microgram.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileDto {
    private Long id;
    private String username;
    private String fullName;
    private String bio;
    private String avatar;
    private int postsCount;
    private int followersCount;
    private int followingCount;
    private boolean isFollowedByCurrentUser;
}
