package com.hallym.user.repository;

import com.hallym.user.entity.User;
import com.hallym.user.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findBySocialIdAndProvider(String socialId, Provider provider);

    boolean existsByEmail(String email);

}
