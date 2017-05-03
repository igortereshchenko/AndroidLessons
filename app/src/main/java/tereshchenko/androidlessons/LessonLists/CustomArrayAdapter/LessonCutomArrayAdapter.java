package tereshchenko.androidlessons.LessonLists.CustomArrayAdapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import tereshchenko.androidlessons.R;

public class LessonCutomArrayAdapter extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList();

    ListView productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_custom_array_adapter);


        if(products.size()==0){
            products.add(new Product("Картофель", "кг."));
            products.add(new Product("Чай", "шт."));
            products.add(new Product("Яйца", "шт."));
            products.add(new Product("Молоко", "л."));
            products.add(new Product("Макароны", "кг."));
        }
        productList = (ListView) findViewById(R.id.productList);
        ProductAdapter adapter = new ProductAdapter(this, R.layout.lesson_custom_array_adapter_item, products);
        productList.setAdapter(adapter);
    }
}
