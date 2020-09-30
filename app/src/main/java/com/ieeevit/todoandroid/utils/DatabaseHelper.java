package com.ieeevit.todoandroid.utils;

import android.content.Context;
import com.ieeevit.todoandroid.models.TodoTask;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.database.sqlite.SQLiteDatabase;

/**
 * Helper class for SQLite database operations.
 * Extending SQLiteOpenHelper makes it easier to manage creation,
 * upgrade, etc. for the database.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    /**
     * Database file name. For example: TodoTasks.db
     */
    private static final String DB_NAME = "";

    /**
     * Column name for the task title.
     */
    public static final String TASK_TITLE_COLNAME = "";

    /**
     * Column name for task details (content).
     */
    public static final String TASK_DET_COLNAME = "";

    /**
     * Column name for task deadline.
     */
    public static final String TASK_DEADLINE_COLNAME = "";

    /**
     * Column name for task tags.
     */
    public static final String TASK_TAGS_COLNAME = "";

    /**
     * Constructor for the DatabaseHelper.
     * @param context Current context.
     */
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    /**
     * Returns the name of the SQLite database file.
     * @return name of the SQLite database file.
     */
    public String getDbName() {
        return DB_NAME;
    }

    /**
     * This method is called when the database is created for the first time.
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // We need to create two tables here: one that stores the task title, details, and deadline
        // and another that stores the tags of the tasks.
        // This is because one task can have many tags.

        // The primary key of the tasks table (task ID) can be an autoincrement
        // field to ease insertion.
        // The tags table will have two columns, one being the foreign key
        // that references the task ID column in the tasks table and the other storing the tag.
    }

    /**
     * This method is called when the database needs to be upgraded.
     * @param sqLiteDatabase
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    /**
     * Returns the task ID of the given task.
     * @param task The task whose task ID needs to be returned.
     * @return The task ID of the task.
     */
    public Integer getTaskIdFromDb(TodoTask task) {
        // Use all the other fields to find the task ID from the tasks table.
        return null;
    }

    /**
     * Returns all tasks as an ArrayList.
     */
    public ArrayList<TodoTask> getAllTasks() {
        ArrayList<TodoTask> allTasks = new ArrayList<TodoTask>();
        // Retrieve all tasks and their tags from the tables
        // Then populate the allTasks list.
        return allTasks;
    }

    /**
     * Add a task into the database.
     * @param task The task to be added.
     */
    public void addTask(TodoTask task) {
        // Insert the task title, deadline and content into the tasks table.
        // Insert the task tags into the tags table.
    }

    /**
     * Add all tasks in a list into the database.
     * @param task The task to be added.
     */
    public void addAllTasks(ArrayList<TodoTask> tasks) {
        // Insert all the tasks into the DB
    }

    /**
     * Remove all tasks from the database
     */
    public void removeTasks() {
        // Delete all tasks from the database
    }

    /**
     * Remove (delete) a task from the database.
     * @param task The task to be removed.
     */
    public void deleteTask(TodoTask task) {
        // Remove the task and its tags from the database.

        // To do this, first get the task ID using the getTaskIdFromDb() function
        // Use this task ID to delete the relevant records from the tables.
    }

    /**
     * Update task deadline and return a TodoTask object with the changed deadline.
     * @param task Task whose deadline has to be updated.
     * @param newDeadline New deadline.
     * @return A TodoTask object with the deadline updated.
     */
    public TodoTask updateDeadline(TodoTask task, Date newDeadline) {
        // Update the tasks table with the new deadline.
        task.setTaskDeadline(newDeadline);
        return task;
    }

    /**
     * Update task title and return a TodoTask object with the changed title.
     * @param task Task whose title has to be updated.
     * @param newTitle New title.
     * @return A TodoTask object with the title updated.
     */
    public TodoTask updateTitle(TodoTask task, String newTitle) {
        // Update the tasks table with the new title.
        task.setTaskTitle(newTitle);
        return task;
    }

    /**
     * Update task content and return a TodoTask object with the changed content.
     * @param task Task whose content has to be updated.
     * @param newContent New content.
     * @return A TodoTask object with the content updated.
     */
    public TodoTask updateContent(TodoTask task, String newContent) {
        // Update the tasks table with the new content.
        task.setTaskContent(newContent);
        return task;
    }

    /**
     * Update task tag by adding another tag and return a TodoTask object with the changed tags.
     * @param task Task whose tags have to be updated.
     * @param newTag New tag to be added.
     * @return A TodoTask object with the tags updated.
     */
    public TodoTask addTag(TodoTask task, String newTag) {
        // Update the tags table with the new tag.
        task.addTag(newTag);
        return task;
    }

    /**
     * Update task tag by removing a tag and returns a TodoTask object with the changed tags.
     * Does nothing if that tag does not exist in the tags of the provided TodoTask.
     * @param task Task whose tags have to be updated.
     * @param tagToRemove Tag to be removed.
     * @return A TodoTask object with the tags updated.
     */
    public TodoTask removeTag(TodoTask task, String tagToRemove) {
        // Update the tags table with the new tags.
        task.removeTag(tagToRemove);
        return task;
    }

    /**
     * Returns an ArrayList of TodoTasks that have the specified tags.
     * @return ArrayList of the TodoTasks having the specified tag.
     * @param tags Tags to search for.
     */
    public ArrayList<TodoTask> getTasksByTags(List<String> tags) {
        ArrayList<TodoTask> resultList = new ArrayList<TodoTask>();

        // Implement the logic to retrieve the required tasks from the database
        // and store them in resultList.

        return resultList;
    }

    /**
     * Returns an ArrayList of TodoTasks that have the specified deadline.
     * @return ArrayList of the TodoTasks having the specified deadline.
     * @param deadline Deadline to search for.
     */
    public ArrayList<TodoTask> getTasksByDeadlineOn(Date deadline) {
        ArrayList<TodoTask> resultList = new ArrayList<TodoTask>();

        // Implement the logic to retrieve the required tasks from the database
        // and store them in resultList.

        return resultList;
    }

    /**
     * Returns an ArrayList of TodoTasks that have the deadline after the specified date.
     * @return ArrayList of the TodoTasks having the deadline after dateAfterWhich.
     * @param dateAfterWhich Tasks who have the deadline after this date wil be returned.
     */
    public ArrayList<TodoTask> getTasksByDeadlineAfterDate(Date dateAfterWhich) {
        ArrayList<TodoTask> resultList = new ArrayList<TodoTask>();

        // Implement the logic to retrieve the required tasks from the database
        // and store them in resultList.

        return resultList;
    }

    /**
     * Returns an ArrayList of TodoTasks that have the deadline before the specified date.
     * @return ArrayList of the TodoTasks having the deadline before dateBeforeWhich.
     * @param dateBeforeWhich Tasks who have the deadline before this date wil be returned.
     */
    public ArrayList<TodoTask> getTasksByDeadlineBeforeDate(Date dateBeforeWhich) {
        ArrayList<TodoTask> resultList = new ArrayList<TodoTask>();

        // Implement the logic to retrieve the required tasks from the database
        // and store them in resultList.

        return resultList;
    }

    /**
     * Returns an ArrayList of TodoTasks that have the deadline between 2 specified dates (both excluded).
     * @return ArrayList of the TodoTasks having the deadline before dateBeforeWhich and after dateAfterWhich.
     * @param dateAfterWhich
     * @param dateBeforeWhich
     */
    public ArrayList<TodoTask> getTasksByDeadlineBetween(Date dateAfterWhich, Date dateBeforeWhich) {
        ArrayList<TodoTask> resultList = new ArrayList<TodoTask>();

        // Implement the logic to retrieve the required tasks from the database
        // and store them in resultList.

        return resultList;
    }
}
