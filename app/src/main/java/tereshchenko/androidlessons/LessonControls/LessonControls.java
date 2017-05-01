package tereshchenko.androidlessons.LessonControls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.LessonControls.ButtonControl.ButtonControl;
import tereshchenko.androidlessons.R;

public class LessonControls extends AppCompatActivity {

    private final static String TAG = "LessonControls";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_controls);
    }


    public void btnTextView(View sender){
        Intent intent = new Intent(this, TextViewControl.class);
        intent.putExtra(Lesson.LESSON_NAME,"TextView");
        intent.putExtra(Lesson.LESSON_DESCRIPTION,"Для простого вывода текста на экран предназначен элемент TextView. Он просто отображает текст без возможности его редактирования.");

        startActivity(intent);

    }

    public void btnEditText(View sender){
        Intent intent = new Intent(this, EditTextControl.class);
        intent.putExtra(Lesson.LESSON_NAME,"EditText");
        intent.putExtra(Lesson.LESSON_DESCRIPTION,"Элемент EditText является подклассом класса TextView. Он также представляет текстовое поле, но теперь уже с возможностью ввода и редактирования текста. Таким образом, в EditText мы можем использовать все те же возможности, что и в TextView.");

        startActivity(intent);

    }

    public void btnButton(View sender){
        Intent intent = new Intent(this, ButtonControl.class);
        intent.putExtra(Lesson.LESSON_NAME,"Button");
        intent.putExtra(Lesson.LESSON_DESCRIPTION,"Одним из часто используемых элементов являются кнопки, которые представлены классом android.widget.Button. Ключевой особенностью кнопок является возможность взаимодействия с пользователем через нажатия.");

        startActivity(intent);

    }

    public void btnSnackbar(View sender){
        Intent intent = new Intent(this, SnackbarControl.class);

        startActivity(intent);

    }

    public void btnCheckbox(View sender){
        Intent intent = new Intent(this, CheckboxControl.class);
        intent.putExtra(Lesson.LESSON_NAME,"Checkbox");
        intent.putExtra(Lesson.LESSON_DESCRIPTION,"Элементы Checkbox представляют собой флажки, которые могут находиться в отмеченном и неотмеченном состоянии. Флажки позволяют производить множественный выбор из нескольких значений.");

        startActivity(intent);

    }

}
