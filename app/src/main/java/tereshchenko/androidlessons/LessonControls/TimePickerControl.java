package tereshchenko.androidlessons.LessonControls;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.R;

public class TimePickerControl extends Lesson {



    @Override
    public View btnLessonOpen(View sender){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.lesson_controls_time_picker, null, false);

        return layout;

    }

    public void btnTimePicker(View sender){

        TextView txtTimePicker = (TextView)findViewById(R.id.txtTimePicker);
        TimePicker mTimePicker= (TimePicker) findViewById(R.id.timePicker);

        txtTimePicker.setText(mTimePicker.getHour()+":"+mTimePicker.getMinute());

    }

    @Override
    public View  btnLessonCodeOpen(View sender){

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        //--------------------------------------------------------

        TimePicker mTimePicker= new TimePicker(this);


        linearLayout.addView(mTimePicker);

        Calendar now = Calendar.getInstance();

        mTimePicker.setHour(now.get(Calendar.HOUR_OF_DAY));
        mTimePicker.setMinute(now.get(Calendar.MINUTE));

        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                Toast.makeText(getApplicationContext(), "onTimeChanged " +hourOfDay+":"+minute,
                        Toast.LENGTH_SHORT).show();

            }
        });

        return linearLayout;


    }
}