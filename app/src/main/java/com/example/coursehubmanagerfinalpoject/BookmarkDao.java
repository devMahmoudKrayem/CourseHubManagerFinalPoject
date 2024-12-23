package com.example.coursehubmanagerfinalpoject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookmarkDao {
    @Insert
    long insertBookmark (Bookmark bookmark);
    @Update
    int updateBookmark (Bookmark bookmark);
    @Query("select * from bookmark")
    List<Bookmark> getAllBookmark();
    @Delete
    int deleteBookmark(Bookmark bookmark);
}
