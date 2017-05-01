package tereshchenko.androidlessons.LessonLayouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.R;

public class TableLayoutLesson extends Lesson {



    @Override
    public View btnLessonOpen(View sender){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.lesson_layouts_table_layout, null, false);

        return layout;

    }

    @Override
    public View  btnLessonCodeOpen(View sender){

        TableLayout tableLayout = new TableLayout(this);

        tableLayout.setLayoutParams(new TableLayout.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        tableLayout.setStretchAllColumns(true);

        TextView textView1 = new TextView(this);
        textView1.setText("Column 1");
        TextView textView2 = new TextView(this);
        textView2.setText("Column 2");
        TextView textView3 = new TextView(this);
        textView3.setText("Column 3");

        TextView textView4 = new TextView(this);
        textView4.setText("Column 4");
        textView4.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.span = 3;

        textView4.setLayoutParams(params);



        TableRow tableRow1 = new TableRow(this);
        TableRow tableRow2 = new TableRow(this);


        tableRow1.addView(textView1);
        tableRow1.addView(textView2);
        tableRow1.addView(textView3);

        tableRow2.setBackgroundColor(0xffcccccc);
        tableRow2.addView(textView4);

        tableLayout.addView(tableRow1);
        tableLayout.addView(tableRow2);


        return tableLayout;


    }
}