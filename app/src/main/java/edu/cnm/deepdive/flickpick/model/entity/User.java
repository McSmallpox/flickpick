package edu.cnm.deepdive.flickpick.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.util.List;

/**
 * @author Ryan Lee
 * @version 1.0
 */

@Entity (tableName = "movieInfo")
public class User {

  @ColumnInfo (name = "user_")
  @PrimaryKey (autoGenerate = true)
  private Long userID;

  private String favGenre;

  private String recentSearch;



  public Long getUserID() {
    return userID;
  }

  public void setUserID(Long userID) {
    this.userID = userID;
  }

  public String getFavGenre() {
    return favGenre;
  }

  public void setFavGenre(String favGenre) {
    this.favGenre = favGenre;
  }

  public String getRecentSearch() {
    return recentSearch;
  }

  public void setRecentSearch(String recentSearch) {
    this.recentSearch = recentSearch;
  }
}
