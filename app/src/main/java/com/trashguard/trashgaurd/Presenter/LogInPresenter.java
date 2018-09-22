package com.trashguard.trashgaurd.Presenter;

import com.trashguard.trashgaurd.Model.UserModel;
import com.trashguard.trashgaurd.Presenter.Interaface.ILogInPresenter;
import com.trashguard.trashgaurd.View.Interface.ILogInView;

public class LogInPresenter implements ILogInPresenter {

    ILogInView logInView;

    public LogInPresenter(ILogInView logInView){
        this.logInView = logInView;
    }

    @Override
    public void onLogin(String email, String password) {
         UserModel user = new UserModel(password, email);

         boolean isLoginSuccess = user.isValidData();

         if(isLoginSuccess)
             logInView.onLoginResult("Login Success");
         else
             logInView.onLoginResult("Login Error");
    }
}
