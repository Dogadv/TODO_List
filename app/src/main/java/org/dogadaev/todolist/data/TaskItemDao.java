package org.dogadaev.todolist.data;

import org.dogadaev.todolist.data.model.TaskItem;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface TaskItemDao {

    @Query("SELECT * FROM TaskItem")
    LiveData<List<TaskItem>> GetTaskItems();

    @Query("SELECT * FROM TaskItem WHERE id = :id")
    LiveData<TaskItem> getTaskItemById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertTaskItem(TaskItem taskItem);

    @Delete
    void deleteTaskItem(TaskItem taskItem);
}
