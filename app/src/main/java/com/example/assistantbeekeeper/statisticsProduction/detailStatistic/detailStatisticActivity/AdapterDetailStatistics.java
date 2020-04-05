package com.example.assistantbeekeeper.statisticsProduction.detailStatistic.detailStatisticActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assistantbeekeeper.R;
import com.example.assistantbeekeeper.statisticsProduction.detailStatistic.models.OperationsData;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterDetailStatistics extends RecyclerView.Adapter<ViewHolderDetailStatistics> {

    private ArrayList<OperationsData> articles;

    public AdapterDetailStatistics(ArrayList<OperationsData> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public ViewHolderDetailStatistics onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View operationsRow=layoutInflater.inflate(R.layout.recycleview_list_of_operations, parent, false);
        return new ViewHolderDetailStatistics(operationsRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDetailStatistics holder, int position) {
        TextView dateOperation=holder.itemView.findViewById(R.id.dateOperations);
        TextView descriptionOperation=holder.itemView.findViewById(R.id.descriptionOperation);
        TextView valueOperation=holder.itemView.findViewById(R.id.valueOperation);

        //todo

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
