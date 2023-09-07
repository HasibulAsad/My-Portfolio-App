package com.app.myportfolio;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.app.myportfolio.Adapter.BlogRvAdapter;
import com.app.myportfolio.Model.BlogDataModel;
import com.wessam.library.NetworkChecker;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ChatFragment extends Fragment {

    RecyclerView chatrecyclerview;
    ArrayList<BlogDataModel> blogdatalist = new ArrayList<>();
    BlogRvAdapter blogRvAdapter;
    Context context;
    String[] blogimagearray = {"https://www.mizanurrmizan.info/wp-content/uploads/2023/02/chatgpt.jpg"
            , "https://static.javatpoint.com/tutorial/ai/images/future-of-artificial-intelligence.png"
            , "https://chromeunboxed.com/wp-content/uploads/2023/03/Google-Bard-Feature.png"
            , "https://www.analyticsinsight.net/wp-content/uploads/2022/04/AI.jpg"
            , "https://admin.tops-int.com/storage/blog/icons/86206.jpg"
            , "https://www.digitalmarketingjaipur.com/img/android-app-marketing-company-in-jaipur.jpg"
            , "https://i1.sndcdn.com/artworks-bddhvc2PHQdn9Og3-pHBYcw-t500x500.jpg"
    };

    public ChatFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        chatrecyclerview = view.findViewById(R.id.idchatRv);

        String url = "https://www.googleapis.com/blogger/v3/blogs/922710019220217542/posts?key=AIzaSyBKAdYG4mZiFhfW_Xea9AdCb3wNzlAVQyI";

        RequestQueue queue = Volley.newRequestQueue(getContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("response", response.toString());
                        try {
                            JSONArray jsonArray = response.getJSONArray("items");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject blogitem = jsonArray.getJSONObject(i);
                                String title = blogitem.getString("title");
                                String description = blogitem.getString("content");
                                blogdatalist.add(new BlogDataModel(blogimagearray[i], title, description));
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                        blogRvAdapter = new BlogRvAdapter(getContext(), blogdatalist, new BlogRvAdapter.ClickInterface() {
                            @Override
                            public void itemClickListener(int position) {

                            }
                        });
                        chatrecyclerview.setHasFixedSize(true);
                        chatrecyclerview.setAdapter(blogRvAdapter);
                        chatrecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                    }
                });

        queue.add(jsonObjectRequest);

        return view;
    }

    @Override
    public void onStart() {
        if (NetworkChecker.isNetworkConnected(getContext())) {
            super.onStart();
        } else {
            super.onStart();
            new AlertDialog.Builder(getContext())
                    .setTitle("No Internet")
                    .setCancelable(true)
                    .setMessage("Please Check Your Internet Connection..")
                    .setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            onStart();
                        }
                    })
                    .create()
                    .show();
            Toast.makeText(getContext(), "Please Connect to the Internet..", Toast.LENGTH_SHORT).show();
        }
    }
}