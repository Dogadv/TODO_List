package org.dogadaev.todolist.infrastructure.di;

import org.dogadaev.todolist.application.TodoApplication;
import org.dogadaev.todolist.data.TaskItemDao;
import org.dogadaev.todolist.data.TaskItemDatabase;
import org.dogadaev.todolist.data.repository.TaskItemRepository;
import org.dogadaev.todolist.presentation.vm.MainViewModelFactory;

import javax.inject.Singleton;

import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private final TaskItemDatabase database;

    public RoomModule(TodoApplication application) {
        this.database = Room.databaseBuilder(
                application,
                TaskItemDatabase.class,
                "TaskItem.db"
        ).build();
    }

    @Provides
    @Singleton
    TaskItemRepository provideTaskItemRepository(TaskItemDao taskItemDao) { return new TaskItemRepository(taskItemDao); }

    @Provides
    @Singleton
    TaskItemDao provideTaskItemDao(TaskItemDatabase database) { return  database.taskItemDao(); }

    @Provides
    @Singleton
    TaskItemDatabase provideTaskItemDatabase() { return database; }
}
