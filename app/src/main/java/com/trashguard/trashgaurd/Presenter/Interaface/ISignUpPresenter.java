package com.trashguard.trashgaurd.Presenter.Interaface;

public interface ISignUpPresenter {
    void registerUser(String email, String password);
    void onSignUp(String email, String password);
}
