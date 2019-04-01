package edu.cnm.deepdive.flickpick.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * @author Ryan Lee
 * @version 1.0
 */

public class SearchResponse {

  @SerializedName("page")
  @Expose
  private Integer page;
  @SerializedName("total_results")
  @Expose
  private Integer totalResults;
  @SerializedName("total_pages")
  @Expose
  private Integer totalPages;
  @SerializedName("results")
  @Expose
  private List<MovieResult> results = null;

  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Integer getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(Integer totalResults) {
    this.totalResults = totalResults;
  }

  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public List<MovieResult> getResults() {
    return results;
  }

  public void setResults(List<MovieResult> results) {
    this.results = results;
  }

}
