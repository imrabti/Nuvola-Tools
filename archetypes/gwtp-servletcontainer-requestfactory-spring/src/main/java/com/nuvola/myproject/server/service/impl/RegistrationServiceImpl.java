package com.nuvola.myproject.server.service.impl;

import com.nuvola.myproject.server.business.User;
import com.nuvola.myproject.server.repos.UserRepos;
import com.nuvola.myproject.server.service.RegistrationService;
import com.nuvola.myproject.shared.type.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private UserRepos userRepos;

    @Override
    public void register(User user) {
        user.setAuthority(Authority.ROLE_USER);
        userRepos.save(user);
    }
}
