package org.dogadaev.todolist.data.repository;

import org.dogadaev.todolist.data.TaskItemDao;
import org.dogadaev.todolist.data.model.TaskItem;

import java.util.List;

import androidx.lifecycle.LiveData;

public class TaskItemRepository {
    private final TaskItemDao taskItemDao;

    public TaskItemRepository(TaskItemDao taskItemDao) {
        this.taskItemDao = taskItemDao;
    }

    public LiveData<List<TaskItem>> getTaskItems() {
        return taskItemDao.GetTaskItems();
    }

    public LiveData<TaskItem> getTaskItemById(String id) {
        return taskItemDao.getTaskItemById(id);
    }

    public Long insertTaskItem(TaskItem taskItem) {
        return taskItemDao.insertTaskItem(taskItem);
    }

    public void deleteTaskItem(TaskItem taskItem) {
        taskItemDao.deleteTaskItem(taskItem);
    }
}
