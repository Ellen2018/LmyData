package com.ellen.lmydata.sql;

import android.database.sqlite.SQLiteDatabase;

import com.ellen.dhcsqlitelibrary.table.impl.ZxyLibrary;
import com.ellen.dhcsqlitelibrary.table.impl.ZxyTable;
import com.ellen.dhcsqlitelibrary.table.proxy.AutoDesignOperate;
import com.ellen.lmydata.LoginBean;

public class LoginTable extends ZxyTable<LoginBean, AutoDesignOperate> {

    public LoginTable(SQLiteDatabase db, String tableName) {
        super(db, tableName);
    }

    public LoginTable(SQLiteDatabase db) {
        super(db);
    }

    public LoginTable(ZxyLibrary zxyLibrary, String tableName) {
        super(zxyLibrary, tableName);
    }

    public LoginTable(ZxyLibrary zxyLibrary) {
        super(zxyLibrary);
    }
}
