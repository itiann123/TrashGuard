package com.trashguard.trashgaurd.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.trash.trashguard.R;

public class NotificationsView extends AppCompatActivity {

    private ImageView history_button;
    private ImageView home_button;
    private ImageView notifications_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        history_button = (ImageView) findViewById(R.id.history);
        history_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NotificationsView.this, ComplaintHistoryView.class);
                startActivity(i);
            }
        });

        home_button = (ImageView) findViewById(R.id.home);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NotificationsView.this, HomeView.class);
                startActivity(i);
            }
        });

        notifications_button = (ImageView) findViewById(R.id.notification);
        notifications_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NotificationsView.this, "Notifications", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(NotificationsView.this, HomeView.class));
        finish();
    }
}
