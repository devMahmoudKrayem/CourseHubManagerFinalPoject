package com.example.coursehubmanagerfinalpoject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    long insertUser (User user);
    @Update
    int  updateUser (User User);
    @Query("select * from table_user")
    List<User>getAlluseres();
    @Query("select * from table_user where user_email=:email and user_password=:password")
   User getusere(String email,String password);
    @Delete
    int deleteUsers(User user);


}
