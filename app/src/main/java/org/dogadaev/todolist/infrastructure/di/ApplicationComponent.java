package org.dogadaev.todolist.infrastructure.di;

import android.app.Application;

import org.dogadaev.todolist.presentation.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, RoomModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);

    Application application();
}
