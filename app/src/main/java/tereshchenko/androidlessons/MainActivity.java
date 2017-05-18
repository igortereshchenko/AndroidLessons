package tereshchenko.androidlessons;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import tereshchenko.androidlessons.LessonActivity.ActivityCommunication.ActivityCommunication;
import tereshchenko.androidlessons.LessonActivity.LessonActivity;
import tereshchenko.androidlessons.LessonControls.LessonControls;
import tereshchenko.androidlessons.LessonFragment.LessonFragment;
import tereshchenko.androidlessons.LessonLayouts.LessonLayouts;
import tereshchenko.androidlessons.LessonLists.LessonLists;
import tereshchenko.androidlessons.LessonMenu.LessonMenu;
import tereshchenko.androidlessons.LessonResources.ResourceLesson;

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

    public void btnLessonActivityCommunication(View sender){
        Intent intent = new Intent(this, ActivityCommunication.class);
        startActivity(intent);
    }


    public void btnLessonResources(View sender){
        Intent intent = new Intent(this, ResourceLesson.class);
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


    public void btnLessonLists(View sender){
        Intent intent = new Intent(this, LessonLists.class);
        startActivity(intent);
    }

    public void btnLessonMenu(View sender){
        Intent intent = new Intent(this, LessonMenu.class);
        startActivity(intent);
    }


    public void btnLessonFragment(View sender){
        Intent intent = new Intent(this, LessonFragment.class);
        startActivity(intent);
    }
}
