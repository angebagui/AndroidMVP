package com.herokuapp.angebagui.androidmvp.ui.login;

import com.herokuapp.angebagui.androidmvp.model.User;
import com.herokuapp.angebagui.androidmvp.util.Callback;

/**
 * Created by angebagui on 06/07/2016.
 */
public class LoginPresenter implements ILoginPresenter {

    private LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = view;
    }

    @Override
    public void attemptLogin(String username, String password) {
        User.loginInBackground(username, password, new Callback<User>() {
            @Override
            public void onSuccess(User user) {
                view.navigateToMainActivity(user);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.loginFailed(throwable);
            }
        });
    }
}
