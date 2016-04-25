package com.ideyatech.moove.sql.dataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.ideyatech.moove.sql.SQLiteHelper;
import com.ideyatech.moove.sql.bean.Merchant;
import com.ideyatech.moove.sql.bean.User;
import com.ideyatech.moove.sql.commands.MerchantsSQL;
import com.ideyatech.moove.sql.commands.UserSQL;

/**
 * Created by IDT-Maynelson-PC on 4/25/2016.
 */
public class UserDataSource {

    // Database fields
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String[] allColumns = {
            UserSQL.COLUMN_ID,
            UserSQL.COLUMN_USERNAME,
            UserSQL.COLUMN_PASSWORD};

    /**
     *
     * @param context
     */
    public UserDataSource(Context context) {

        dbHelper = new SQLiteHelper(context);
    }

    /**
     *
     * @throws SQLException
     */
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    /**
     *
     */
    public void close() {
        dbHelper.close();
    }

    /**
     *
     * @param data
     */
    public void insertData(User data){

        User user = (User)data;

        // COLLECT VALUES
        ContentValues values = new ContentValues();
        values.put(UserSQL.COLUMN_USERNAME, user.getUsername());
        values.put(UserSQL.COLUMN_PASSWORD, user.getPassword());

        // INSERT VALUES TO TABLE
        long insertId = database.insert(UserSQL.TABLE_NAME, null, values);

    }

    /**
     *
     * @param data
     */
    public void getData(User data){

    }
}