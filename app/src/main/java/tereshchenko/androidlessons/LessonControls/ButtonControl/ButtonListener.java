package tereshchenko.androidlessons.LessonControls.ButtonControl;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Igor on 4/30/2017.
 */

public class ButtonListener implements View.OnClickListener {

    private TextView textView;

    public ButtonListener(TextView textView){
        this.textView= textView;
    }

    @Override
    public void onClick(View v) {


        textView.setText("Класс обработки нажатия кнопки сработал. onClick");


    }
}
