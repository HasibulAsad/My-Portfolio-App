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
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.app.myportfolio.Model.BlogDataModel;
import com.app.myportfolio.Model.PortfolioModel;
import com.app.myportfolio.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BlogRvAdapter extends RecyclerView.Adapter<BlogRvAdapter.Viewholder> {

    Context context;
    ArrayList<BlogDataModel> blogdatalist = new ArrayList<>();
    int lastpos = -1;
    ClickInterface clickInterface;

    public BlogRvAdapter(Context context, ArrayList<BlogDataModel> blogdatalist, ClickInterface clickInterface) {
        this.context = context;
        this.blogdatalist = blogdatalist;
        this.clickInterface = clickInterface;
    }


    @NonNull
    @Override
    public BlogRvAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(context).inflate(R.layout.chatrv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BlogRvAdapter.Viewholder holder, int position) {
        BlogDataModel blogDataModel = blogdatalist.get(position);
        Picasso.get().load(blogDataModel.getBlogimage()).into(holder.blogimage);
        holder.blogtitle.setText(blogDataModel.getBlogtitle());
        holder.blogdescription.setText(HtmlCompat. fromHtml(blogDataModel.getBlogdescription(), 0));
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
        return blogdatalist.size();
    }

    public interface ClickInterface {
        void itemClickListener(int position);
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView blogimage;
        TextView blogtitle, blogdescription;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            blogimage = itemView.findViewById(R.id.idivblogimage);
            blogtitle = itemView.findViewById(R.id.idivblogtitle);
            blogdescription = itemView.findViewById(R.id.idivblogdescription);
        }
    }
}
