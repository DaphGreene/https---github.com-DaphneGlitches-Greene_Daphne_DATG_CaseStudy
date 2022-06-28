package com.datg.Greene_Daphne_DATG_CaseStudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datg.Greene_Daphne_DATG_CaseStudy.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUsername(String username);
}
