package tereshchenko.androidlessons.LessonLayouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.R;

public class FrameLayoutLesson extends Lesson {


    @Override
    public View btnLessonOpen(View sender) {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.lesson_layouts_frame_layout, null, false);

        return layout;

    }

    @Override
    public View btnLessonCodeOpen(View sender) {

        FrameLayout frameLayout = new FrameLayout(this);
        TextView textView1 = new TextView(this);
        textView1.setText("Hello World!");

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams
                (FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;

        textView1.setLayoutParams(layoutParams);
        textView1.setTextSize(26);
        frameLayout.addView(textView1);


        return frameLayout;


    }
}
