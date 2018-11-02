package org.dogadaev.todolist.data;

import org.dogadaev.todolist.data.model.TaskItem;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {TaskItem.class}, version = 1)
public abstract class TaskItemDatabase extends RoomDatabase {

    public abstract TaskItemDao taskItemDao();
}
