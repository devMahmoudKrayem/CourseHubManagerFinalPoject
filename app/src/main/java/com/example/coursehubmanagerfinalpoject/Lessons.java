package com.example.coursehubmanagerfinalpoject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Courses.class,parentColumns = {"courses_id"},childColumns = {"course_id"}))
public class Lessons {
    @PrimaryKey(autoGenerate = true)
    private long id_lessons;
    @ColumnInfo(name = "description_lesson")
    private String description_lesson;
    @ColumnInfo(name = "url_lesson")

    private String url;
    @ColumnInfo(name = "num_lesson")

    private String num_of_lesson;
    @ColumnInfo(name = "name_lesson")

    private String name_lesson;
    @ColumnInfo(name = "course_id")
     private long course_id;

    public Lessons(long id_lessons, String description_lesson, String url, String num_of_lesson, String name_lesson, long course_id) {
        this.id_lessons = id_lessons;
        this.description_lesson = description_lesson;
        this.url = url;
        this.num_of_lesson = num_of_lesson;
        this.name_lesson = name_lesson;
        this.course_id = course_id;
    }

    public long getId_lessons() {
        return id_lessons;
    }

    public void setId_lessons(long id_lessons) {
        this.id_lessons = id_lessons;
    }

    public String getDescription_lesson() {
        return description_lesson;
    }

    public void setDescription_lesson(String description_lesson) {
        this.description_lesson = description_lesson;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNum_of_lesson() {
        return num_of_lesson;
    }

    public void setNum_of_lesson(String num_of_lesson) {
        this.num_of_lesson = num_of_lesson;
    }

    public String getName_lesson() {
        return name_lesson;
    }

    public void setName_lesson(String name_lesson) {
        this.name_lesson = name_lesson;
    }

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }
}
