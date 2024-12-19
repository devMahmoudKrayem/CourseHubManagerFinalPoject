package com.example.coursehubmanagerfinalpoject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = User.class,parentColumns = {"id"},childColumns = {"user_id"}),
        @ForeignKey(entity = Courses.class,parentColumns = {"courses_id"},childColumns = "course_id")})
public class MyCourses {
    @PrimaryKey(autoGenerate = true)
    private long id_mc;
    @ColumnInfo(name = "user_id")
    private long user_id;
    @ColumnInfo(name = "course_id")
    private long course_id;
    @ColumnInfo(name = "completed")
    private boolean completed;
    @ColumnInfo(name = "progress")
    private int progress;

    public MyCourses(long id_mc, long user_id, long course_id, boolean completed, int progress) {
        this.id_mc = id_mc;
        this.user_id = user_id;
        this.course_id = course_id;
        this.completed = completed;
        this.progress = progress;
    }

    public long getId_mc() {
        return id_mc;
    }

    public void setId_mc(long id_mc) {
        this.id_mc = id_mc;
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
