package com.socialmedia.socialmediaApp.repos;

import com.socialmedia.socialmediaApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
