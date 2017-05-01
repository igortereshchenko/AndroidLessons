package tereshchenko.androidlessons.LessonControls;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.R;

/**
 * Created by Igor on 4/30/2017.
 */

public class TextViewControl extends Lesson {



    @Override
    public  View btnLessonOpen(View sender){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.lesson_controls_textview, null, false);

        return layout;

    }

    @Override
    public View  btnLessonCodeOpen(View sender){

        LinearLayout linearLayout = new LinearLayout(this);
        TextView textView1 = new TextView(this);
        // установка фонового цвета
        textView1.setBackgroundColor(0xffe8eaf6);
        // установка цвета текста
        textView1.setTextColor(0xff5c6bc0);
        // делаем все буквы заглавными
        textView1.setAllCaps(true);
        // устанавливаем вравнивание текста по центру
        textView1.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        // устанавливаем текста
        textView1.setText("Android Text View");
        // установка шрифта
        textView1.setTypeface(Typeface.create("casual", Typeface.NORMAL));
        // устанавливаем высоту текста
        textView1.setTextSize(26);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        linearLayout.addView(textView1,layoutParams);

        return linearLayout;


    }
}
