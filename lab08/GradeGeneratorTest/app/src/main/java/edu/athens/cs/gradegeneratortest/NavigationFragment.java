package edu.athens.cs.gradegeneratortest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by alewis on 2/22/17.
 */

public class NavigationFragment extends Fragment {
    Button mPrevButton;
    Button mNextButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.navigation_fragment,container,false);
        mNextButton = (Button) v.findViewById(R.id.next_student);
        mPrevButton = (Button) v.findViewById(R.id.prev_student);

        mNextButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               // Do nothing for now
                                           }
                                       }
        );

        mPrevButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               // Do nothing for now
                                           }
                                       }
        );
        return v;
    }

}
