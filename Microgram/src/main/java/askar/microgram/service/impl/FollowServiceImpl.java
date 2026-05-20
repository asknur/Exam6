package askar.microgram.service.impl;

import askar.microgram.exception.UserNotFoundException;
import askar.microgram.models.Follow;
import askar.microgram.models.User;
import askar.microgram.repository.FollowRepository;
import askar.microgram.repository.UserRepository;
import askar.microgram.service.FollowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    @Override
    public void follow(Long followingId, Long followerId) {
        if (followerId.equals(followingId)) {
            throw new RuntimeException("User cannot follow themselves");
        }
        if (followRepository.existsByFollowerIdAndFollowingId(followerId, followingId)) {
            throw new RuntimeException("Already following");
        }

        User follower =  userRepository.findById(followerId)
                .orElseThrow(UserNotFoundException::new);

        User following =  userRepository.findById(followingId)
                .orElseThrow(UserNotFoundException::new);

        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setFollowing(following);

        followRepository.save(follow);
        log.info("Following followingId={}", followingId);
    }

    @Override
    public void unfollow(Long followingId, Long followerId) {
        if (!followRepository.existsByFollowerIdAndFollowingId(followerId, followingId)) {
            throw new RuntimeException("not following");
        }

        followRepository.deleteByFollowerIdAndFollowingId(followerId, followingId);
        log.info("User unfollow{}", followingId);
    }

    @Override
    public boolean isFollowing(Long followingId, Long followerId) {
        return followRepository.existsByFollowerIdAndFollowingId(followerId, followingId);
    }

    @Override
    public int getFollowersCount(Long userId) {
        return followRepository.countByFollowingId(userId);
    }

    @Override
    public int getFollowingCount(Long userId) {
        return followRepository.countByFollowerId(userId);
    }

}
