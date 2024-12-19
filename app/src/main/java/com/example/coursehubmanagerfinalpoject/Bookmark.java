package com.example.coursehubmanagerfinalpoject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = User.class,parentColumns = {"id"},childColumns = {"user_id"})
        ,@ForeignKey(entity = Courses.class,parentColumns = {"courses_id"},childColumns = {"id_course"})})
public class Bookmark {
    @PrimaryKey(autoGenerate = true)
    private long id_book;
    @ColumnInfo(name = "id_user")
    private long user_id;
    @ColumnInfo(name = "id_course")
    private long course_id;

    public Bookmark(long id_book, long user_id, long course_id) {
        this.id_book = id_book;
        this.user_id = user_id;
        this.course_id = course_id;
    }

    public long getId_book() {
        return id_book;
    }

    public void setId_book(long id_book) {
        this.id_book = id_book;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }
}
