package tereshchenko.androidlessons.LessonMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import tereshchenko.androidlessons.R;

public class LessonMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_menu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView headerView = (TextView) findViewById(R.id.header);
        switch(id){

            //simple group
            case R.id.action_settings :
                headerView.setText("Настройки");
                return true;
            case R.id.open_settings:
                headerView.setText("Открыть");
                return true;
            case R.id.save_settings:
                headerView.setText("Сохранить");
                return true;


            //radio button group
            case R.id.action_1 :
                headerView.setText("action_1");
                item.setChecked(true);
                return true;
            case R.id.action_2:
                headerView.setText("action_2");
                item.setChecked(true);
                return true;
            case R.id.action_3:
                headerView.setText("action_3");
                item.setChecked(true);
                return true;


            // checkbox group
            case R.id.action_4 :
                headerView.setText("action_4");
                item.setChecked(!item.isChecked());
                return true;
            case R.id.action_5:
                headerView.setText("action_5");
                item.setChecked(!item.isChecked());
                return true;
            case R.id.action_6:
                headerView.setText("action_6");
                item.setChecked(!item.isChecked());
                return true;

        }



        return super.onOptionsItemSelected(item);
    }
}
