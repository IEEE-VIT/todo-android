package com.ieeevit.todoandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Activity to modify a task.
 * Use the intent to pass data back and forth from the Main Activity.
 */
public class ModifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
    }
}
