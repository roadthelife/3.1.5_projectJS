package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query ("SELECT p FROM User p JOIN FETCH p.roles where p.username = (:username)")
    Optional<User> findByUsername(String username);

    Optional<User> findById(long id);


}
