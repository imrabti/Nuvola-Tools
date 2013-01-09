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
import com.nuvola.myproject.client.place.PlaceManager;
import com.nuvola.myproject.client.resource.Resources;

@IsTheBootstrapper
public class BoostrapperImpl implements Bootstrapper {
    private final PlaceManager placeManager;

    @Inject
    public BoostrapperImpl(final PlaceManager placeManager, final Resources resources) {
        this.placeManager = placeManager;

        resources.generalStyleCss().ensureInjected();
    }

    @Override
    public void init() {
        placeManager.revealCurrentPlace();
    }
}