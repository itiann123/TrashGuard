package com.trashguard.trashgaurd.Model;

import android.text.TextUtils;
import android.util.Patterns;

import com.trashguard.trashgaurd.Model.Interface.IUser;

public class UserModel implements IUser {

    String password;
    String email;

    public UserModel(String password, String email) {
        this.password = password;
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isValidData() {
        return !TextUtils.isEmpty(getEmail()) &&
                Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() &&
                getPassword().length() >6 ;
    }
}
