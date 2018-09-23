package com.trashguard.trashgaurd.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.trash.trashguard.R;
import com.trashguard.trashgaurd.Presenter.Interaface.ISignUpPresenter;
import com.trashguard.trashgaurd.View.Interface.ISignUpView;

public class SignUpView extends AppCompatActivity implements View.OnClickListener, ISignUpView {


    public static AutoCompleteTextView email_field;
    public static EditText password_field;
    private Button sign_up_button;


    private ISignUpPresenter signUpPresenter;
    private String email;
    private String password;


    public AutoCompleteTextView getEmail_field() {
        return email_field;
    }

    public void setEmail_field(AutoCompleteTextView email_field) {
        this.email_field = email_field;
    }

    public EditText getPassword_field() {
        return password_field;
    }

    public void setPassword_field(EditText password_field) {
        this.password_field = password_field;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//
//                email_field = (AutoCompleteTextView) findViewById(R.id.email);
//                password_field = (EditText) findViewById(R.id.password);
//
               sign_up_button=(Button) findViewById(R.id.email_sign_up_button);
               sign_up_button.setOnClickListener(this);
//               signUpPresenter = new SignUpPresenter(this);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//            }
//        });

        }




//    private void initialize() {
//    }

        @Override
        public void onClick(View view) {
            switch(view.getId()){
//                case R.id.sign_up_button:
//                    email = email_field.getText().toString().trim();
//                    password = password_field.getText().toString().trim();
//                    Log.d("Email:", String.valueOf(email));
//                    Log.d("Password:", String.valueOf(password));
//                    signUpPresenter.registerUser(email ,password);
                case R.id.email_sign_up_button:
                    sign_up_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(SignUpView.this,HomeView.class);
                            startActivity(i);
                        }
                    });
                    break;
//
            }
//                break;
    }

    @Override
    public void onSignUpResult(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
