package com.vineeth.android.categorysearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private List<Model> mList = new ArrayList<>();
    private List<String> list1 = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();
    private Model mModel = new Model();
    private Model mMode2 = new Model();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.outer_recycler_view);
        list1.add("one");list1.add("two");list1.add("three");
        list2.add("A");list2.add("B");list2.add("C");
        mModel.setId("1");
        mModel.setArrayList(list1);
        mList.add(mModel);
        mMode2.setId("2");
        mMode2.setArrayList(list2);
        mList.add(mMode2);
        mRecyclerViewAdapter = new RecyclerViewAdapter(mList,this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }
}
