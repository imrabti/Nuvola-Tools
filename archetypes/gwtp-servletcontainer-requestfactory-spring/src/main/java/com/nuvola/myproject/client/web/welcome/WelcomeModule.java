package com.nuvola.myproject.client.web.welcome;

import com.arcbees.core.client.mvp.uihandlers.SetterUiHandlersStrategy;
import com.arcbees.core.client.mvp.uihandlers.UiHandlersStrategy;
import com.google.inject.TypeLiteral;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.nuvola.myproject.client.web.welcome.login.LoginPresenter;
import com.nuvola.myproject.client.web.welcome.login.LoginUiHandlers;
import com.nuvola.myproject.client.web.welcome.login.LoginView;

public class WelcomeModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral<UiHandlersStrategy<LoginUiHandlers>>() {})
                .to(new TypeLiteral<SetterUiHandlersStrategy<LoginUiHandlers>>() {});

        bindPresenter(LoginPresenter.class, LoginPresenter.MyView.class, LoginView.class,
                LoginPresenter.MyProxy.class);
    }
}
