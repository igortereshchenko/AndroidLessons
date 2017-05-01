package tereshchenko.androidlessons.LessonLayouts;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import tereshchenko.androidlessons.MainActivity;
import tereshchenko.androidlessons.R;

/**
 * Created by Igor on 4/29/2017.
 */

public class LessonLayouts  extends AppCompatActivity {

    private final static String TAG = "LessonLayouts";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lesson_layouts);

        Log.d(TAG, "onCreate");
    }



    public void btnBackToMain(View sender){

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void  btnBack(View sender){
        setContentView(R.layout.lesson_layouts);
    }
//----------------------------------------------------
//LinearLayout
    public void btnLinearLayout(View sender){

        setContentView(R.layout.lesson_layouts_linear);
    }

    public void btnManualLinearLayout(View sender){

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView textView1 = new TextView(this);
        textView1.setText("simple text");
        textView1.setBackgroundColor(Color.CYAN);


        linearLayout.addView(textView1, new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        //----------------------------------------------------------

        TextView textView2 = new TextView(this);
        textView2.setText("Set margins and paddings");

        LinearLayout.LayoutParams layoutParams =new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);



        final float scale = getResources().getDisplayMetrics().density;
        int size_5dp = (int) (5 * scale + 0.5f);
        int size_20dp = (int) (20 * scale + 0.5f);


        textView2.setPadding(size_5dp,size_5dp,size_20dp,size_20dp); //padding is element property

        layoutParams.setMargins(size_20dp,size_20dp,size_20dp,size_20dp); //margins is layout property

        textView2.setLayoutParams(layoutParams);


        linearLayout.addView(textView2 );


        //----------------------------------------------------------

        Button btnBack = new Button(this);
        btnBack.setText("Назад");
        btnBack.setLayoutParams(layoutParams);


        btnBack.setOnClickListener( new View.OnClickListener(){

            public void onClick(View sender){
                setContentView(R.layout.lesson_layouts_linear);
            }

        });
        linearLayout.addView(btnBack);

        setContentView(linearLayout);
    }




//----------------------------------------------------
//RelativeLayout



}