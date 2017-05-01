package tereshchenko.androidlessons.LessonControls;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.R;

import static android.view.View.generateViewId;

public class RadioButtonControl extends Lesson {



    @Override
    public View btnLessonOpen(View sender){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.lesson_controls_radio_button, null, false);

        return layout;

    }

    public void onRadioButtonClicked(View view) {
        // если переключатель отмечен
        boolean checked = ((RadioButton) view).isChecked();
        TextView selection = (TextView) findViewById(R.id.txtRadioButtonSelection);
        // Получаем нажатый переключатель
        switch(view.getId()) {
            case R.id.rbJava:
                if (checked){
                    selection.setText("Выбран Java");
                }
                break;
            case R.id.rbJavascript:
                if (checked){
                    selection.setText("Выбран JavaScript");
                }
                break;
        }
    }

    @Override
    public View  btnLessonCodeOpen(View sender){



        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        //--------------------------------------------------------

        final TextView selection = new TextView(this);

        RadioGroup rbGroup = new RadioGroup(this);

        RadioButton rbJava = new RadioButton(this);
        rbJava.setText("Java");
        rbJava.setId(11);

        // set new style
        rbJava.setButtonDrawable(R.drawable.checkbox_selector);



        RadioButton rbJavaScript = new RadioButton(this);
        rbJavaScript.setText("JavaScript");
        rbJavaScript.setId(22);


        rbGroup.addView(rbJava);
        rbGroup.addView(rbJavaScript);


        linearLayout.addView(rbGroup);
        linearLayout.addView(selection);


        // обработка переключения состояния переключателя
        rbGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch(checkedId) {

                    case 11:
                        selection.setText("Выбран Java");
                        break;

                    case 22:
                        selection.setText("Выбран JavaScript");
                        break;
                    default:
                        break;
                }
            }
        });



        return linearLayout;


    }
}