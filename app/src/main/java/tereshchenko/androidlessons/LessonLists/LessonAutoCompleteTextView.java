package tereshchenko.androidlessons.LessonLists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import tereshchenko.androidlessons.R;

public class LessonAutoCompleteTextView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_auto_complete_text_view);


        String[] cities = getResources().getStringArray(R.array.countries);

        // Получаем ссылку на элемент AutoCompleteTextView в разметке
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autocomplete);
        // Создаем адаптер для автозаполнения элемента AutoCompleteTextView
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, cities);

        autoCompleteTextView.setAdapter(adapter);



        //--------------------------



        // Получаем ссылку на элемент AutoCompleteTextView в разметке
        MultiAutoCompleteTextView multiautoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiautocomplete);

        multiautoCompleteTextView.setAdapter(adapter);

        // установка запятой в качестве разделителя
        multiautoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
