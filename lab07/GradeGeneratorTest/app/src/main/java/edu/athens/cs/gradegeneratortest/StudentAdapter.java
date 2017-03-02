package edu.athens.cs.gradegeneratortest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alewis on 2/23/17.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView nameTextView;
        public Button editButton;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.listrowname);
            editButton = (Button) itemView.findViewById(R.id.editstudent);

            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = StudentDetailPager.
                            newIntent(studentAdapterContext, listOfStudentNames.get(currentPos));
                    studentAdapterContext.startActivity(intent);
                }
            });
        }


    }
    private List<String> listOfStudentNames;
    private Context studentAdapterContext;
    private int currentPos = 0;

    public StudentAdapter(List<String> listOfStudentNames, Context studentAdapterContext) {
        this.listOfStudentNames = listOfStudentNames;
        this.studentAdapterContext = studentAdapterContext;
    }


    public Context getStudentAdapterContext() {
        return studentAdapterContext;
    }

    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View studentListView = inflater.inflate(R.layout.studentlistrow, parent, false);
        ViewHolder viewHolder = new ViewHolder(studentListView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StudentAdapter.ViewHolder holder, int position) {
        String name = listOfStudentNames.get(position);
        TextView textView = holder.nameTextView;
        textView.setText(name);
        Button button = holder.editButton;
        button.setText("Edit");
        currentPos = position;
    }

    @Override
    public int getItemCount() {
        return listOfStudentNames.size();
    }
}
