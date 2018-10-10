package com.trashguard.trashgaurd.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.trash.trashguard.R;
import com.trashguard.trashgaurd.Presenter.Interaface.ILogInPresenter;
import com.trashguard.trashgaurd.Presenter.LogInPresenter;
import com.trashguard.trashgaurd.View.HomeView;
import com.trashguard.trashgaurd.View.Interface.ILogInView;
import com.trashguard.trashgaurd.View.SignUpView;

public class LogInSignUpView extends AppCompatActivity implements ILogInView {

    private AutoCompleteTextView email_field;
    private EditText password_field;
    private Button sign_in_button;
    private TextView sign_up_button;
    ILogInPresenter logInPresenter;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        tabLayout = findViewById(R.id.tablayout);
        appBarLayout = findViewById(R.id.appBarLayout);
        viewPager = findViewById(R.id.viewpager);

        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
        adapter.AddFragment(new LogInFragment(),"Log In");
        adapter.AddFragment(new SignUpFragment(),"Sign Up");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        logInPresenter = new LogInPresenter(this);
//        email_field = (AutoCompleteTextView) findViewById(R.id.email);
//        password_field = (EditText)findViewById(R.id.password);
//        sign_in_button = (Button) findViewById(R.id.email_sign_in_button);
//        sign_up_button = (TextView) findViewById(R.id.sign_up_button);
//
//        sign_up_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(LogInSignUpView.this,SignUpView.class);
//                startActivity(i);
//            }
//        });




    }
//
    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void logInOnClick(View view){
        switch (view.getId()){
            case R.id.email_sign_in_button:
                Snackbar.make(view, "Loggin in",
                        Snackbar.LENGTH_LONG).setAction("Action",
                        null).show();
                Intent i = new Intent(LogInSignUpView.this,HomeView.class);
                startActivity(i);
                break;
        }
    }
//
////    @Override
////    public void onClick(View view) {
////        switch(view.getId()){
////            case R.id.sign_in_button:
////                Snackbar.make(view, "Not available yet",
////                        Snackbar.LENGTH_LONG).setAction("Action",
////                        null).show();
////                break;
////            case  R.id.register_button:
////                Intent i = new Intent(LogInSignUpView.this,SignUpView.class);
////                startActivity(i);
////                break;
////            default: Toast.makeText(LogInSignUpView.this,"An error has occured",Toast.LENGTH_SHORT);
////        }
////    }


}
