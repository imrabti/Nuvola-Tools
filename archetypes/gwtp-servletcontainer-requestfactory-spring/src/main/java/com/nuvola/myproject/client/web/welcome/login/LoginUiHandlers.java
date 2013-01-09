package com.nuvola.myproject.client.web.welcome.login;

import com.gwtplatform.mvp.client.UiHandlers;
import com.nuvola.myproject.shared.dto.UserCredentials;

public interface LoginUiHandlers extends UiHandlers {
    void login(UserCredentials credentials);
}
