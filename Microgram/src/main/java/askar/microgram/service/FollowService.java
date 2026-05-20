package askar.microgram.service;

public interface FollowService {
    void follow(Long followingId, Long followerId);

    void unfollow(Long followingId, Long followerId);

    boolean isFollowing(Long followingId, Long followerId);

    int getFollowersCount(Long userId);

    int getFollowingCount(Long userId);
}
