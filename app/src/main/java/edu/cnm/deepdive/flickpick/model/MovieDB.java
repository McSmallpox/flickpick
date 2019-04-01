package edu.cnm.deepdive.flickpick.model;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import edu.cnm.deepdive.flickpick.model.entity.Search;
import edu.cnm.deepdive.flickpick.model.entity.User;

@Database(entities = {Search.class, User.class}, version = 1, exportSchema = true)
public abstract class MovieDB extends RoomDatabase {


}
