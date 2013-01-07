package com.nuvola.myproject.client.security;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.GatekeeperWithParams;

public class HasRoleGatekeeper implements GatekeeperWithParams {
    private final SecurityUtils securityUtils;

    @Inject
    public HasRoleGatekeeper(final SecurityUtils securityUtils) {
        this.securityUtils = securityUtils;
    }

    @Override
    public GatekeeperWithParams withParams(String[] strings) {
        return null;
    }

    @Override
    public boolean canReveal() {
        return false;
    }
}
