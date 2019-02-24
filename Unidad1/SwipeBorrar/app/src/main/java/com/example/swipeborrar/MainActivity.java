package com.example.swipeborrar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.daimajia.swipe.util.Attributes;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tvEmptyTextView;
    private RecyclerView mRecyclerView;
    private ArrayList<YoutuberModel> mDataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvEmptyTextView = (TextView) findViewById(R.id.empty_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDataSet = new ArrayList<>();

        loadData();

        if(mDataSet.isEmpty()){
            mRecyclerView.setVisibility(View.GONE);
            tvEmptyTextView.setVisibility(View.VISIBLE);
        }else{
            mRecyclerView.setVisibility(View.VISIBLE);
            tvEmptyTextView.setVisibility(View.GONE);
        }

        SwipeRecyclerViewAdapter mAdapter = new SwipeRecyclerViewAdapter(this, mDataSet);

        ((SwipeRecyclerViewAdapter) mAdapter).setMode(Attributes.Mode.Single);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("RecyclerView", "onScrollStateChanged");
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
    public void loadData() {
        for (int i = 0; i <= 20; i++) {

            mDataSet.add(new YoutuberModel("ARANDA PATRON NOMAR JAZIEL", "No.Control", "Carrera",R.drawable.basura));
            mDataSet.add(new YoutuberModel ("CARDENAS RAMOS FRANCISCO EMANUEL", "No.Control", "Carrera",R.drawable.basura));
            mDataSet.add(new YoutuberModel("CASTILLO CORRALES VICTOR EMMANUEL", "No.Control","Carrera",R.drawable.basura));
            mDataSet.add(new YoutuberModel("CERVANTES JIMÉNEZ JOSÉ MIGUEL", "No.Control", "Carrera",R.drawable.basura));
            mDataSet.add(new YoutuberModel("CORDERO RIVERA SELVA YAZMIN", "No.Control", "Carrera",R.drawable.basura));
            mDataSet.add(new YoutuberModel("CORDERO VILLA OSCAR ALBERTO", "No.Control", "Carrera",R.drawable.basura));
            mDataSet.add(new YoutuberModel("ESPINOSA ABANDO DENISSE YANETH", "No.Control", "Carrera",R.drawable.basura));
            mDataSet.add(new YoutuberModel("FIGUEROA CUETO JUAN RAMON", "No.Control", "Carrera",R.drawable.basura));
            mDataSet.add(new YoutuberModel("GALLEGOS GODINEZ FRANCISCO JAVIER", "No.Control", "Carrera",R.drawable.basura));
            mDataSet.add(new YoutuberModel("GIL LLANOS JUAN PEDRO", "No.Control", "Carrera",R.drawable.basura));
            mDataSet.add(new YoutuberModel("GONZALEZ ARELLANO ERNESTO", "No.Control", "Carrera",R.drawable.basura));

        }
    }

}
