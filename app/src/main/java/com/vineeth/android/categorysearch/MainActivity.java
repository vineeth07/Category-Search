package com.vineeth.android.categorysearch;

import android.app.SearchManager;
import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private List<Model> mList = new ArrayList<>();
    private List<String> list1 = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();
    private Model mModel = new Model();
    private Model mMode2 = new Model();
    private  String TAG = MainActivity.class.getSimpleName();
    private SearchView searchView;
    private MenuItem searchMenuItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.outer_recycler_view);
        list1.add("one");list1.add("two");list1.add("three");
        list2.add("A");list2.add("B");list2.add("C");
        mModel.setId("clubs");
        mModel.setArrayList(list1);
        mList.add(mModel);
        mMode2.setId("departments");
        mMode2.setArrayList(list2);
        mList.add(mMode2);
        Log.e(TAG,"reached here");
        mRecyclerViewAdapter = new RecyclerViewAdapter(mList,this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

         searchMenuItem = menu.findItem(R.id.search);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
         searchView.setIconifiedByDefault(true);
        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.requestFocus();

        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);




        /*searchMenuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener(){
            @Override
            public boolean onMenuItemActionExpand(MenuItem item){
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        searchView.requestFocus();
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        if (imm != null) {
                            imm.showSoftInput(searchView.findFocus(), 0);
                        }
                    }
                });
                return true;
            }
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item){
                return true;
            }

        });*/
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        searchView.clearFocus();
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        mRecyclerViewAdapter.getFilter().filter(s);
        return true;
    }


}
