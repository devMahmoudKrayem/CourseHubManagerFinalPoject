package com.example.coursehubmanagerfinalpoject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CoursesDao {
    @Insert
    long insertCourse (Courses courses);
    @Update
    long updateCourse (Courses courses);
    @Query("select * from Courses")
    List<Courses> getAllCourses();
    @Delete
    int deleteCourse(Courses courses);

}
