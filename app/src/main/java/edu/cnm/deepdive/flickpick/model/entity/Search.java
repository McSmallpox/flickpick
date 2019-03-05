package edu.cnm.deepdive.flickpick.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.util.List;


@Entity
public class Search {

  @ColumnInfo (name = "search_field")
  @PrimaryKey (autoGenerate = true)
  private boolean Movie;
// verify whether user is searching for movies or TV shows.
  private boolean tvShow;

  private List<String> actor;

  private List<String> genre;

  private String director;

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

  public List<String> getGenre() {
    return genre;
  }

  public void setGenre(List<String> genre) {
    this.genre = genre;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
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

  public List<String> getActor() {
    return actor;
  }

  public void setActor(List<String> actor) {
    this.actor = actor;
  }
}
