package com.nuvola.myproject.server.repos;

import com.nuvola.myproject.server.business.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepos extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByUsername(String username);
}
