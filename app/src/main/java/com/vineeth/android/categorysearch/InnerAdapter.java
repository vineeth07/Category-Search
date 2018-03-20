package com.vineeth.android.categorysearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vineeth on 3/19/2018.
 */

public class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.innerViewHolder> {

    private List<String> mList;
    private Context mContext;

    public InnerAdapter(List<String> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public innerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.inner_text,parent,false);
        innerViewHolder viewHolder = new innerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(innerViewHolder holder, int position) {

        holder.innerText.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class innerViewHolder extends RecyclerView.ViewHolder{
        TextView innerText;
        public innerViewHolder(View itemView) {
            super(itemView);
            innerText = itemView.findViewById(R.id.inner_text);
        }
    }
}
