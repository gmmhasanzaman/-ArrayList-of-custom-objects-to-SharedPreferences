package com.example.arraylistsharedpreferences;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arraylistsharedpreferences.model.ExampleItem;

import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ViewHolder> {

    private Context context;
    private List<ExampleItem> exampleItemList;

    public ExampleAdapter(Context context, List<ExampleItem> exampleItemList) {
        this.context = context;
        this.exampleItemList = exampleItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.example_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ExampleItem item = exampleItemList.get(position);
        holder.mTextViewLine1.setText(item.getmLine1());
        holder.mTextViewLine2.setText(item.getmLine2()+ " "+getItemCount());


    }

    @Override
    public int getItemCount() {
        return exampleItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewLine1;
        public TextView mTextViewLine2;

        public ViewHolder(View itemView) {
            super(itemView);

            mTextViewLine1 = itemView.findViewById(R.id.textview_line1);
            mTextViewLine2 = itemView.findViewById(R.id.textview_line_2);
        }
    }
}
