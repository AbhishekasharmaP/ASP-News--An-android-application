package com.example.ASP_News;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TechnologyFragment extends Fragment {
    String api="4c9229f8636f43dba7c9404b67e384fc";
    ArrayList<jsonClass> jsonClassArrayList;
    Adapter adapter;
    String country="in";
    private RecyclerView recyclerViewoftech;
    private String category="technology";

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.technologyfragment,null);
        recyclerViewoftech=v.findViewById(R.id.recyclerviewoftech);
        jsonClassArrayList=new ArrayList<>();
        recyclerViewoftech.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),jsonClassArrayList);
        recyclerViewoftech.setAdapter(adapter);

        findNews();
        return v;
    }

    private void findNews() {

        ApiUtilities.getApiInterface().getcategoryNews(country,category,50,api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if(response.isSuccessful()){
                    jsonClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }
}
