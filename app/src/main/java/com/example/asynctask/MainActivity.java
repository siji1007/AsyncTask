package com.example.asynctask;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private static final String TEXT_STATE_KEY = "textState";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize mTextView
        mTextView = findViewById(R.id.textView1);

        // Restore TextView state if available
        if (savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString(TEXT_STATE_KEY));
        }
    }

    public void startTask(View view) {
        // Check if mTextView is initialized
        if (mTextView == null) {
            Log.e("MainActivity", "mTextView is null");
            return; // Exit the method if mTextView is null
        }

        // Set loading text before executing AsyncTask
        mTextView.setText(getString(R.string.loading_message));

        // Execute AsyncTask
        SimpleAsyncTask task = new SimpleAsyncTask(mTextView);
        task.execute();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the text state of mTextView
        outState.putString(TEXT_STATE_KEY, mTextView.getText().toString());
    }
}


