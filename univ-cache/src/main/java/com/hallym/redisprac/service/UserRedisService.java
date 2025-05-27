package com.hallym.redisprac.service;

import com.hallym.redisprac.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRedisService {

    private final RedisTemplate<String, User> redisTemplate; //Redis 연동 템플릿
    private static final String PREFIX = "user:"; //Redis key에 사용할 접두사. 키는 문자열 고정이니까 상수

    // 저장
    public void save(User user) {
        redisTemplate.opsForValue().set(PREFIX + user.getId(), user);
    }

    // 조회
    public Optional<User> findById(String id) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(PREFIX + id));
    }

    // 수정
    public void update(User user) {
        redisTemplate.opsForValue().set(PREFIX + user.getId(), user);
    }

    // 삭제
    public void delete(String id) {
        redisTemplate.delete(PREFIX + id);
    }
}
