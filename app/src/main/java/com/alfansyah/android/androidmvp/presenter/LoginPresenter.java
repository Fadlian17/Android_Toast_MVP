package com.alfansyah.android.androidmvp.presenter;

import com.alfansyah.android.androidmvp.model.User;
import com.alfansyah.android.androidmvp.view.ILoginView;


public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter(ILoginView loginView){
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email,password);
        int loginCode = user.isValidData();

        if (loginCode == 0){
            loginView.onLoginError("You must Enter this Email");
        }else if (loginCode == 1){
            loginView.onLoginError("You must Enter Valid Email");
        }else if (loginCode ==2){
            loginView.onLoginError("Password length be greater than 6");
        }else {
            loginView.onLoginSuccess("Login success");
        }
    }
}
