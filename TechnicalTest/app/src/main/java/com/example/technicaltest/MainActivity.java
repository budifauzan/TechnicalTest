package com.example.technicaltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

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
        checkTextChanges();
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
                getDatafromAPI(edtNama.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void getDatafromAPI(String nama) {

    }
}