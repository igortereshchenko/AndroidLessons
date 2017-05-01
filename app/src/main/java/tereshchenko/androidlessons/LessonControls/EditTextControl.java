package tereshchenko.androidlessons.LessonControls;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.R;

/**
 * Created by Igor on 4/30/2017.
 */

public class EditTextControl extends Lesson {



    @Override
    public View btnLessonOpen(View sender){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.lesson_controls_edittext, null, false);

        return layout;

    }

    @Override
    public View  btnLessonCodeOpen(View sender){

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        //--------------------------------------------------------

        EditText edittext1 = new EditText(this);

        edittext1.setHint("Несколько строк...");
        edittext1.setTextSize(20);

        //multi lines
        edittext1.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_MULTI_LINE);

        //--------------------------------------------------------

        EditText edittext2 = new EditText(this);

        edittext2.setHint("Тольцо цифры...");
        edittext2.setTextSize(15);

        //numbers only
        edittext2.setInputType(InputType.TYPE_CLASS_NUMBER);


        //--------------------------------------------------------

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);



        linearLayout.addView(edittext1,layoutParams);
        linearLayout.addView(edittext2,layoutParams);

        return linearLayout;


    }
}