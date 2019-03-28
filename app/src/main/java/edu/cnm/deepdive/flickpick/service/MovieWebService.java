package edu.cnm.deepdive.flickpick.service;

import android.os.AsyncTask;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.flickpick.BuildConfig;
import edu.cnm.deepdive.flickpick.FlickpickApplication;
import edu.cnm.deepdive.flickpick.R;
import edu.cnm.deepdive.flickpick.model.entity.Search;
import edu.cnm.deepdive.flickpick.model.pojo.MovieResult;
import edu.cnm.deepdive.flickpick.model.pojo.SearchResponse;
import java.io.IOException;
import java.util.List;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieWebService {

  @GET("/3/discover/movie")
  Call<SearchResponse> findMovie(@Query("api_key") String apiKey, @Query("primary_release_year") int year, @Query("with_genres") String withGenres);

  class InstanceHolder {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final MovieWebService INSTANCE;
    private static final String API_KEY;

    static {
      FlickpickApplication application = FlickpickApplication.getInstance();
      Gson gson = new GsonBuilder()
          .excludeFieldsWithoutExposeAnnotation()
          /*.setDateFormat(DATE_FORMAT)
          .registerTypeAdapter(Date.class, new DateJsonConverter(DATE_FORMAT))*/
          .create();
      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl(application.getApplicationContext().getString(R.string.base_url))
          .addConverterFactory(GsonConverterFactory.create(gson))
          .build();
      INSTANCE = retrofit.create(MovieWebService.class);
      API_KEY = BuildConfig.API_KEY;
    }

  }

  class SearchMoviesTask extends AsyncTask<Search, Void, List<MovieResult>>{

    @Override
    protected List<MovieResult> doInBackground(Search... searches) {
      String genres = null;
      if (searches[0].getGenre() != null) {
        genres = String.join(",", searches[0].getGenre());
      }
      try {
        Response<SearchResponse> response = InstanceHolder.INSTANCE
            .findMovie(InstanceHolder.API_KEY, searches[0].getSpecYear(), genres)
            .execute();
        return response.body().getResults();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

}
