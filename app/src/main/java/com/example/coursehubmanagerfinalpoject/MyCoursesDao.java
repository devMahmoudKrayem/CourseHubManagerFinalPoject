package com.example.coursehubmanagerfinalpoject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyCoursesDao {
    @Insert
    long insertMyCourses (MyCourses myCourses);
    @Update
    int updateMyCourses (MyCourses myCourses);
    @Query("select * from mycourses")
    List<MyCourses> getAllMyCourses();
    @Delete
    int deleteMyCourses(MyCourses myCourses);
}
