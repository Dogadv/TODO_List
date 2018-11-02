package org.dogadaev.todolist.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.dogadaev.todolist.R;
import org.dogadaev.todolist.data.model.TaskItem;
import org.dogadaev.todolist.presentation.vm.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {

    private List<TaskItem> data = new ArrayList<>();
    private MainViewModel mainViewModel;

    public MainRecyclerAdapter(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_main_recycler_item, parent, false);
        return new ViewHolder(itemView, mainViewModel);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<TaskItem> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_title)
        TextView itemTitle;
        @BindView(R.id.delete_button)
        ImageView deleteButton;

        private MainViewModel mainViewModel;

        public ViewHolder(@NonNull View itemView, MainViewModel mainViewModel) {
            super(itemView);
            this.mainViewModel = mainViewModel;
            ButterKnife.bind(this, itemView);
        }

        public void bind(TaskItem taskItem) {
            itemTitle.setText(taskItem.getTitle());
            deleteButton.setOnClickListener(v -> mainViewModel.deleteTaskItem(taskItem));
        }
    }
}