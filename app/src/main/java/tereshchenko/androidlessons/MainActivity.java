package tereshchenko.androidlessons;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import tereshchenko.androidlessons.LessonActivity.LessonActivity;
import tereshchenko.androidlessons.LessonControls.LessonControls;
import tereshchenko.androidlessons.LessonLayouts.LessonLayouts;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


    }



    public void btnLessonActivity(View sender){
        Intent intent = new Intent(this, LessonActivity.class);
        startActivity(intent);
    }

    public void btnLessonLayouts(View sender){
        Intent intent = new Intent(this, LessonLayouts.class);
        startActivity(intent);
    }

    public void btnLessonControls(View sender){
        Intent intent = new Intent(this, LessonControls.class);
        startActivity(intent);
    }


}
