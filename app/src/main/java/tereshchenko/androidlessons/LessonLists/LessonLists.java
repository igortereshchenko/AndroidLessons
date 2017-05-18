package tereshchenko.androidlessons.LessonLists;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.LessonControls.TextViewControl;
import tereshchenko.androidlessons.LessonLists.CustomArrayAdapter.LessonCutomArrayAdapter;
import tereshchenko.androidlessons.LessonLists.LessonGrid.LessonGrid;
import tereshchenko.androidlessons.R;

public class LessonLists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_lists);
    }

    public void btnArrayAdapter(View sender){

        Intent intent = new Intent(this, LessonArrayAdapter.class);
        intent.putExtra(Lesson.LESSON_NAME,"ListView и ArrayAdapter");
        intent.putExtra(Lesson.LESSON_DESCRIPTION,"Класс ArrayAdapter представляет собой простейший адаптер, который связывает массив данных с набором элементов TextView, из которых, к примеру, может состоять ListView. То есть в данном случае источником данных выступает массив объектов. ArrayAdapter вызывает у каждого объекта метод toString() для приведения к строковому виду и полученную строку устанавливает в элемент TextView.");

        startActivity(intent);

    }


    public void btnCustomArrayAdapter(View sender){

        Intent intent = new Intent(this, LessonCutomArrayAdapter.class);

        startActivity(intent);

    }


    public void btnSpinner(View sender){

        Intent intent = new Intent(this, LessonSpinner.class);

        startActivity(intent);

    }


    public void btnAutoCompleteTextView(View sender){

        Intent intent = new Intent(this, LessonAutoCompleteTextView.class);

        startActivity(intent);

    }


    public void btnGrid(View sender){

        Intent intent = new Intent(this, LessonGrid.class);

        startActivity(intent);

    }
}
