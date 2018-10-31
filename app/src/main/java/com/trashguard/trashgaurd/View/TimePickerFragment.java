package com.trashguard.trashgaurd.View;

import android.app.TimePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import com.trash.trashguard.R;
import java.util.Calendar;

public class TimePickerFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int hour  = calendar.get(Calendar.HOUR_OF_DAY);
        int minute  = calendar.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),R.style.DatePicker,(TimePickerDialog.OnTimeSetListener) getActivity(), hour,minute,false);
    }
}
