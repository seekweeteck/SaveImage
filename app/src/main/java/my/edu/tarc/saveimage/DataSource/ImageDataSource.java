package my.edu.tarc.saveimage.DataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import my.edu.tarc.saveimage.Model.ImageFile;

/**
 * Created by KweeTeck on 11/1/2017.
 */

public class ImageDataSource {
    private SQLiteDatabase database;
    private ImageSQLHelper dbHelper;
    public ImageDataSource(Context context) {
        dbHelper = new ImageSQLHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }

    public void deleteRecord(int id){
        try{
            database= dbHelper.getWritableDatabase();
            int rowcount = database.delete(ImageDataContract.TABLE_NAME,
                    "id" + "=?",
                    new String[] { ""+id });
            database.close();
        }catch (Exception e){
            Log.d("Delete", e.getMessage());
        }

    }

    public void insertImage(ImageFile image){
        ContentValues values = new ContentValues();
        values.put( ImageDataContract.COLUMN_ID, image.getId());
        values.put( ImageDataContract.COLUMN_IMAGE, image.getImage());
        database = dbHelper.getWritableDatabase();
        database.insert(ImageDataContract.TABLE_NAME, null, values);
        database.close();
    }

    public List<ImageFile> getAllImages(){
        List<ImageFile> records = new ArrayList<>();

        database = dbHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + ImageDataContract.TABLE_NAME, null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            ImageFile ImageRecord= new ImageFile();
            ImageRecord.setId(cursor.getInt(0));
            ImageRecord.setImage(cursor.getString(1));

            records.add(ImageRecord);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return records;
    }

}
