package com.app.myportfolio.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.myportfolio.Model.SkillRvModel;
import com.app.myportfolio.R;

import java.util.ArrayList;

import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;

public class SkillRVAdapter extends RecyclerView.Adapter<SkillRVAdapter.Viewholder> {
    Context context;
    ArrayList<SkillRvModel> skilllist;

    public SkillRVAdapter(Context context, ArrayList<SkillRvModel> skilllist) {
        this.context = context;
        this.skilllist = skilllist;
    }

    @NonNull
    @Override

    public SkillRVAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(context).inflate(R.layout.skills_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SkillRVAdapter.Viewholder holder, int position) {
        SkillRvModel skillmodel = skilllist.get(position);
        holder.circularProgressIndicator.setProgress(skillmodel.getCurrentprogress(), skillmodel.getMaxprogress());
        holder.skilllanguage.setText(skillmodel.getLanguageName());
    }

    @Override
    public int getItemCount() {
        return skilllist.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView skilllanguage;
        CircularProgressIndicator circularProgressIndicator;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            skilllanguage = itemView.findViewById(R.id.idskilllanguage);
            circularProgressIndicator = itemView.findViewById(R.id.circular_progress);
        }
    }
}
