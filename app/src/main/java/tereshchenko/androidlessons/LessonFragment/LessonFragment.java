package tereshchenko.androidlessons.LessonFragment;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import tereshchenko.androidlessons.LessonFragment.FragmentPage.LessonFragmentPage;
import tereshchenko.androidlessons.R;

public class LessonFragment extends AppCompatActivity implements FirstFragment.OnFirstFragmentListener,SecondFragment.OnSecondFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_fragment);
    }

    @Override
    public void onFirstFragment(String info, Fragment sender) {



        SecondFragment fragment = (SecondFragment) getFragmentManager()
                   .findFragmentById(R.id.fragmentSecond);

        if (fragment != null && fragment.isInLayout()) {

              EditText edit = (EditText) fragment.getView().findViewById(R.id.editSecondEdit);
             edit.setText(info);
            }

    }

    @Override
    public void onSecondFragment(String info) {

        FirstFragment fragment = (FirstFragment) getFragmentManager()
                .findFragmentById(R.id.fragmentFirst);

        if (fragment != null && fragment.isInLayout()) {

            EditText edit = (EditText) fragment.getView().findViewById(R.id.editFirstEdit);
            edit.setText(info);
        }
    }


    public  void OpenCustom(View sender){

        Intent intent = new Intent(this,LessonFragmentPage.class);
        startActivity(intent);
    }

}
