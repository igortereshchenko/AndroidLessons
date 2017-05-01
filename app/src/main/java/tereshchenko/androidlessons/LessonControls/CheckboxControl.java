package tereshchenko.androidlessons.LessonControls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.R;

public class CheckboxControl extends Lesson {



    @Override
    public View btnLessonOpen(View sender){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.lesson_controls_checkbox, null, false);

        return layout;

    }


    public void onCheckboxClicked(View view) {
        // Получаем флажок
        CheckBox language = (CheckBox) view;
        // Получаем, отмечен ли данный флажок
        boolean checked = language.isChecked();

        TextView selection = (TextView) findViewById(R.id.txtCheckboxSelection);
        // Смотрим, какой именно из флажков отмечен
        switch(view.getId()) {
            case R.id.chbJava:
                if (checked){
                    selection.setText("Java");
                }
                break;
            case R.id.chbJavascript:
                if (checked)
                    selection.setText("JavaScript");
                break;
        }
    }


    @Override
    public View  btnLessonCodeOpen(View sender){

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        //--------------------------------------------------------

        CheckBox chbJava = new CheckBox(this);
        chbJava.setText("Java");

        chbJava.setButtonDrawable(R.drawable.checkbox_selector);

        final TextView txtResult = new TextView(this);

        chbJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    txtResult.setText("Флажок выбран");
                else {
                    txtResult.setText("Флажок не выбран");
                }
            }
        });

        linearLayout.addView(chbJava);
        linearLayout.addView(txtResult);

        return linearLayout;


    }
}