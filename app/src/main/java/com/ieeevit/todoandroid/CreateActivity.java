package com.ieeevit.todoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ieeevit.todoandroid.models.TodoTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Activity to create a new task.
 * Use the intent to pass data back to the Main Activity.
 */
public class CreateActivity extends AppCompatActivity {
    private static final String TAG = "CreateActivity";

    //Widget declarations
    TodoTask mTodoTask;
    Button createTaskBtn;
    EditText taskTitleEt;
    EditText taskContentEt;
    EditText tagsEt;
    TextView taskDeadlineTv;
    CalendarView mCalendarView;


    //variables declaration
    private String mTaskTitle;
    private String mTaskContent;
    private Date mTaskDeadline;
    private ArrayList<String> mTags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        createTaskBtn = findViewById(R.id.crt_btn);
        taskTitleEt = findViewById(R.id.task_title_et);
        taskContentEt = findViewById(R.id.task_content_et);
        taskDeadlineTv = findViewById(R.id.task_deadline_tv);
        tagsEt = findViewById(R.id.tags_et);
        mCalendarView = findViewById(R.id.calendarView);


        mTags = new ArrayList<>();
        //Set default date
        mTaskDeadline = new Date();
        taskDeadlineTv.setText("TASK DEADLINE: " + mTaskDeadline.getYear() + " " + mTaskDeadline.getMonth() + " " + mTaskDeadline.getDate());
        mCalendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            mTaskDeadline = new Date(year, month, dayOfMonth);
            taskDeadlineTv.setText("TASK DEADLINE: " + year + " " + month + " " + dayOfMonth);
        });
        createTaskBtn.setOnClickListener((view) -> {
            getTaskContents();
            createTask();
        });
    }

    //    Creates the task by getting data from variables
    private void createTask() {
        if (!mTaskTitle.isEmpty()) {
            mTodoTask = new TodoTask(mTaskTitle, mTaskContent, mTaskDeadline);
            mTodoTask.setTaskTitle(mTaskTitle);
            mTodoTask.setTaskContent(mTaskContent);
            mTodoTask.setTaskDeadline(mTaskDeadline);
            if (!(mTags.isEmpty())) {
                mTodoTask.setTags(mTags);
            }
            Intent intent = new Intent(CreateActivity.this, MainActivity.class);
            intent.putExtra("TodoTask", mTodoTask);
            Log.d(TAG, "createTask: Task details" + mTodoTask.getTags().toString());
            startActivity(intent);
        } else {
            Toast.makeText(this, "You have to input a Task title", Toast.LENGTH_SHORT).show();
        }
    }

    //    Setting the data in the variables from widgets in the layout
    private void getTaskContents() {
        mTaskTitle = taskTitleEt.getText().toString();
        mTaskContent = taskContentEt.getText().toString();
        String tag = tagsEt.getText().toString();
        String[] tagArr = null;
        try {
            if (tag.contains(",")) {
                tagArr = tag.split(",");
                mTags = new ArrayList<>(Arrays.asList(tagArr));
            } else if (tag.contains(" ")) {
                tagArr = tag.split(" ");
                mTags = new ArrayList<>(Arrays.asList(tagArr));
            } else {
                mTags.add(tag);
            }
            Log.d(TAG, "getTaskContents: " + mTags.toString());
        } catch (Exception ex) {
            Log.d(TAG, "getTaskContents: " + ex.getMessage());
        }

    }
}
