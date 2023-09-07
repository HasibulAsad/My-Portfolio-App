package com.app.myportfolio.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.myportfolio.Model.PortfolioModel;
import com.app.myportfolio.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PortfolioRvAdapter extends RecyclerView.Adapter<PortfolioRvAdapter.Viewholder> {

    Context context;
    ArrayList<PortfolioModel> portfoliodatalist = new ArrayList<>();
    int lastpos = -1;
    ClickInterface clickInterface;

    public PortfolioRvAdapter(Context context, ArrayList<PortfolioModel> portfoliodatalist, ClickInterface clickInterface) {
        this.context = context;
        this.portfoliodatalist = portfoliodatalist;
        this.clickInterface = clickInterface;
    }

    @NonNull
    @Override
    public PortfolioRvAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(context).inflate(R.layout.portfolio_rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PortfolioRvAdapter.Viewholder holder, int position) {
        PortfolioModel model = portfoliodatalist.get(position);
        Picasso.get().load(model.getImage()).into(holder.projectImage);
        holder.projectName.setText(model.getProjectName());
        holder.clientName.setText(model.getClientName());
        holder.language.setText(model.getLanguage());
        holder.preview.setText(model.getPreviewString());
        setAnimation(holder.itemView, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInterface.itemClickListener(position);
            }
        });

    }

    private void setAnimation(View itemView, int position) {
        if (position > lastpos) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            itemView.setAnimation(animation);
            lastpos = position;
        }
    }

    @Override
    public int getItemCount() {
        return portfoliodatalist.size();
    }

    public interface ClickInterface {

        void itemClickListener(int position);

        void itemLongOnClickListener(int position);
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView projectImage;
        TextView projectName, clientName, language, preview;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            projectImage = itemView.findViewById(R.id.idportfolioimage);
            projectName = itemView.findViewById(R.id.idprojectname);
            clientName = itemView.findViewById(R.id.idclient);
            language = itemView.findViewById(R.id.idlanguage);
            preview = itemView.findViewById(R.id.idpreview);

        }
    }
}
