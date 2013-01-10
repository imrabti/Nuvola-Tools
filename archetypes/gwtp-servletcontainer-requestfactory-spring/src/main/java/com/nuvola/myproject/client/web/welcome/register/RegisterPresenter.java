package com.nuvola.myproject.client.web.welcome.register;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.nuvola.myproject.client.mvp.ValidatedView;
import com.nuvola.myproject.client.place.NameTokens;
import com.nuvola.myproject.client.request.MyRequestFactory;
import com.nuvola.myproject.client.request.RegistrationRequest;
import com.nuvola.myproject.client.request.ValidatedReceiverImpl;
import com.nuvola.myproject.client.request.proxy.UserProxy;
import com.nuvola.myproject.client.web.RootPresenter;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class RegisterPresenter extends Presenter<RegisterPresenter.MyView, RegisterPresenter.MyProxy>
        implements RegisterUiHandlers {
    public interface MyView extends ValidatedView, HasUiHandlers<RegisterUiHandlers> {
        void edit(UserProxy userProxy);
    }

    @ProxyStandard
    @NameToken(NameTokens.register)
    public interface MyProxy extends ProxyPlace<RegisterPresenter> {
    }

    private final MyRequestFactory requestFactory;
    private final PlaceManager placeManager;

    private RegistrationRequest currentContext;

    @Inject
    public RegisterPresenter(final EventBus eventBus, final MyView view, final MyProxy proxy,
                             final MyRequestFactory requestFactory, final PlaceManager placeManager) {
        super(eventBus, view, proxy, RootPresenter.TYPE_SetMainContent);

        this.requestFactory = requestFactory;
        this.placeManager = placeManager;

        getView().setUiHandlers(this);
    }

    @Override
    public void register(UserProxy user) {
        currentContext.register(user).fire(new ValidatedReceiverImpl<Void>() {
            @Override
            public void onValidationError(Set<ConstraintViolation<?>> violations) {
                getView().clearErrors();
                getView().showErrors(violations);
            }

            @Override
            public void onSuccess(Void aVoid) {
                getView().clearErrors();
                placeManager.revealPlace(new PlaceRequest(NameTokens.getLogin()));
            }
        });
    }

    protected void onReveal() {
        currentContext = requestFactory.registrationService();
        getView().edit(currentContext.create(UserProxy.class));
    }
}
