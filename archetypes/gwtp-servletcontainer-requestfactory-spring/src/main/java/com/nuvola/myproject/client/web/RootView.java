package com.nuvola.myproject.client.web;

import com.arcbees.core.client.mvp.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

import javax.inject.Inject;

public class RootView extends ViewImpl implements RootPresenter.MyView {
    public interface Binder extends UiBinder<Widget, RootView> {
    }

    @UiField
    SimpleLayoutPanel main;

    @Inject
    public RootView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setInSlot(Object slot, Widget content) {
        if (content != null) {
            if (slot == RootPresenter.TYPE_SetMainContent) {
                main.setWidget(content);
            }
        }
    }
}
