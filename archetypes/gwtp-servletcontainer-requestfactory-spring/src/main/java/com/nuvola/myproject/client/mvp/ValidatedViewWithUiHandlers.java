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

package com.nuvola.myproject.client.mvp;

import com.arcbees.core.client.mvp.uihandlers.UiHandlersStrategy;
import com.gwtplatform.mvp.client.UiHandlers;

public abstract class ValidatedViewWithUiHandlers<H extends UiHandlers> extends ValidatedViewImpl
        implements UiHandlersStrategy<H> {
    private UiHandlersStrategy<H> uiHandlersStrategy;

    public ValidatedViewWithUiHandlers(final UiHandlersStrategy<H> uiHandlersStrategy,
                                       final ValidationErrorPopup errorPopup) {
        super(errorPopup);
        this.uiHandlersStrategy = uiHandlersStrategy;
    }

    @Override
    public H getUiHandlers() {
        return uiHandlersStrategy.getUiHandlers();
    }

    @Override
    public void setUiHandlers(H uiHandlers) {
        uiHandlersStrategy.setUiHandlers(uiHandlers);
    }
}
