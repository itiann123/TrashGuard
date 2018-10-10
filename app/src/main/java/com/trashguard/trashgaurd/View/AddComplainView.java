package com.trashguard.trashgaurd.View;

import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;
import com.trash.trashguard.R;

import java.text.DateFormat;
import java.util.Calendar;

public class AddComplainView extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener {

    private Button send_button;
    private ImageButton camera_button;
    private SwipeDismissDialog swipeDismissDialog;
    private ImageView history_button;
    private ImageView home_button;
    private ImageView notifications_button;
    private TextView datePickerTextView;
    private Calendar calendar;
    private DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);

        send_button = (Button)findViewById(R.id.send_button);
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View diaolog = LayoutInflater.from(AddComplainView.this).inflate(R.layout.dialog_sent,null);

                swipeDismissDialog = new SwipeDismissDialog.Builder(AddComplainView.this)
                        .setView(diaolog)
                        .setFlingVelocity(0.04f)
                        .build()
                        .show();

            }
        });

        history_button = (ImageView) findViewById(R.id.history);
        history_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddComplainView.this, ComplaintHistoryView.class);
                startActivity(i);
            }
        });

        home_button = (ImageView) findViewById(R.id.home);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddComplainView.this, HomeView.class);
                startActivity(i);
            }
        });
        notifications_button = (ImageView) findViewById(R.id.notification);
        notifications_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddComplainView.this, NotificationsView.class);
                startActivity(i);
            }
        });

        camera_button = (ImageButton) findViewById(R.id.camera);
        camera_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        });

        datePickerTextView = (TextView) findViewById(R.id.datePicker);
        datePickerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                calendar = Calendar.getInstance();
//                final int day  = calendar.get(Calendar.DAY_OF_MONTH);
//                int month = calendar.get(Calendar.MONTH);
//                int year = calendar.get(Calendar.YEAR);

//                DatePickerDialog dialog = new DatePickerDialog(
//                        AddComplainView.this,
//                        android.R.style.Theme_Black_NoTitleBar,
//                        (DatePickerDialog.OnDateSetListener) datePickerDialog,
//                        year,month,day);
//
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();

//                datePickerDialog = new DatePickerDialog(AddComplainView.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        datePickerTextView.setText((month+1) + "/" + dayOfMonth +"/" + year);
//                    }
//                },year,month,day);
//                datePickerDialog.show();
//            }
                DialogFragment datePicker = new DatePickerFragment();

                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(AddComplainView.this, HomeView.class));
        finish();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        datePickerTextView.setText(currentDateString);
    }
}
