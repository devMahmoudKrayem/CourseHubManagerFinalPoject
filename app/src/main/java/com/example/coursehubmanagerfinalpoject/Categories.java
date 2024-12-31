package com.example.coursehubmanagerfinalpoject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_categories")
public class Categories {

    @PrimaryKey
    private int id_category;
    @ColumnInfo(name = "name_category")
    private  String name_category;

    public Categories(int id_category, String name_category) {
        this.id_category = id_category;
        this.name_category = name_category;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }
}
