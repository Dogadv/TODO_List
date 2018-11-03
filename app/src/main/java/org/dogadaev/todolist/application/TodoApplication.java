package org.dogadaev.todolist.application;

import android.app.Application;

import org.dogadaev.todolist.infrastructure.di.ApplicationComponent;
import org.dogadaev.todolist.infrastructure.di.ApplicationModule;
import org.dogadaev.todolist.infrastructure.di.DaggerApplicationComponent;
import org.dogadaev.todolist.infrastructure.di.RoomModule;
import org.dogadaev.todolist.presentation.vm.MainViewModelFactory;

import javax.inject.Inject;

public class TodoApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Inject
    MainViewModelFactory mainViewModelFactory;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .roomModule(new RoomModule(this))
                .build();

        applicationComponent.inject(this);
    }

    public MainViewModelFactory getMainViewModelFactory() {
        return mainViewModelFactory;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
