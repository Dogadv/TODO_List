package org.dogadaev.todolist.infrastructure.di;

import android.app.Application;

import org.dogadaev.todolist.application.TodoApplication;
import org.dogadaev.todolist.data.repository.TaskItemRepository;
import org.dogadaev.todolist.presentation.vm.MainViewModelFactory;

import javax.inject.Singleton;

import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(TodoApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(TaskItemRepository repository) { return new MainViewModelFactory(repository); }

    @Provides Application provideApplication() { return application; }
}
