package tereshchenko.androidlessons.LessonDB;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


import tereshchenko.androidlessons.R;

public class LessonDB extends AppCompatActivity {

    ListView userList;
    TextView header;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;

    EditText userFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_db);

        header = (TextView)findViewById(R.id.header);
        userList = (ListView)findViewById(R.id.list);

        userFilter = (EditText)findViewById(R.id.userFilter);


        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), User.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }

        });

        databaseHelper = new DatabaseHelper(getApplicationContext());
    }

    public void onClick(View view){

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("CREATE TABLE IF NOT EXISTS users (name TEXT, age INTEGER)");
        db.execSQL("INSERT INTO users VALUES ('Tom Smith', 23);");
        db.execSQL("INSERT INTO users VALUES ('John Dow', 31);");


        Cursor query = db.rawQuery("SELECT * FROM users;", null);



        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("");

        if(query.moveToFirst()){
            do{
                String name = query.getString(0);
                int age = query.getInt(1);
                textView.append("Name: " + name + " Age: " + age + "\n");
            }
            while(query.moveToNext());
        }
        query.close();
        db.close();
    }


    @Override
    public void onResume() {
        super.onResume();
        // открываем подключение
        db = databaseHelper.getReadableDatabase();

        //получаем данные из бд в виде курсора
        //rawQuery("SELECT id, name FROM people WHERE name = ? AND id = ?", new String[] {"David", "2"});
        userCursor =  db.rawQuery( "select * from "+ DatabaseHelper.TABLE, null);

        // определяем, какие столбцы из курсора будут выводиться в ListView
        String[] headers = new String[] {DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_YEAR};

        // создаем адаптер, передаем в него курсор
        userAdapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item,
                userCursor, headers, new int[]{android.R.id.text1, android.R.id.text2}, 0);

        header.setText("Найдено элементов: " + String.valueOf(userCursor.getCount()));
        userList.setAdapter(userAdapter);



        // ----
        ListView userListLoad = (ListView)findViewById(R.id.listLoad);

        DatabaseHelperLoad databaseHelperLoad = new DatabaseHelperLoad(this);

        databaseHelperLoad.create_db();

        final SQLiteDatabase dbLoad = databaseHelperLoad.open();

        Cursor userCursorLoad = null;
        //получаем данные из бд в виде курсора
        try {
             userCursorLoad = dbLoad.rawQuery("select * from " + DatabaseHelperLoad.TABLE, null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        // определяем, какие столбцы из курсора будут выводиться в ListView
        String[] headersLoad = new String[] {DatabaseHelperLoad.COLUMN_NAME, DatabaseHelperLoad.COLUMN_YEAR};

        // создаем адаптер, передаем в него курсор
        final SimpleCursorAdapter userAdapterLoad = new SimpleCursorAdapter(this, R.layout.db_raw,
                userCursorLoad, headers, new int[]{R.id.txtName, R.id.txtYear}, 0);


        userListLoad.setAdapter(userAdapterLoad);


        //---------------
        // если в текстовом поле есть текст, выполняем фильтрацию
        // данная проверка нужна при переходе от одной ориентации экрана к другой
        if(!userFilter.getText().toString().isEmpty())
            userAdapterLoad.getFilter().filter(userFilter.getText().toString());

        // установка слушателя изменения текста
        userFilter.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) { }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            // при изменении текста выполняем фильтрацию
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                userAdapterLoad.getFilter().filter(s.toString());
            }
        });

        // устанавливаем провайдер фильтрации
        userAdapterLoad.setFilterQueryProvider(new FilterQueryProvider() {
            @Override
            public Cursor runQuery(CharSequence constraint) {

                if (constraint == null || constraint.length() == 0) {

                    return dbLoad.rawQuery("select * from " + DatabaseHelperLoad.TABLE, null);
                }
                else {
                    return dbLoad.rawQuery("select * from " + DatabaseHelperLoad.TABLE + " where " +
                            DatabaseHelper.COLUMN_NAME + " like ?", new String[]{"%" + constraint.toString() + "%"});
                }
            }
        });

    }


    public void add(View view){
        Intent intent = new Intent(this, User.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        userCursor.close();
    }
}
