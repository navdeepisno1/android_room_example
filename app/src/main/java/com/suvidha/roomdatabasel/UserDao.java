package com.suvidha.roomdatabasel;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM UsersTable")
    public List<User> getAll();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
