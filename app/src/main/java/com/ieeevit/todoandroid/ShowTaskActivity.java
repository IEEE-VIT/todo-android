package com.ieeevit.todoandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Activity to show a particular task to the user.
 */
public class ShowTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task);
    }
}
