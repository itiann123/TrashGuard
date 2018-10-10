package com.trashguard.trashgaurd.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.trash.trashguard.R;

public class ComplaintDetailsView extends AppCompatActivity {

    private ImageView history_button;
    private ImageView home_button;
    private ImageView notifications_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_details);


        history_button = (ImageView) findViewById(R.id.history);
        history_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ComplaintDetailsView.this, ComplaintHistoryView.class);
                startActivity(i);
            }
        });

        home_button = (ImageView) findViewById(R.id.home);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ComplaintDetailsView.this, HomeView.class);
                startActivity(i);
            }
        });

        notifications_button = (ImageView) findViewById(R.id.notification);
        notifications_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ComplaintDetailsView.this, NotificationsView.class);
                startActivity(i);
            }
        });


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ComplaintDetailsView.this, HomeView.class));
        finish();
    }
}
