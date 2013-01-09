package com.nuvola.myproject.server.security;

import com.nuvola.myproject.server.business.User;

public interface SecurityContextProvider {
    User getCurrentUser();
}
