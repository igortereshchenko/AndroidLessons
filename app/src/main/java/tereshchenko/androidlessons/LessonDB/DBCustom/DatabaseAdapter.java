package tereshchenko.androidlessons.LessonDB.DBCustom;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import tereshchenko.androidlessons.LessonDB.DatabaseHelper;

/**
 * Created by Igor on 5/21/2017.
 */

public class DatabaseAdapter {
    private DatabaseHelperLoad dbHelper;
    private SQLiteDatabase database;

    public DatabaseAdapter(Context context){
        dbHelper = new DatabaseHelperLoad(context.getApplicationContext());
    }

    public DatabaseAdapter open(){
        dbHelper.create_db();
        database = dbHelper.open();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    private Cursor getAllEntries(){
        String[] columns = new String[] {DatabaseHelperLoad.COLUMN_CODE, DatabaseHelperLoad.COLUMN_NAME, DatabaseHelperLoad.COLUMN_EMAIL};


        return  database.query(DatabaseHelperLoad.TABLE, columns, null, null, null, null, null);
    }

    public List<Client> getUsers(){
        ArrayList<Client> clients = new ArrayList<>();

        Cursor cursor = getAllEntries();
        if(cursor.moveToFirst()){
            do{
                int code = cursor.getInt(cursor.getColumnIndex(DatabaseHelperLoad.COLUMN_CODE));
                String name = cursor.getString(cursor.getColumnIndex(DatabaseHelperLoad.COLUMN_NAME));
                String email = cursor.getString(cursor.getColumnIndex(DatabaseHelperLoad.COLUMN_EMAIL));
                clients.add(new Client(code, name, email));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return  clients;
    }

    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DatabaseHelperLoad.TABLE);
    }

    public Client getClient(long code){
        Client client = null;
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelperLoad.TABLE, DatabaseHelperLoad.COLUMN_CODE);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(code)});
        if(cursor.moveToFirst()){
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelperLoad.COLUMN_NAME));
            String email = cursor.getString(cursor.getColumnIndex(DatabaseHelperLoad.COLUMN_EMAIL));
            client = new Client(code, name, email);
        }
        cursor.close();
        return  client;
    }

    /*
    public long insert(User user){

        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_NAME, user.getName());
        cv.put(DatabaseHelper.COLUMN_YEAR, user.getYear());

        return  database.insert(DatabaseHelper.TABLE, null, cv);
    }

    public long delete(long userId){

        String whereClause = "_id = ?";
        String[] whereArgs = new String[]{String.valueOf(userId)};
        return database.delete(DatabaseHelper.TABLE, whereClause, whereArgs);
    }

    public long update(User user){

        String whereClause = DatabaseHelper.COLUMN_ID + "=" + String.valueOf(user.getId());
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_NAME, user.getName());
        cv.put(DatabaseHelper.COLUMN_YEAR, user.getYear());
        return database.update(DatabaseHelper.TABLE, cv, whereClause, null);
    }
    */
}
