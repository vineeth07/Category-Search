package com.vineeth.android.categorysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vineeth on 3/19/2018.
 */

public class Model {
    String id;
    List<String> arrayList = new ArrayList<>();



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
