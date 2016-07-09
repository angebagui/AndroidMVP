package com.herokuapp.angebagui.androidmvp.ui.login;

import com.herokuapp.angebagui.androidmvp.model.User;

/**
 * Created by angebagui on 06/07/2016.
 */
public interface LoginView {

    void navigateToMainActivity(User user);
    void loginFailed(Throwable throwable);
}
