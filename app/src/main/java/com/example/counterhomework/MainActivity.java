package com.example.counterhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "On Create activity");
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);

        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            if (isVisible) {
                mShowCount.setText(savedInstanceState.getString("reply_text"));
                mShowCount.setVisibility(View.VISIBLE);
            }
        }
    }

    public void countUp(View view) {
        Log.d(LOG_TAG, "Count Method Used");
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(LOG_TAG, "Metodo on Save avviato! Salvo tutti i dati presenti!");
        if (mShowCount.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", mShowCount.getText().toString());
            outState.putInt("reply_count", mCount);
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(LOG_TAG, "Metodo Restore avviato! Riprendo i dati salvati");
        mShowCount.setText(savedInstanceState.getString("reply_text"));
        mCount = savedInstanceState.getInt("reply_count");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "On Start activity");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(LOG_TAG, "On Pause activity");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.d(LOG_TAG, "On Restart activity");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG, "On Resume activity");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(LOG_TAG, "On Stop activity");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG, "On Destroy activity");
    }
}