package edu.cnm.deepdive.flickpick.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.flickpick.model.entity.Search;
import java.util.List;

/**
 * @author Ryan Lee
 * @version 1.0
 */

@Dao
public interface SearchDao {

@Insert
  List<String> insert(Search... searches);

@Query("SELECT * FROM Search")
  List<Search> findAll();


@Delete
  void delete(Search searches);
}
