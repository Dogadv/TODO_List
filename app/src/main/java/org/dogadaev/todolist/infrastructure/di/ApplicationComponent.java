package org.dogadaev.todolist.infrastructure.di;

import org.dogadaev.todolist.application.TodoApplication;
import org.dogadaev.todolist.presentation.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, RoomModule.class})
public interface ApplicationComponent {
    void inject(TodoApplication todoApplication);
    void inject(MainActivity mainActivity);
}
