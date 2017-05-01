package tereshchenko.androidlessons;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.LinearLayout;

import android.widget.ScrollView;
import android.widget.TextView;

import tereshchenko.androidlessons.R;

/**
 * Created by Igor on 4/30/2017.
 */

public abstract class Lesson extends AppCompatActivity {

    public static final String LESSON_NAME = "LESSON_NAME";
    public static final String LESSON_DESCRIPTION="LESSON_DESCRIPTION";


    public LinearLayout layout;

    protected ScrollView lessonOutput;

    protected String txtLessonName;
    protected String txtLessonDescription;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        txtLessonName = getIntent().getStringExtra(LESSON_NAME);;
        txtLessonDescription=getIntent().getStringExtra(LESSON_DESCRIPTION);;

        setContentView(R.layout.lesson);




        layout= (LinearLayout)findViewById(R.id.lessonControlsLayout);
        lessonOutput=(ScrollView)findViewById(R.id.lessonOutput);

        TextView txtView = (TextView)findViewById(R.id.txtLessonName);
        txtView.setText(txtLessonName);

        txtView = (TextView)findViewById(R.id.txtLessonDescription);
        txtView.setText(txtLessonDescription);

        Button button = (Button)findViewById(R.id.btnLessonOpen);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                lessonOutput.removeAllViews();
                lessonOutput.addView(btnLessonOpen(v));
            }
        });

        button = (Button)findViewById(R.id.btnLessonCodeOpen);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lessonOutput.removeAllViews();
                lessonOutput.addView(btnLessonCodeOpen(v));

            }
        });


    }



//-------------------------------------------------------

    public  abstract View btnLessonOpen(View sender);


    public abstract View  btnLessonCodeOpen(View sender);
}