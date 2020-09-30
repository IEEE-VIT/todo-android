package com.ieeevit.todoandroid.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class TodoTask implements Serializable {

    /**
     * The title of the task.
     */
    private String taskTitle;

    /**
     * The contents (details) of the task.
     */
    private String taskContent;

    /**
     * The deadline of the task.
     */
    private Date taskDeadline;

    /**
     * Tags for the task. Useful for sorting tags by task.
     */
    private ArrayList<String> tags;

    /**
     * Constructor for a TodoTask
     * @param taskTitle Title of the task.
     * @param taskContent Content (detail) of the task.
     * @param taskDeadline Task deadline.
     */
    public TodoTask(String taskTitle, String taskContent, Date taskDeadline) {

    }

    /**
     * Checks equality of this TodoTask and another object.
     * @param o The object to check with.
     * @return true if equal, false if not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoTask todoTask = (TodoTask) o;
        return Objects.equals(taskTitle, todoTask.taskTitle) &&
                Objects.equals(taskContent, todoTask.taskContent) &&
                Objects.equals(taskDeadline, todoTask.taskDeadline) &&
                Objects.equals(tags, todoTask.tags);
    }

    /**
     * Returns the hashCode of the TodoTask object using Object.hashCode().
     * @return hashCode of the TodoTask object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(taskTitle, taskContent, taskDeadline, tags);
    }

    /**
     * Returns the task title.
     * @return Title of the task.
     */
    public String getTaskTitle() {
        return taskTitle;
    }

    /**
     * Sets the task title.
     * @param taskTitle Task title to set.
     */
    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    /**
     * Returns the task details (content).
     * @return This task's details (content).
     */
    public String getTaskContent() {
        return taskContent;
    }

    /**
     * Sets the task details (content).
     * @param taskContent task's details (content) that will be set.
     */
    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    /**
     * Returns the task deadline.
     * @return The deadline for this task.
     */
    public Date getTaskDeadline() {
        return taskDeadline;
    }

    /**
     * Sets the task deadline.
     * @param taskDeadline This task's deadline to be set.
     */
    public void setTaskDeadline(Date taskDeadline) {
        this.taskDeadline = taskDeadline;
    }

    /**
     * Returns the task's tags.
     * @return This task's tags as an ArrayList.
     */
    public ArrayList<String> getTags() {
        return tags;
    }

    /**
     * Sets the task title.
     * @param tags This task's tags that wil be set.
     */
    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    /**
     * Adds a tag to the task.
     * @param tag The tag to add.
     */
    public void addTag(String tag) {
        // Put up the logic here to add a tag to this task.
    }

    /**
     * Removes a tag from this task.
     * @param tag The tag to add.
     * @return true if a tag was removed, false if there was no such tag.
     */
    public boolean removeTag(String tag) {
        // Put up the logic here to remove a tag from this task.
        return false;
    }

    /**
     * Returns true if this task contains the given tag.
     * @param tag The tag to check.
     * @return true if the task contains the given tag, otherwise false.
     */
    public boolean containsTag(String tag) {
        // Put up the logic to check if the tag exists in this task
        return false;
    }
}
