package org.dogadaev.todolist.presentation.vm;

import org.dogadaev.todolist.data.model.TaskItem;
import org.dogadaev.todolist.data.repository.TaskItemRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private TaskItemRepository repository;

    public MainViewModel(TaskItemRepository repository) {
        this.repository = repository;
    }

    public LiveData<List<TaskItem>> getTaskItems() {
        return repository.getTaskItems();
    }

    public LiveData<TaskItem> getTaskItemById(String id) {
        return repository.getTaskItemById(id);
    }

    public void insertTaskItem(TaskItem taskItem) {
        Observable.create(emitter -> repository.insertTaskItem(taskItem))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public void deleteTaskItem(TaskItem taskItem) {
        Observable.create(emitter -> repository.deleteTaskItem(taskItem))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }
}