package com.kye.mycinema.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kye.mycinema.activity.MainActivity;
import com.kye.mycinema.R;
import com.kye.mycinema.data.ImageLoadTask;


public class SecondFragment extends Fragment {

    String title,sec_img;
    float rate;
    int id,grade;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_second,container,false);
        TextView txt_title = viewGroup.findViewById(R.id.frag_title);
        TextView txt_rate = viewGroup.findViewById(R.id.txt_rate);
        TextView txt_grade = viewGroup.findViewById(R.id.txt_grade);
        ImageView imageView = viewGroup.findViewById(R.id.sec_img);
        ProgressBar progressBar = viewGroup.findViewById(R.id.progressBar);

        if(getArguments()!=null){
            id = getArguments().getInt("id");
            title = getArguments().getString("title");
            rate = getArguments().getFloat("rate");
            grade = getArguments().getInt("grade");
            sec_img = getArguments().getString("image");
            txt_title.setText(id+"."+ title);
            txt_rate.setText("예매율 : " + rate + "%");
            txt_grade.setText(grade+"세 관람가");
        }

        String url = sec_img;
        ImageLoadTask task = new ImageLoadTask(url,imageView,progressBar);
        task.execute();

        Button detail_btn = viewGroup.findViewById(R.id.detail_btn);
        detail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onActivity(1);
            }
        });

        return viewGroup;
    }

}
