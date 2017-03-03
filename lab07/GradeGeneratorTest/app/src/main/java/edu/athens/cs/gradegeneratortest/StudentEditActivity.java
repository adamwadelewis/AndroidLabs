package edu.athens.cs.gradegeneratortest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * Created by alewis on 3/2/17.
 */

public class StudentEditActivity extends FragmentActivity {
    // Add adapter for view paging
    public static class StudentViewPagerAdapter extends FragmentPagerAdapter {
        private Cohort mCohort = Cohort.getCohort();

        public StudentViewPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            List<String> studentList = mCohort.buildAList();
            String studentName = studentList.get(position);
            return StudentMasterFragment.newInstance(studentName);
        }

        @Override
        public int getCount() {
            return mCohort.buildAList().size();
        }
    }

    private String studentName;
    private ViewPager vpPager;
    private FragmentPagerAdapter adapterViewPager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Setup the view pager for editing
        vpPager = (ViewPager) findViewById(R.id.studentvp);
        adapterViewPager = new StudentViewPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
    }

    public void setDisplay(String name) {
        List<String> studentNames = Cohort.getCohort().buildAList();
        int position = studentNames.indexOf(name);
        vpPager.setCurrentItem(position);
    }
}
