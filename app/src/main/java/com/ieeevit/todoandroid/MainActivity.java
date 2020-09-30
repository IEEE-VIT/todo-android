package com.ieeevit.todoandroid;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.ieeevit.todoandroid.models.TodoTask;
import com.ieeevit.todoandroid.utils.DatabaseHelper;

import java.util.ArrayList;

/**
 * Main activity of the app. This is the starting "screen" of the app.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Stores all the tasks.
     */
    private ArrayList<TodoTask> allTasks;

    /**
     * The DatabaseHelper instance to help with database operations.
     */
    private DatabaseHelper dbHelper;

    /**
     * This function gets called when the app initializes.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("TODO App");
        setSupportActionBar(toolbar);

        allTasks = new ArrayList<TodoTask>();

        /*
        Initialize dbHelper here and populate allTasks using it.
         */

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            /**
             * This is what happens when the FAB on the home screen is tapped.
             * @param view
             */
            @Override
            public void onClick(View view) {
                createNewTask();
            }
        });

        /*
        Set up the RecyclerView that displays the tasks here.
         */
    }

    /**
     * Creates a new task.
     */
    private void createNewTask() {
        // Implement the logic here to create a new task.
        // Update the UI and add the task to the allTasks list.

        // One way to get data could be to use another activity
        // And return the required data about the new task
        // from that activity.
    }

    /**
     * Deletes the currently selected task.
     */
    private void deleteTask() {
        // Implement the logic to delete the task from allTasks.
        // (retrieve the selected task from the adapter).
        // Also update the UI.
    }

    /**
     * Saves the tasks in allTasks into the database.
     */
    private void saveTasks() {
        // Implement the logic to save the tasks to the database.
    }

    /**
     * Modifies the currently selected task.
     */
    private void modifyTask() {
        // Implement the logic to modify the selected task.
        // The ModifyActivity can be used for this.
        // (retrieve the selected task from the adapter).
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
            saveTasks();
        }
        else if (id == R.id.action_delete) {
            deleteTask();
        }
        else if (id == R.id.action_modify) {
            modifyTask();
        }

        return super.onOptionsItemSelected(item);
    }
}
