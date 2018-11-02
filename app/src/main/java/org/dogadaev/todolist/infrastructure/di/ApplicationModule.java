package org.dogadaev.todolist.infrastructure.di;

import android.app.Application;

import org.dogadaev.todolist.application.TodoApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(TodoApplication application) {
        this.application = application;
    }

    @Provides Application provideApplication() { return application; }
}
