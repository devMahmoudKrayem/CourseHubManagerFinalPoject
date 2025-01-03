package com.example.coursehubmanagerfinalpoject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LessonsDao {
    @Insert
    long insertLessons (Lessons lessons);
    @Update
    int updateLessons (Lessons lessons);
    @Query("select * from Lessons")
    List<Lessons> getAllLessons();
    @Delete
    int deleteLessons(Lessons lessons);
}
