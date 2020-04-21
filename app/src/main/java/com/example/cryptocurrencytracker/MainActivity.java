package com.example.cryptocurrencytracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;

  //  @BindView(R.id.progressBar)
   // ProgressBar progressBar;

    @BindView(R.id.spinner)
    Spinner spinner;

    APIService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Butterknife.bind(this);

        service = RestClient.getService();

        final ArrayList<CurrencyTracker> currencyTrackers = new ArrayList<>();

      //  progressBar.setVisibility(VISIBLE);

        service.getCurrency().enqueue(new Callback<List<CurrencyTracker>>() {
            @Override
            public void onResponse(Call<List<CurrencyTracker>> call, Response<List<CurrencyTracker>> response) {
                Log.d(TAG, "onResponse: " + response.body().toString());

                currencyTrackers.addAll(response.body());

                recyclerView.setAdapter(new RecyclerAdapter(currencyTrackers));

               // progressBar.setVisibility(GONE);
            }

            @Override
            public void onFailure(Call<List<CurrencyTracker>> call, Throwable t) {

                t.printStackTrace();
                Toast.makeText(MainActivity.this, "Não foi possível executar a operação.", Toast.LENGTH_SHORT).show();

            }
        });

        RecyclerAdapter adapter = new RecyclerAdapter(currencyTrackers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

    }
}
