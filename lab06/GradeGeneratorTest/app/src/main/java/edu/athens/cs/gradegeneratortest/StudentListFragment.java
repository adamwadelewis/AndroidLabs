package edu.athens.cs.gradegeneratortest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by alewis on 2/23/17.
 */

public class StudentListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView listView = (RecyclerView) inflater.inflate(R.id.studentList,container, false);
        StudentAdapter adapter = new StudentAdapter(Cohort.getCohort().buildAList(),this.getContext());
        listView.setAdapter(adapter);
        listView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return listView;
    }
}
