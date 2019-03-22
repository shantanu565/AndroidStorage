package com.shantanu.example.androidstorage;

public class Constants {
    static final String ROW_ID="id";
    static final String NAME = "name";
    static final String ADDRESS = "position";
    static final String PHONE = "phone";

    static final String DATABASE_NAME="d_DB";
    static final String TABLE_NAME="d_TB";
    static final int DB_VERSION='1';

    static final String CREATE_TB="CREATE TABLE d_TB(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "name TEXT NOT NULL,position TEXT NOT NULL,phone TEXT NOT NULL);";
}
