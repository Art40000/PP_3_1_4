package com.example.pp_3_1_4.repository;

import com.example.pp_3_1_4.model.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Query("select u from User u join fetch u.roles r where u.email = :email")
    User findUserByEmail(@Param("email") String email);

    @Override
    @Transactional
    @Query("select u from User u join fetch u.roles r where u.id = :id")
    Optional<User> findById(Long id);

}
