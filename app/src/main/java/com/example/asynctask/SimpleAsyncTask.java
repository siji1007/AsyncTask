package com.example.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {

    private WeakReference<TextView> mTextView;

    public SimpleAsyncTask(TextView textView) {
        mTextView = new WeakReference<>(textView);
    }

    @Override
    protected String doInBackground(Void... voids) {
        // Generate a random sleep time between 1 and 5 seconds (for testing)
        int sleepTime = (int) (Math.random() * 5) + 1;
        sleepTime *= 1000; // Convert to milliseconds

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Awake at last after sleeping for " + sleepTime + " milliseconds";
    }

    @Override
    protected void onPostExecute(String result) {
        TextView textView = mTextView.get();
        if (textView != null) {
            textView.setText(result);
        }
    }
}
