package tereshchenko.androidlessons.LessonActivity.ActivityCommunication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import tereshchenko.androidlessons.R;

/**
 * Created by Igor on 5/2/2017.
 */

public class Calculator extends AppCompatActivity {
    private final static String TAG = "MainActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_activity_communication_calculator);

        Bundle extras = getIntent().getExtras();

        TextView textView = (TextView)findViewById(R.id.txtitem);

        textView.setTextSize(20);
        textView.setPadding(16, 16, 16, 16);

        if (extras != null) {
            String product = extras.getString("Product");
            Integer price = extras.getInt("Price");
            textView.setText(product + " стоит " + String.valueOf(price) + " $");
        }



        Log.d(TAG, "onCreate-------------------");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy------------------");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop---------------------");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart--------------------");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause-------------------");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume--------------------");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart---------------");
    }

    @Override
    protected  void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState-----------------");
    }

    @Override
    protected  void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState----------------");
    }



    public void onButtonCancelClick(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }


    public void onButtonOkClick(View v) {
        Intent data = new Intent();
        data.putExtra(ActivityCommunication.CALCULATOR_RESULT, "Товар нравиться");
        setResult(RESULT_OK, data);
        finish();
    }
}