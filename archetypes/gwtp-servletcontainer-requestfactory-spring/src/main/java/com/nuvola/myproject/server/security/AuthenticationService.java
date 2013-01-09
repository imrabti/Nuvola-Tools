package com.nuvola.myproject.server.security;

import com.nuvola.myproject.server.business.User;

public interface AuthenticationService {
    User currentUser();

    Boolean authenticate(String username, String password);
}
