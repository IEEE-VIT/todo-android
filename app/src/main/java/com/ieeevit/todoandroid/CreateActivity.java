package com.ieeevit.todoandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Activity to create a new task.
 * Use the intent to pass data back to the Main Activity.
 */
public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
    }
}
