package tereshchenko.androidlessons.LessonLayouts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.R;

public class ScrollViewLesson extends Lesson {



    @Override
    public View btnLessonOpen(View sender){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.lesson_layouts_scroll_view, null, false);

        return layout;

    }

    @Override
    public View  btnLessonCodeOpen(View sender){

        ScrollView scrollView = new ScrollView(this);

        TextView textView1 = new TextView(this);
        textView1.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry...like Aldus PageMaker including versions of Lorem Ipsum.");
        textView1.setLayoutParams(new ViewGroup.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView1.setTextSize(76);
        scrollView.addView(textView1);


        return scrollView;


    }
}
