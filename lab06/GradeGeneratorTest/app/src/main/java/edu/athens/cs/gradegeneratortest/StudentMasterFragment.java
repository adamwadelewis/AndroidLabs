package edu.athens.cs.gradegeneratortest;

/**
 * Created by alewis on 2/3/17.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StudentMasterFragment extends Fragment {
    Cohort myCohort = Cohort.getCohort();
    private TextView studentEntryField;
    private EditText studentGradeField;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.studentmaster,container,false);
        // Wire the edit text
        studentEntryField = (TextView) v.findViewById(R.id.student_name);

        studentGradeField = (EditText) v.findViewById(R.id.student_grade);

        // Now add a listener for the done button
        studentGradeField.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            updateText((TextView) v);
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });
        studentGradeField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int imeEvent, KeyEvent keyEvent) {
                if (imeEvent == EditorInfo.IME_ACTION_GO) {
                    updateText(textView);
                }
                return false;
            }
        });
        String firstStudent = myCohort.getAStudent();
        studentEntryField.setText(firstStudent);
        studentGradeField.setText(myCohort.getStudentGrade(firstStudent).toString());
        return v;
    }

    private void updateText(TextView textView) {
        String name = studentEntryField.getText().toString();
        String s = textView.getText().toString();
        Integer grade = Integer.parseInt(s);
        if (myCohort.contains(name)) {
            myCohort.setGrade(name, grade);
            Toast.makeText(getActivity(), R.string.strExistsWarning, Toast.LENGTH_LONG).show();
        } else {
            myCohort.addStudent(name, grade);
            Toast.makeText(getActivity(), R.string.strNotExistsAdded, Toast.LENGTH_LONG).show();
        }
    }
}
