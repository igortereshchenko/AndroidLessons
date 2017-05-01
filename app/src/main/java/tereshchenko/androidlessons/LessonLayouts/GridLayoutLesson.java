package tereshchenko.androidlessons.LessonLayouts;

import android.app.ActionBar;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.R;

public class GridLayoutLesson extends Lesson {


    @Override
    public View btnLessonOpen(View sender) {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.lesson_layouts_grid_layout, null, false);

        return layout;

    }

    @Override
    public View btnLessonCodeOpen(View sender) {

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(3);
        gridLayout.setRowCount(3);


        GridLayout.Spec row0 = GridLayout.spec(0);
        GridLayout.Spec row1 = GridLayout.spec(1);
        GridLayout.Spec row2 = GridLayout.spec(2);


        GridLayout.Spec col0 = GridLayout.spec(0);
        GridLayout.Spec col1 = GridLayout.spec(1);
        GridLayout.Spec col2 = GridLayout.spec(2);


        GridLayout.LayoutParams first = new GridLayout.LayoutParams(row0, col0);

        Button button1 = new Button(this);


        button1.setLayoutParams(first);
        button1.setGravity(Gravity.CENTER);
        button1.setBackgroundColor(Color.GREEN);
        button1.setText("Верх");


        gridLayout.addView(button1);




        GridLayout.LayoutParams second = new GridLayout.LayoutParams(row1, col1);

        Button button2 = new Button(this);

        button2.setLayoutParams(second);
        button2.setGravity(Gravity.CENTER);
        button2.setBackgroundColor(Color.RED);
        button2.setText("Центр");


        gridLayout.addView(button2);



        GridLayout.Spec col0_span3 = GridLayout.spec(0,3);

        GridLayout.LayoutParams third = new GridLayout.LayoutParams(row2, col0_span3);
        third.width=800;

        Button button3 = new Button(this);

        button3.setLayoutParams(third);
        button3.setGravity(Gravity.CENTER);
        button3.setBackgroundColor(Color.BLUE);
        button3.setText("Это очень большая кнопка");


        gridLayout.addView(button3);


        return gridLayout;


    }
}