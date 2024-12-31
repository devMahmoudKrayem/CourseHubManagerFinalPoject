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
    int updateCourse (Courses courses);
    @Query("select * from Courses")
    List<Courses> getAllCourses();
    @Query("select * from Courses where category_id=:cat_id")
    List<Courses> getAllCoursesbycat(long cat_id);
    @Delete
    int deleteCourse(Courses courses);

}
