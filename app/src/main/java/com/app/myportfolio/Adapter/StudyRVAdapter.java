package com.app.myportfolio.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.myportfolio.Model.StudydataModel;
import com.app.myportfolio.R;

import java.util.ArrayList;

public class StudyRVAdapter extends RecyclerView.Adapter<StudyRVAdapter.Viewholder> {

    Context context;
    ArrayList<StudydataModel> studydatalist;

    public StudyRVAdapter(Context context, ArrayList<StudydataModel> studydatalist) {
        this.context = context;
        this.studydatalist = studydatalist;
    }

    @NonNull
    @Override
    public StudyRVAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(context).inflate(R.layout.study_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudyRVAdapter.Viewholder holder, int position) {
        StudydataModel studydataModel = studydatalist.get(position);
        holder.jobtime.setText(studydataModel.getJobtime());
        holder.jobtitle.setText(studydataModel.getJobtitle());
        holder.jobcompany.setText(studydataModel.getJobcompany());
        holder.jobdescription.setText(studydataModel.getJobdescription());
    }

    @Override
    public int getItemCount() {
        return studydatalist.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView jobtime, jobtitle, jobcompany, jobdescription;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            jobtime = itemView.findViewById(R.id.idtvstudytime);
            jobtitle = itemView.findViewById(R.id.idtvjobtitile);
            jobcompany = itemView.findViewById(R.id.idtvcompanyname);
            jobdescription = itemView.findViewById(R.id.idtvstudydescription);

        }
    }
}
