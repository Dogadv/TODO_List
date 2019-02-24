package org.dogadaev.todolist.presentation.activity;

import android.os.Bundle;
import android.widget.EditText;

import org.dogadaev.todolist.R;
import org.dogadaev.todolist.application.TodoApplication;
import org.dogadaev.todolist.data.model.TaskItem;
import org.dogadaev.todolist.presentation.adapter.MainRecyclerAdapter;
import org.dogadaev.todolist.presentation.vm.MainViewModel;

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

    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainViewModel =
                ViewModelProviders.of(
                        this,
                        ((TodoApplication) getApplication())
                                .getMainViewModelFactory()
                ).get(MainViewModel.class
                );

        setUpRecycler();

        findViewById(R.id.main_button).setOnClickListener(v -> {
            mainViewModel.insertTaskItem(
                    new TaskItem(editText.getText().toString())
            );
            editText.getText().clear();
        });
    }

    private void setUpRecycler() {
        MainRecyclerAdapter mainRecyclerAdapter = new MainRecyclerAdapter(mainViewModel);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mainRecyclerAdapter);
        mainViewModel.getTaskItems().observe(this, mainRecyclerAdapter::setData);
    }
}
