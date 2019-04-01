package edu.cnm.deepdive.flickpick.model.dao;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.flickpick.model.entity.User;
import java.util.List;

/**
 * @author Ryan Lee
 * @version 1.0
 */

@Dao
public interface UserDao {

@Insert
  List<User> insert (User... users);



}
