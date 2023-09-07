package com.app.myportfolio;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import com.app.myportfolio.Adapter.SkillRVAdapter;
import com.app.myportfolio.Adapter.StudyRVAdapter;
import com.app.myportfolio.Model.SkillRvModel;
import com.app.myportfolio.Model.StudydataModel;
import com.wessam.library.LayoutImage;
import com.wessam.library.NetworkChecker;
import com.wessam.library.NoInternetLayout;

import java.util.ArrayList;



public class ProfileFragment extends Fragment {

    RecyclerView skillrecycler,studyRV;
    SkillRVAdapter skilladapter;
    StudyRVAdapter studyRVAdapter;
    ArrayList<SkillRvModel> skillRvModelArrayList = new ArrayList<>();
    ArrayList<StudydataModel> studydataModelArrayList = new ArrayList<>();
    ScrollView profilescroll;

    Button downloadcvbtn;

    public ProfileFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        skillrecycler = view.findViewById(R.id.idskillsRV);
        studyRV = view.findViewById(R.id.idstudyRv);
        profilescroll = view.findViewById(R.id.idprofilescroll);
        downloadcvbtn = view.findViewById(R.id.idbtndownloadcv);

        profilescroll.fullScroll(View.FOCUS_DOWN);
        profilescroll.setSmoothScrollingEnabled(true);


        downloadcvbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (NetworkChecker.isNetworkConnected(getContext())){

                    String cvdownloadlink = "https://drive.google.com/uc?export=download&id=1ZfAWQks8KdvxjlPy-_Bdak9gQvNnGhtb";

                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(cvdownloadlink));
                    String title = URLUtil.guessFileName(cvdownloadlink,null,null);
                    request.setTitle(title);
                    request.setDescription("Downloading file please wait...");
                    String cookies = CookieManager.getInstance().getCookie(cvdownloadlink);
                    request.addRequestHeader("Cookie",cookies);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,title);

                    DownloadManager downloadManager= (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                    downloadManager.enqueue(request);

                    Toast.makeText(getContext(), "Downloading Start..", Toast.LENGTH_SHORT).show();

                } else {
                    new AlertDialog.Builder(getContext())
                            .setTitle("No Internet")
                            .setCancelable(false)
                            .setMessage("Please Check Your Internet Connection..")
                            .setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                  if (NetworkChecker.isNetworkConnected(getContext()) == false)
                                  {
                                      Toast.makeText(getContext(), "No Internet..", Toast.LENGTH_SHORT).show();
                                  }else {
                                      String cvdownloadlink = "https://drive.google.com/uc?export=download&id=1ZfAWQks8KdvxjlPy-_Bdak9gQvNnGhtb";

                                      DownloadManager.Request request = new DownloadManager.Request(Uri.parse(cvdownloadlink));
                                      String title = URLUtil.guessFileName(cvdownloadlink,null,null);
                                      request.setTitle(title);
                                      request.setDescription("Downloading file please wait...");
                                      String cookies = CookieManager.getInstance().getCookie(cvdownloadlink);
                                      request.addRequestHeader("Cookie",cookies);
                                      request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                      request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,title);

                                      DownloadManager downloadManager= (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                                      downloadManager.enqueue(request);

                                      Toast.makeText(getContext(), "Downloading Start..", Toast.LENGTH_SHORT).show();
                                  }
                                }
                            })
                            .create()
                            .show();
                }

            }
        });

        skillRvModelArrayList.add(new SkillRvModel(100,85,"Java"));
        skillRvModelArrayList.add(new SkillRvModel(100,45,"Kotlin"));
        skillRvModelArrayList.add(new SkillRvModel(100,90,"XML"));
        skillRvModelArrayList.add(new SkillRvModel(100,20,"Python"));
        skillRvModelArrayList.add(new SkillRvModel(100,30,"PHP"));
        skillRvModelArrayList.add(new SkillRvModel(100,60,"Adobe xd"));



        studydataModelArrayList.add(new StudydataModel("2021-Present","CEO - ","Momo Android Company","Android Momo is a dynamic application development company that harnesses cutting-edge technology to create innovative solutions. With a relentless focus on user experience, they strive to deliver intuitive and engaging applications, pushing the boundaries of mobile technology."));
        studydataModelArrayList.add(new StudydataModel("2019-2021","App Developer - ","Freelance","Developed many kind of Application over the world. In this time, I have developed chat app, E-Commerce app, Social media and many more."));
        studydataModelArrayList.add(new StudydataModel("2017-2018","H.S.C - ","Baya S and College","HSC is a Higher secondery certificate"));
        studydataModelArrayList.add(new StudydataModel("2015-2016","S.S.C - ","Nowhata Madrasha","SSC is Secondary School Certificate "));



        skilladapter = new SkillRVAdapter(getContext(),skillRvModelArrayList);
        skillrecycler.setAdapter(skilladapter);
        skillrecycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        skillrecycler.setHasFixedSize(true);


        studyRVAdapter = new StudyRVAdapter(getContext(),studydataModelArrayList);
        studyRV.setAdapter(studyRVAdapter);
        studyRV.setLayoutManager(new LinearLayoutManager(getContext()));
        studyRV.setHasFixedSize(true);

        return view;
    }
}