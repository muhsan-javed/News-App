package com.muhsanjaved.newsapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.muhsanjaved.newsapp.Apis.ApiUtilities;
import com.muhsanjaved.newsapp.R;
import com.muhsanjaved.newsapp.adapters.Adapter;
import com.muhsanjaved.newsapp.models.ModelClass;
import com.muhsanjaved.newsapp.models.mainModelClass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    String api = "2abbbe26ec9f4124ac523870d936040c";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country = "in";
    private RecyclerView recyclerViewHome;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewHome = view.findViewById(R.id.recyclerViewOfHome);
        modelClassArrayList = new ArrayList<>();
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList);
        recyclerViewHome.setAdapter(adapter);
        
        findNews();

        return view;
    }

    private void findNews() {

        ApiUtilities.getApiInterface().getNews(country, 100, api).enqueue(new Callback<mainModelClass>() {
            @Override
            public void onResponse(Call<mainModelClass> call, Response<mainModelClass> response) {
                if (response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainModelClass> call, Throwable t) {
                Toast.makeText(getContext(), "Api Not Work Failed", Toast.LENGTH_SHORT).show();
            }
        });
        
    }
}