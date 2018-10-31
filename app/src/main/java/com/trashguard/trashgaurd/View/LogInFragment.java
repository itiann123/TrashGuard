package com.trashguard.trashgaurd.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.trash.trashguard.R;
import com.trashguard.trashgaurd.Presenter.Interaface.ILogInPresenter;
import com.trashguard.trashgaurd.Presenter.LogInPresenter;

public class LogInFragment  extends Fragment {

    ILogInPresenter logInPresenter;

    View view;

    public LogInFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_login,container,false);

        return view;
    }
}
