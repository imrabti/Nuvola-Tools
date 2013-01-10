package com.nuvola.myproject.client.web;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.nuvola.myproject.client.web.application.ApplicationModule;
import com.nuvola.myproject.client.web.welcome.WelcomeModule;

public class RootModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new ApplicationModule());
        install(new WelcomeModule());

        bindPresenter(RootPresenter.class, RootPresenter.MyView.class, RootView.class,
                RootPresenter.MyProxy.class);
    }
}
