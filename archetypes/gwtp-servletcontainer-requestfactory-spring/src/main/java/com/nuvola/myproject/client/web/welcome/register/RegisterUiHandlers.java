package com.nuvola.myproject.client.web.welcome.register;

import com.gwtplatform.mvp.client.UiHandlers;
import com.nuvola.myproject.client.request.proxy.UserProxy;

public interface RegisterUiHandlers extends UiHandlers {
    void register(UserProxy user);
}
