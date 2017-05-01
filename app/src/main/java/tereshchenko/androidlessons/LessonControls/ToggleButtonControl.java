package tereshchenko.androidlessons.LessonControls;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.R;

public class ToggleButtonControl extends Lesson {



    @Override
    public View btnLessonOpen(View sender){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.lesson_controls_toggle_button, null, false);

        return layout;

    }

    public void onToggleClicked(View view) {

        // включена ли кнопка
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            // действия если включена
            Toast.makeText(this, "Свет включен", Toast.LENGTH_LONG).show();
        } else {
            // действия, если выключена
            Toast.makeText(this, "Свет выключен!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public View  btnLessonCodeOpen(View sender){

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        //--------------------------------------------------------

        ToggleButton toggleButton = new ToggleButton(this);
        toggleButton.setTextOff("Выключено");
        toggleButton.setTextOn("Включено");

        toggleButton.setText("Выключено");

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean on = ((ToggleButton) view).isChecked();

                if (on) {
                    Toast.makeText(getApplicationContext(), "Свет включен", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Свет выключен!", Toast.LENGTH_LONG).show();
                }
            }
        });
        linearLayout.addView(toggleButton, new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        return linearLayout;


    }
}