package org.dogadaev.todolist.presentation.vm;

import org.dogadaev.todolist.data.model.TaskItem;
import org.dogadaev.todolist.data.repository.TaskItemRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private TaskItemRepository repository;

    MainViewModel(TaskItemRepository repository) {
        this.repository = repository;
    }

    public LiveData<List<TaskItem>> getTaskItems() {
        return repository.getTaskItems();
    }

    public void insertTaskItem(TaskItem taskItem) {
        Single.create(emitter -> emitter.onSuccess(repository.insertTaskItem(taskItem)))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public void deleteTaskItem(TaskItem taskItem) {
        Completable.create(emitter -> {
            repository.deleteTaskItem(taskItem);
            emitter.onComplete();
        })
                .subscribeOn(Schedulers.io())
                .subscribe();
    }
}