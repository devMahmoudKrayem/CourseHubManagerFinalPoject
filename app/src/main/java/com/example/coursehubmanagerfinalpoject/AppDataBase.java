package com.example.coursehubmanagerfinalpoject;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Courses.class, Lessons.class, Categories.class, Bookmark.class,MyCourses.class},version = 1,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract CoursesDao coursesDao();
    public abstract LessonsDao lessonsDao();
    public abstract CategoriesDao categoriesDao();
    public abstract BookmarkDao bookmarkDao();
    public abstract MyCoursesDao myCoursesDao();

    private static volatile AppDataBase INSTANCE;

    static AppDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDataBase.class, "AppDataDatabase").allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
