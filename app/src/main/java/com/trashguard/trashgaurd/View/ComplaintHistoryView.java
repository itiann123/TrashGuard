package com.trashguard.trashgaurd.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.trash.trashguard.R;

public class ComplaintHistoryView extends AppCompatActivity {

    private ImageView history_button;
    private ImageView home_button;
    private ImageView notifications_button;
    private View include1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_history);

        include1 = findViewById(R.id.include1);
        include1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ComplaintHistoryView.this, ComplaintDetailsView.class);
                startActivity(i);
            }
        });

        history_button = (ImageView) findViewById(R.id.history);
        history_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ComplaintHistoryView.this, "Already at History", Toast.LENGTH_SHORT).show();
            }
        });

        home_button = (ImageView) findViewById(R.id.home);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ComplaintHistoryView.this, HomeView.class);
                startActivity(i);
            }
        });
        notifications_button = (ImageView) findViewById(R.id.notification);
        notifications_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ComplaintHistoryView.this, NotificationsView.class);
                startActivity(i);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ComplaintHistoryView.this, HomeView.class));
        finish();
    }
}
