package com.hallym.redisprac.controller;

import com.hallym.redisprac.model.User;
import com.hallym.redisprac.service.UserRedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRedisService userRedisService;

    //사용자 생성
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userRedisService.save(user);
        return ResponseEntity.ok("User saved.");
    }

    //사용자 조회(GET /users/{id})
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id) {
        return userRedisService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //사용자 수정 (PUT /users/{id})
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody User user) {
        user.setId(id);
        userRedisService.update(user);
        return ResponseEntity.ok("User updated.");
    }

    // 사용자 삭제 (DELETE /users/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        userRedisService.delete(id);
        return ResponseEntity.ok("User deleted.");
    }
}