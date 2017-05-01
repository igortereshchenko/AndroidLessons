package tereshchenko.androidlessons.LessonLayouts;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.R;

/**
 * Created by Igor on 5/1/2017.
 */

public class LinearLayoutLesson extends Lesson {



    @Override
    public View btnLessonOpen(View sender){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.lesson_layouts_linear, null, false);

        return layout;

    }

    @Override
    public View  btnLessonCodeOpen(View sender){

        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(this);
        linearLayout.setOrientation(android.widget.LinearLayout.VERTICAL);
        //--------------------------------------------------------

        TextView textView1 = new TextView(this);
        textView1.setText("simple text");
        textView1.setBackgroundColor(Color.CYAN);


        linearLayout.addView(textView1, new android.widget.LinearLayout.LayoutParams
                (android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT));

        //----------------------------------------------------------

        TextView textView2 = new TextView(this);
        textView2.setText("Set margins and paddings");

        android.widget.LinearLayout.LayoutParams layoutParams =new android.widget.LinearLayout.LayoutParams
                (android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);



        final float scale = getResources().getDisplayMetrics().density;
        int size_5dp = (int) (5 * scale + 0.5f);
        int size_20dp = (int) (20 * scale + 0.5f);


        textView2.setPadding(size_5dp,size_5dp,size_20dp,size_20dp); //padding is element property

        layoutParams.setMargins(size_20dp,size_20dp,size_20dp,size_20dp); //margins is layout property

        textView2.setLayoutParams(layoutParams);


        linearLayout.addView(textView2 );


        return linearLayout;


    }
}
