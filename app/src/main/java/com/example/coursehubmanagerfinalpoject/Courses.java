package com.example.coursehubmanagerfinalpoject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Categories.class,parentColumns ={"id_category"},childColumns = {"category_id"}))
public class Courses {
    @PrimaryKey(autoGenerate = true)
    private long courses_id;
    @ColumnInfo(name = "name_course")
    private String name_course;
    @ColumnInfo(name = "topic_course")
    private  String topic;
    private @ColumnInfo(name = "instructor_name")
    String instructor_name;
    private @ColumnInfo(name ="price_course" )
    String price_course;
    private @ColumnInfo(name = "num_of_students")
    String num_of_students;
    @ColumnInfo(name = "num_of_hours")
    private String num_of_hours;
    @ColumnInfo(name = "image_course")
    private String image_course;
    @ColumnInfo(name = "category_id")
    private int category_id;


        public Courses(String image_course, String num_of_hours, String num_of_students, String price_course, String instructor_name, String topic, String name_course,int category_id) {
        this.image_course = image_course;
        this.num_of_hours = num_of_hours;
        this.num_of_students = num_of_students;
        this.price_course = price_course;
        this.instructor_name = instructor_name;
        this.topic = topic;
        this.name_course = name_course;
        this.category_id=category_id;
    }



    public long getCourses_id() {
        return courses_id;
    }

    public void setCourses_id(long courses_id) {
        this.courses_id = courses_id;
    }

    public String getName_course() {
        return name_course;
    }

    public void setName_course(String name_course) {
        this.name_course = name_course;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getInstructor_name() {
        return instructor_name;
    }

    public void setInstructor_name(String instructor_name) {
        this.instructor_name = instructor_name;
    }

    public String getPrice_course() {
        return price_course;
    }

    public void setPrice_course(String price_course) {
        this.price_course = price_course;
    }

    public String getNum_of_students() {
        return num_of_students;
    }

    public void setNum_of_students(String num_of_students) {
        this.num_of_students = num_of_students;
    }

    public String getNum_of_hours() {
        return num_of_hours;
    }

    public void setNum_of_hours(String num_of_hours) {
        this.num_of_hours = num_of_hours;
    }

    public String getImage_course() {
        return image_course;
    }

    public void setImage_course(String image_course) {
        this.image_course = image_course;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
