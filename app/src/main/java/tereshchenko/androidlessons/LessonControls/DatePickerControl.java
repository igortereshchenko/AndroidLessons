package tereshchenko.androidlessons.LessonControls;


import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.R;

public class DatePickerControl extends Lesson {



    @Override
    public View btnLessonOpen(View sender){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.lesson_controls_date_picker, null, false);

        return layout;

    }

    public void btnGetTime(View sender) {

        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);



        StringBuilder builder=new StringBuilder();

        builder.append("Current Date: ");
        builder.append((datePicker.getMonth() + 1)+"/");//month is 0 based
        builder.append(datePicker.getDayOfMonth()+"/");
        builder.append(datePicker.getYear());



        TextView txtDatePicker = (TextView)findViewById(R.id.txtDatePicker);
        txtDatePicker.setText( builder.toString());


    }


    @Override
    public View  btnLessonCodeOpen(View sender){



        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        //--------------------------------------------------------

        DatePicker datePicker = new DatePicker(this);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {


                String message="Год=" + year + " Месяц=" + (month + 1) + " День=" + dayOfMonth;

                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();


            }
        });

        // datePicker.setOnClickListener();

        linearLayout.addView(datePicker);

        return linearLayout;


    }
}
