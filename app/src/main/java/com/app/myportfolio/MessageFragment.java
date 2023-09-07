package com.app.myportfolio;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.app.myportfolio.Adapter.SkillRVAdapter;
import com.app.myportfolio.Model.SkillRvModel;

import java.util.ArrayList;


public class MessageFragment extends Fragment {


    Button sendemailbtn;
    EditText sendername, sendto, subject, body;

    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        sendemailbtn = view.findViewById(R.id.idbtnsendemail);
        sendername = view.findViewById(R.id.idedtname);
        sendto = view.findViewById(R.id.idedtemail);
        subject = view.findViewById(R.id.idedtsubject);
        body = view.findViewById(R.id.idedtemailbody);

        sendemailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailsend = sendto.getText().toString();
                String emailsubject = subject.getText().toString();
                String emailbody = body.getText().toString();

                // define Intent object with action attribute as ACTION_SEND
                Intent intent = new Intent(Intent.ACTION_SEND);

                // add three fields to intent using putExtra function
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"developerhasib2020@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, emailsubject);
                intent.putExtra(Intent.EXTRA_TEXT, emailbody);

                // set type of intent
                intent.setType("message/rfc822");

                // startActivity with intent with chooser as Email client using createChooser function
                getContext().startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });


        return view;
    }
}