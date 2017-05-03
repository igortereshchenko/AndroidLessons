package tereshchenko.androidlessons.LessonLists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.R;

public class LessonArrayAdapter extends Lesson {



    @Override
    public View btnLessonOpen(View sender){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.lesson_lists_array_adapter, null, false);



        String[] countries1=getResources().getStringArray(R.array.countries);

        String[] countries2 = { "Украина", "США"};



        int length = countries1.length + countries2.length;
        final String[] result = new String[length];

        System.arraycopy(countries1, 0, result, 0, countries1.length);
        System.arraycopy(countries2, 0, result, countries1.length, countries2.length);

        // получаем элемент ListView
        ListView countriesList = (ListView) layout.findViewById(R.id.countriesList);



        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, result);

        // устанавливаем для списка адаптер
        countriesList.setAdapter(adapter);

        //Life HACK )))))))
        setListViewHeightBasedOnChildren(countriesList);

        // получаем элемент TextView
        final TextView selection = (TextView) layout.findViewById(R.id.selection);


        //обработка выбора
        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                // по позиции получаем выбранный элемент
                String selectedItem = result[position];
                // установка текста элемента TextView
                selection.setText(selectedItem);
            }
        });

        return layout;

    }



    ArrayList<String> countries;
    ArrayAdapter<String> adapter;

    ArrayList<String> selectedCountries = new ArrayList();
    ListView countriesList;

    @Override
    public View  btnLessonCodeOpen(View sender) {


        final String[] countries_list=getResources().getStringArray(R.array.countries);

        countries= new ArrayList(Arrays.asList(countries_list));


        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        final TextView selection = new TextView(this);

        layout.addView(selection);



        //final ListView newView = new ListView(this);
        countriesList= new ListView(this);

        countriesList.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);


        // создаем адаптер
        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_multiple_choice, countries);

        // устанавливаем для списка адаптер
        countriesList.setAdapter(adapter);

        layout.addView(countriesList);

        setListViewHeightBasedOnChildren(countriesList);




        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                SparseBooleanArray sp=countriesList.getCheckedItemPositions();

                selectedCountries.clear();

                String selectedItems="";
                for(int i=0;i < countries.size();i++)
                {
                    if(sp.get(i)){
                        selectedItems+=countries.get(i)+",";

                        selectedCountries.add(countries.get(i));
                    }
                }
                // по позиции получаем выбранный элемент
                String selectedItem = countries.get(position);
                // установка текста элемента TextView
                selection.setText("Выбрано: " + selectedItems);



            }
        });

        //----------------------------------------------------------------
        Button btnDelete = new Button(this);
        btnDelete.setText("Удалить выбраное");

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // получаем и удаляем выделенные элементы
                for(int i=0; i< selectedCountries.size();i++){
                    adapter.remove(selectedCountries.get(i));
                }
                // снимаем все ранее установленные отметки
                countriesList.clearChoices();
                // очищаем массив выбраных объектов
                selectedCountries.clear();

                adapter.notifyDataSetChanged();

                selection.setText("");
            }
        });


        layout.addView(btnDelete);


        //----------------------------------------------------------------



        final EditText txtNewCountry = new EditText(this);
        txtNewCountry.setHint("Введите новую срану");
        layout.addView(txtNewCountry);

        Button btnNewCountry = new Button(this);
        btnNewCountry.setText("Добавить страну");


        btnNewCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String new_country = txtNewCountry.getText().toString();
                if(!countries.isEmpty() && countries.contains(new_country)==false){
                    adapter.add(new_country);
                    txtNewCountry.setText("");
                    adapter.notifyDataSetChanged();
                }

                if (countries.isEmpty()){
                    adapter.add(new_country);
                    txtNewCountry.setText("");
                    adapter.notifyDataSetChanged();
                }

            }
        });

        layout.addView(btnNewCountry);



        return  layout;

    }


    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
