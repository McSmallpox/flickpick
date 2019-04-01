package edu.cnm.deepdive.flickpick.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.util.List;

/**
 * @author Ryan Lee
 * @version 1.0
 */

@Entity
public class Search {

  @ColumnInfo (name = "search_field")
  @PrimaryKey (autoGenerate = true)
  private boolean Movie;
// verify whether user is searching for movies or TV shows.
  private boolean tvShow;

  private String actor;

  private String genre;

  private String director;

  private boolean isSpecYear;

  private int genDecade;

  private int specYear;




  public boolean isMovie() {
    return Movie;
  }

  public void setMovie(boolean movie) {
    Movie = movie;
  }

  public boolean isTvShow() {
    return tvShow;
  }

  public void setTvShow(boolean tvShow) {
    this.tvShow = tvShow;
  }

  public String getActor() {
    return actor;
  }

  public void setActor(String actor) {
    this.actor = actor;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public boolean isSpecYear() {
    return isSpecYear;
  }

  public void setSpecYear(boolean specYear) {
    isSpecYear = specYear;
  }
  public int getGenDecade() {
    return genDecade;
  }

  public void setGenDecade(int genDecade) {
    this.genDecade = genDecade;
  }

  public int getSpecYear() {
    return specYear;
  }

  public void setSpecYear(int specYear) {
    this.specYear = specYear;
  }
}
