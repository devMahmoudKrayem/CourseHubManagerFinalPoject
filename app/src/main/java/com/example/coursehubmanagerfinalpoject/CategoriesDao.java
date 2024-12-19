package com.example.coursehubmanagerfinalpoject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CategoriesDao {
    @Insert
    long insertCategories (Categories categories);
    @Update
    long updateCategories (Categories categories);
    @Query("select * from table_categories")
    List<Categories> getAllCategories();
    @Delete
    int deleteCategories(Categories categories);
}
