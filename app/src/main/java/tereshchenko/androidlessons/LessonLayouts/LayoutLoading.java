package tereshchenko.androidlessons.LessonLayouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import tereshchenko.androidlessons.R;

public class LayoutLoading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_loading);
    }

    public void onRadioButtonClicked(View view) {
        // если переключатель отмечен
        boolean checked = ((RadioButton) view).isChecked();


        LayoutInflater inflater = getLayoutInflater();

        View layoutFirst = inflater.inflate(R.layout.activity_layout_loading_first, null, false);
        View layoutSecond = inflater.inflate(R.layout.activity_layout_loading_second, null, false);

        ScrollView output = (ScrollView)findViewById(R.id.lessonOutput);

        // Получаем нажатый переключатель
        switch(view.getId()) {
            case R.id.rbLayoutFirst:
                if (checked){

                    output.removeAllViews();
                    output.addView(layoutFirst);

                }
                break;
            case R.id.rbLayoutSecond:
                if (checked){

                    output.removeAllViews();
                    output.addView(layoutSecond);
                }
                break;
        }
    }
}
