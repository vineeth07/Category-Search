package com.vineeth.android.categorysearch;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vineeth on 3/19/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {

    private List<Model> mList = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(List<Model> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.recycler_item,parent,false);
        myViewHolder viewHolder  = new myViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {

        holder.outerText.setText(mList.get(position).getId());
        holder.bindRecycler(mList.get(position).getArrayList());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView outerText;
        LinearLayout linearLayout;

        public myViewHolder(View itemView) {
            super(itemView);
            outerText = itemView.findViewById(R.id.outertextview);
            linearLayout = itemView.findViewById(R.id.innerlayout);
        }


        public void bindRecycler(List<String> list) {

            for (int i = 0; i < list.size(); i++) {
                View view = LayoutInflater.from(mContext).inflate(R.layout.inner_text,linearLayout,false);
                ((TextView)view.findViewById(R.id.innertext)).setText(list.get(i));
                linearLayout.addView(view);
            }
        }
    }
}
