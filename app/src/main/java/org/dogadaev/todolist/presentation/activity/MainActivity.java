package org.dogadaev.todolist.presentation.activity;

import android.os.Bundle;
import android.widget.EditText;

import org.dogadaev.todolist.R;
import org.dogadaev.todolist.application.TodoApplication;
import org.dogadaev.todolist.data.model.TaskItem;
import org.dogadaev.todolist.presentation.adapter.MainRecyclerAdapter;
import org.dogadaev.todolist.presentation.vm.MainViewModel;
import org.dogadaev.todolist.presentation.vm.MainViewModelFactory;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_recycler)
    RecyclerView recyclerView;
    @BindView(R.id.main_edit_text)
    EditText editText;

    @Inject
    MainViewModelFactory mainViewModelFactory;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TodoApplication) getApplication()).getApplicationComponent().inject(this);
        mainViewModel = ViewModelProviders.of(this, mainViewModelFactory).get(MainViewModel.class);

        ButterKnife.bind(this);

        MainRecyclerAdapter mainRecyclerAdapter = new MainRecyclerAdapter(mainViewModel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mainRecyclerAdapter);
        mainViewModel.getTaskItems().observe(this, mainRecyclerAdapter::setData);

        findViewById(R.id.main_button).setOnClickListener(v -> {
            mainViewModel.insertTaskItem(new TaskItem((mainRecyclerAdapter.getItemCount() + 1) + "", editText.getText().toString()));
            editText.getText().clear();
        });
    }
}
