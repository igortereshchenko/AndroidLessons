package tereshchenko.androidlessons.LessonActivity.ActivityCommunication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import tereshchenko.androidlessons.R;

/**
 * Created by Igor on 5/2/2017.
 */

public class ActivityCommunication extends AppCompatActivity {

    private static  final int REQUEST_CALCULATOR=1;

    public static final String CALCULATOR_RESULT="CALCULATOR_RESULT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_activity_communication);
    }


    public void onCalculatorClick(View view) {
        Intent intent = new Intent(this, Calculator.class);
        intent.putExtra("Product", "Планшет");
        intent.putExtra("Price", 180);

        startActivityForResult(intent, REQUEST_CALCULATOR);
        //startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){

        TextView textView=(TextView) findViewById(R.id.txtcalcresult);

        if(requestCode==REQUEST_CALCULATOR){
            if(resultCode==RESULT_OK){
                String result = data.getStringExtra(CALCULATOR_RESULT);
                textView.setText(result);
            }
            else{
                textView.setText("Товар не нравиться");
            }
        }
        else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
