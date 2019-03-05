package edu.cnm.deepdive.flickpick.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.util.List;

@Entity
public class Watchlist {

  @ColumnInfo (name = "watchlist")
  @PrimaryKey (autoGenerate = true)
  private List<String> name;

  private List<String> genre;

  //private
}
