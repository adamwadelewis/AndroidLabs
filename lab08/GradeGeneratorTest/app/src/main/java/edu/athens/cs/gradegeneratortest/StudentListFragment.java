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

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView listView;
        RecyclerView.LayoutManager layoutManager;
        View rootView = (View) inflater.inflate(R.layout.studentlist,container, false);
        listView = (RecyclerView) rootView.findViewById(R.id.aStudentList);
        layoutManager = new LinearLayoutManager(getActivity());
        StudentAdapter adapter = new StudentAdapter(Cohort.getCohort().buildAList(),getContext());
        listView.setAdapter(adapter);
        listView.setLayoutManager(layoutManager);
        return rootView;
    }
}
