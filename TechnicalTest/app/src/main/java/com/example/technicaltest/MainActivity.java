package com.example.technicaltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText edtNama;
    private RecyclerView rvNama;
    private ArrayList<UserModel> userModels = new ArrayList<>();
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiateViews();
        setRecyclerView();
//        checkTextChanges();
        getDatafromAPI();
    }

    private void initiateViews() {
        edtNama = findViewById(R.id.edt_main_nama);
        rvNama = findViewById(R.id.rv_main_nama);
    }

    private void setRecyclerView() {
        userAdapter = new UserAdapter(this, userModels);
        rvNama.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rvNama.setAdapter(userAdapter);
    }

    private void checkTextChanges() {
        edtNama.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void getDatafromAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<ArrayList<UserModel>> call = retrofitAPI.getAllData();
        call.enqueue(new Callback<ArrayList<UserModel>>() {
            @Override
            public void onResponse(Call<ArrayList<UserModel>> call, Response<ArrayList<UserModel>> response) {
                if (response.isSuccessful()) {

                    userModels = response.body();

                    for (int i = 0; i < userModels.size(); i++) {
                        userAdapter = new UserAdapter(MainActivity.this, userModels);
                        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
                        rvNama.setLayoutManager(manager);
                        rvNama.setAdapter(userAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<UserModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}