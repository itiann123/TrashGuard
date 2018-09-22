package com.trashguard.trashgaurd.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.trash.trashguard.R;
import com.trashguard.trashgaurd.Presenter.Interaface.ILogInPresenter;
import com.trashguard.trashgaurd.Presenter.LogInPresenter;
import com.trashguard.trashgaurd.View.Interface.ILogInView;

public class LogInView extends AppCompatActivity implements ILogInView {

    private AutoCompleteTextView email_field;
    private EditText password_field;
    private Button sign_in_button;
    private TextView sign_up_button;

    ILogInPresenter logInPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email_field = (AutoCompleteTextView) findViewById(R.id.email);
        password_field = (EditText) findViewById(R.id.password);
        sign_in_button = (Button) findViewById(R.id.email_sign_in_button);
        sign_up_button = (TextView) findViewById(R.id.email_sign_up_button);
        logInPresenter = new LogInPresenter(this);

        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logInPresenter.onLogin(email_field.getText().toString(),password_field.getText().toString());
            }
        });

        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LogInView.this,SignUpView.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public void onClick(View view) {
//        switch(view.getId()){
//            case R.id.sign_in_button:
//                Snackbar.make(view, "Not available yet",
//                        Snackbar.LENGTH_LONG).setAction("Action",
//                        null).show();
//                break;
//            case  R.id.register_button:
//                Intent i = new Intent(LogInView.this,SignUpView.class);
//                startActivity(i);
//                break;
//            default: Toast.makeText(LogInView.this,"An error has occured",Toast.LENGTH_SHORT);
//        }
//    }


}
