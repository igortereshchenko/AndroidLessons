package tereshchenko.androidlessons.LessonDB.DBCustom;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Igor on 5/21/2017.
 */

public class DatabaseHelperLoad extends SQLiteOpenHelper {
    private static String DB_PATH; // полный путь к базе данных
    private static String DB_NAME = "custom.db";
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE = "client"; // название таблицы в бд
    // названия столбцов
    static final String COLUMN_CODE = "client_code";
    static final String COLUMN_NAME = "client_name";
    static final String COLUMN_EMAIL = "client_email";
    private Context myContext;

    DatabaseHelperLoad(Context context) {
        super(context, DB_NAME, null, SCHEMA);
        this.myContext=context;
        DB_PATH =context.getFilesDir().getPath() + DB_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
    }

    void create_db(){
        InputStream myInput = null;
        OutputStream myOutput = null;

        try {
            File file = new File(DB_PATH);

            if (!file.exists()) {
                this.getReadableDatabase();
                //получаем локальную бд как поток

                myInput = myContext.getAssets().open(DB_NAME);
                // Путь к новой бд
                String outFileName = DB_PATH;

                // Открываем пустую бд
                myOutput = new FileOutputStream(outFileName);

                // побайтово копируем данные
                byte[] buffer = new byte[1024];

                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }

                myOutput.flush();
                myOutput.close();
                myInput.close();
            }
        }
        catch(IOException ex){
            Log.d("DatabaseHelperLoad", ex.getMessage());
        }
    }
    public SQLiteDatabase open()throws SQLException {

        return SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
    }
}