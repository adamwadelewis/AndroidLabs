package edu.athens.cs.gradegeneratortest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GradeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        FragmentManager fm = getFragmentManager();
        Fragment fragment_grade = fm.findFragmentById(R.id.fragment_container_grade);
        if (fragment_grade == null) {
            fragment_grade = new StudentMasterFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container_grade,fragment_grade)
                    .commit();
        }
        Fragment fragment_nav = fm.findFragmentById(R.id.fragment_container_nav);
        if (fragment_nav == null) {
            fragment_nav = new NavigationFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container_nav,fragment_nav)
                    .commit();
        }
    }
}
