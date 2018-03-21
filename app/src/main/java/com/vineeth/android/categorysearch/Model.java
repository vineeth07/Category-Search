package com.vineeth.android.categorysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vineeth on 3/19/2018.
 */

public class Model {
    private String id;
    private List<String> arrayList = new ArrayList<>();

    public Model(String id, List<String> arrayList){
        this.id = id;
        this.arrayList = arrayList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getArrayList() {
        return arrayList;
    }

    public void setArrayList(List<String> arrayList) {
        this.arrayList = arrayList;
    }
}
