package com.app.myportfolio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.myportfolio.Adapter.PortfolioRvAdapter;
import com.app.myportfolio.Model.PortfolioModel;

import java.util.ArrayList;


public class PortfolioFragment extends Fragment {

    RecyclerView portfolioRv;
    ArrayList<PortfolioModel> portfoliodatalist = new ArrayList<>();
    PortfolioRvAdapter adapter;

    public PortfolioFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_portfolio, container, false);


        portfolioRv = view.findViewById(R.id.idportfolioRV);


        portfoliodatalist.add(new PortfolioModel("https://miro.medium.com/v2/resize:fit:1200/0*h6ef2O6yaieruGg2.png"
                , "Project Name", "Client Name", "Java,kotlin,javascript", "this is preview"));
        portfoliodatalist.add(new PortfolioModel("https://miro.medium.com/v2/resize:fit:1200/0*h6ef2O6yaieruGg2.png"
                , "Project Name", "Client Name", "Java,kotlin,javascript", "this is preview"));
        portfoliodatalist.add(new PortfolioModel("https://miro.medium.com/v2/resize:fit:1200/0*h6ef2O6yaieruGg2.png"
                , "Project Name", "Client Name", "Java,kotlin,javascript", "this is preview"));
        portfoliodatalist.add(new PortfolioModel("https://miro.medium.com/v2/resize:fit:1200/0*h6ef2O6yaieruGg2.png"
                , "Project Name", "Client Name", "Java,kotlin,javascript", "this is preview"));
        portfoliodatalist.add(new PortfolioModel("https://miro.medium.com/v2/resize:fit:1200/0*h6ef2O6yaieruGg2.png"
                , "Project Name", "Client Name", "Java,kotlin,javascript", "this is preview"));
        portfoliodatalist.add(new PortfolioModel("https://miro.medium.com/v2/resize:fit:1200/0*h6ef2O6yaieruGg2.png"
                , "Project Name", "Client Name", "Java,kotlin,javascript", "this is preview"));
        portfoliodatalist.add(new PortfolioModel("https://miro.medium.com/v2/resize:fit:1200/0*h6ef2O6yaieruGg2.png"
                , "Project Name", "Client Name", "Java,kotlin,javascript", "this is preview"));
        portfoliodatalist.add(new PortfolioModel("https://miro.medium.com/v2/resize:fit:1200/0*h6ef2O6yaieruGg2.png"
                , "Project Name", "Client Name", "Java,kotlin,javascript", "this is preview"));
        portfoliodatalist.add(new PortfolioModel("https://miro.medium.com/v2/resize:fit:1200/0*h6ef2O6yaieruGg2.png"
                , "Project Name", "Client Name", "Java,kotlin,javascript", "this is preview"));
        portfoliodatalist.add(new PortfolioModel("https://miro.medium.com/v2/resize:fit:1200/0*h6ef2O6yaieruGg2.png"
                , "Project Name", "Client Name", "Java,kotlin,javascript", "this is preview"));
        portfoliodatalist.add(new PortfolioModel("https://miro.medium.com/v2/resize:fit:1200/0*h6ef2O6yaieruGg2.png"
                , "Project Name", "Client Name", "Java,kotlin,javascript", "this is preview"));
        portfoliodatalist.add(new PortfolioModel("https://miro.medium.com/v2/resize:fit:1200/0*h6ef2O6yaieruGg2.png"
                , "Project Name", "Client Name", "Java,kotlin,javascript", "this is preview"));
        portfoliodatalist.add(new PortfolioModel("https://miro.medium.com/v2/resize:fit:1200/0*h6ef2O6yaieruGg2.png"
                , "Project Name", "Client Name", "Java,kotlin,javascript", "this is preview"));

        portfolioRv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PortfolioRvAdapter(getContext(), portfoliodatalist, new PortfolioRvAdapter.ClickInterface() {
            @Override
            public void itemClickListener(int position) {

            }

            @Override
            public void itemLongOnClickListener(int position) {

            }
        });
        portfolioRv.setAdapter(adapter);
        portfolioRv.setHasFixedSize(true);

        return view;
    }
}