/**
 * Copyright 2012 Nuvola Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.nuvola.myproject.client;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Bootstrapper;
import com.gwtplatform.mvp.client.annotations.IsTheBootstrapper;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.nuvola.myproject.client.place.NameTokens;
import com.nuvola.myproject.client.place.PlaceManager;
import com.nuvola.myproject.client.request.MyRequestFactory;
import com.nuvola.myproject.client.resource.Resources;
import com.nuvola.myproject.client.security.SecurityUtils;

import java.util.logging.Logger;

@IsTheBootstrapper
public class BootstrapperImpl implements Bootstrapper {
    private final static Logger logger = Logger.getLogger(BootstrapperImpl.class.getName());

    private final PlaceManager placeManager;
    private final SecurityUtils securityUtils;
    private final MyRequestFactory requestFactory;

    @Inject
    public BootstrapperImpl(final PlaceManager placeManager, final Resources resources,
                            final SecurityUtils securityUtils, final MyRequestFactory requestFactory) {
        this.placeManager = placeManager;
        this.securityUtils = securityUtils;
        this.requestFactory = requestFactory;

        resources.generalStyleCss().ensureInjected();
    }

    @Override
    public void init() {
        if (securityUtils.isLoggedIn()) {
            //requestFactory.authenticationService().currentUser().fire(getCurrentUserCallback);
        } else {
            bounceToLogin();
        }
    }

    private void bounceToHome() {
        PlaceRequest place = new PlaceRequest(NameTokens.getHome());
        placeManager.revealPlace(place);
    }

    private void bounceToLogin() {
        PlaceRequest place = new PlaceRequest(NameTokens.getLogin());
        placeManager.revealPlace(place);
    }
}
