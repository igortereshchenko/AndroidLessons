package tereshchenko.androidlessons.LessonControls.ButtonControl;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.R;

/**
 * Created by Igor on 4/30/2017.
 */

public class ButtonControl extends Lesson {



    @Override
    public View btnLessonOpen(View sender){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.lesson_controls_button, null, false);

        return layout;

    }


    public void btnListener(View sender){


        Toast toast = Toast.makeText(this, "Обработка btnListener",Toast.LENGTH_SHORT);
        toast.show();

    }

    //------------------------------------------------------

    @Override
    public View  btnLessonCodeOpen(View sender){

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);


        Button button1 = new Button(this);
        button1.setText("Обраторка OnClickListener");


        final TextView textView = new TextView(this);


        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Обработка нажатия
                textView.setText("Обраторка OnClickListener");
            }
        });

        View.OnClickListener btnListener = new ButtonListener(textView);



        Button button2 = new Button(this);
        button2.setText("Внешний OnClickListener");

        button2.setOnClickListener(btnListener);


        linearLayout.addView(button1);
        linearLayout.addView(button2);
        linearLayout.addView(textView);


        return linearLayout;


    }



}