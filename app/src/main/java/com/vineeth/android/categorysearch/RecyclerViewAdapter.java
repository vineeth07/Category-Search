package com.vineeth.android.categorysearch;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vineeth on 3/19/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> implements Filterable {

    private List<Model> mList = new ArrayList<>();
    private List<Model> filterlist = new ArrayList<>();
    private Context mContext;
    private RowFilter rowFilter;
    private String TAG = "RecyclerViewAdapter";

    public RecyclerViewAdapter(List<Model> list, Context context) {
        mList = list;
        mContext = context;
        filterlist = list;
        getFilter();
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.recycler_item,parent,false);
        myViewHolder viewHolder  = new myViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {

        holder.outerText.setText(filterlist.get(position).getId());
        holder.bindRecycler(filterlist.get(position).getArrayList());

    }

    @Override
    public int getItemCount() {
        return filterlist.size();
    }

    @Override
    public Filter getFilter() {
        if(rowFilter==null)
        {
            rowFilter = new RowFilter();
        }
        return rowFilter;
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

            linearLayout.removeAllViews();
            for (int i = 0; i < list.size(); i++) {
                View view = LayoutInflater.from(mContext).inflate(R.layout.inner_text,linearLayout,false);
                ((TextView)view.findViewById(R.id.innertext)).setText(list.get(i));
                linearLayout.addView(view);
            }
        }
    }



    public class RowFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            if(charSequence!=null&&charSequence.length()>0)
            {
                Log.d(TAG,charSequence.toString());
                ArrayList<Model> templist = new ArrayList<>();

                for(Model model:mList)
                {
                    if(model.getId().toLowerCase().contains(charSequence.toString().toLowerCase()))
                    {
                        templist.add(model);
                    }

                    for(String s : model.getArrayList()){
                        List<String> result = new ArrayList<>();
                        if(s.toLowerCase().equals(charSequence.toString().toLowerCase())){
                            result.add(s);
                            templist.add(new Model(model.getId(), result));
                        }
                    }

                }
                filterResults.count = templist.size();
                filterResults.values = templist;
            }
            else
            {
                filterResults.count = mList.size();
                filterResults.values = mList;
            }
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            filterlist = (ArrayList<Model>)filterResults.values;
            notifyDataSetChanged();
        }
    }
}
