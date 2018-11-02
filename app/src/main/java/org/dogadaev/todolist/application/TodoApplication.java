package org.dogadaev.todolist.application;

import android.app.Application;

import org.dogadaev.todolist.infrastructure.di.ApplicationComponent;
import org.dogadaev.todolist.infrastructure.di.ApplicationModule;
import org.dogadaev.todolist.infrastructure.di.DaggerApplicationComponent;
import org.dogadaev.todolist.infrastructure.di.RoomModule;

public class TodoApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .roomModule(new RoomModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
