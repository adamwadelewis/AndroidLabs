package edu.athens.cs.gradegeneratortest;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * Created by alewis on 3/1/17.
 */

public class StudentDetailPager extends FragmentActivity {
    private static final String STUDENT_ID = "StudentName";
    private ViewPager mViewPager;
    private List<String> mStudentList;
    private String studentName;

    public static Intent newIntent(Context packageContext, String stuName){
        Intent intent = new Intent(packageContext, StudentDetailPager.class);
        intent.putExtra(STUDENT_ID, stuName);
        return intent;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentdetail);


        studentName = (String) getIntent().getSerializableExtra(STUDENT_ID);
        mViewPager = (ViewPager) findViewById(R.id.studentpager);
        mStudentList = Cohort.getCohort().buildAList();

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                String studentName = mStudentList.get(position);
                return StudentMasterFragment.newInstance(studentName);
            }

            @Override
            public int getCount() {
                return 0;
            }
        });
        for (Integer i = 0; i < mStudentList.size(); i++) {
            if (mStudentList.get(i).equals(studentName)) {
                mViewPager.setCurrentItem(i);
            }
        }
    }
}
