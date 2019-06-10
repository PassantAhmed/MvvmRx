package com.iti.intake39.jad.mvvm_rx_example.screens.listscreen;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.iti.intake39.jad.mvvm_rx_example.R;
import com.iti.intake39.jad.mvvm_rx_example.screens.additemscreen.AddItemActivity;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ListRecyclerviewAdapter listAdapter;
    FloatingActionButton addButton;

    ListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initComponents();
    }

    private void initComponents(){
        recyclerView = findViewById(R.id.recycler_view);
        addButton = findViewById(R.id.addBtn);
        initViewModel();
        initRecyclerviewComponents();
        addButton.setOnClickListener((v)-> {
            Intent intent = new Intent(ListActivity.this, AddItemActivity.class);
            startActivity(intent);}
        );
    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
    }

    private void initRecyclerviewComponents(){
        listAdapter = new ListRecyclerviewAdapter(viewModel.getCharacters(),this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    protected void onDestroy() {
        listAdapter.getDisposable().dispose();
        super.onDestroy();
    }
}
