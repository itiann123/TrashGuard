package com.trashguard.trashgaurd.View;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.text.TimeZoneFormat;
import android.support.v4.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TimeFormatException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;
import com.trash.trashguard.R;

import java.text.DateFormat;
import java.util.Calendar;

public class AddComplainView extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private Button send_button;
    private ImageButton camera_button;
    private SwipeDismissDialog swipeDismissDialog;
    private ImageView history_button;
    private ImageView home_button;
    private ImageView notifications_button;
    private TextView datePickerTextView;
    private TextView timePickerTextView;
    EditText editText;

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
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
//
//                Calendar time = Calendar.getInstance();
//                int hour  = time.get(Calendar.HOUR_OF_DAY);
//                int minute  = time.get(Calendar.MINUTE);
//
//                timePickerDialog = new TimePickerDialog(AddComplainView.this, new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                        timePickerTextView.setText(hourOfDay+":"+minute);
//                    }
//                },hour,minute,false);
//                timePickerDialog.show();
            }
        });

        timePickerTextView = (TextView) findViewById(R.id.time);
        timePickerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");
            }
        });

        editText = (EditText) findViewById(R.id.editText);
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (editText.hasFocus()) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction() & MotionEvent.ACTION_MASK){
                        case MotionEvent.ACTION_SCROLL:
                            v.getParent().requestDisallowInterceptTouchEvent(false);
                            return true;
                    }
                }
                return false;
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

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//        Calendar time = Calendar.getInstance();
//        view.setIs24HourView(false);
//        time.set(Calendar.HOUR_OF_DAY,hourOfDay);
//        time.set(Calendar.MINUTE,minute);

        String timeSet = "";
        if (hourOfDay > 12) {
            hourOfDay -= 12;
            timeSet = "PM";
        } else if (hourOfDay == 0) {
            hourOfDay += 12;
            timeSet = "AM";
        } else if (hourOfDay == 12){
            timeSet = "PM";
        }else{
            timeSet = "AM";
        }

        String min = "";
        if (minute < 10)
            min = "0" + minute ;
        else
            min = String.valueOf(minute);

        // Append in a StringBuilder
        String aTime = new StringBuilder().append(hourOfDay).append(':')
                .append(min ).append(" ").append(timeSet).toString();

        timePickerTextView.setText(aTime);
    }
}
