package com.trashguard.trashgaurd.Presenter;

import android.support.annotation.NonNull;
import android.util.Patterns;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.trashguard.trashgaurd.Model.UserModel;
import com.trashguard.trashgaurd.Presenter.Interaface.ISignUpPresenter;
import com.trashguard.trashgaurd.View.Interface.ISignUpView;
import com.trashguard.trashgaurd.View.SignUpView;

public class SignUpPresenter  {
//implements ISignUpPresenter

    private ISignUpView iSignUpView;
    private SignUpView signUpView;

    public SignUpPresenter(ISignUpView iSignUpView){
        this.iSignUpView = iSignUpView;
    }


//    @Override
//    public void registerUser(final String email, final String password) {
//
//        signUpView  = new SignUpView();
//        mAuth = FirebaseAuth.getInstance();
//
//        if(email.isEmpty()){
//            SignUpView.email_field.setError("Email is required");
//            SignUpView.email_field.requestFocus();
//            return;
//        }
//
//        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//            SignUpView.email_field.setError("Please enter a valid email");
//            SignUpView.email_field.requestFocus();
//            return;
//        }
//
//        if(password.isEmpty()){
//            SignUpView.password_field.setError("Password is required");
//            SignUpView.password_field.requestFocus();
//            return;
//        }
//
//        if(password.length() < 6){
//            SignUpView.password_field.setError("Minimum length of password should be 6");
//            SignUpView.password_field.requestFocus();
//            return;
//
//        }
//
//        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()) {
//                    onSignUp(email, password);
//                }
//            }
//        });
//    }

//    @Override
//    public void onSignUp(String email, String password) {
//        UserModel user = new UserModel(password, email);
//
//        boolean isSignUpSuccess = user.isValidData();
//
//        if(isSignUpSuccess)(
//            iSignUpView.onSignUpResult("Sign up Success");
//        else
//            iSignUpView.onSignUpResult("Sign up Error");
//    }
}
