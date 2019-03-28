package edu.cnm.deepdive.flickpick.controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import edu.cnm.deepdive.flickpick.R;
import edu.cnm.deepdive.flickpick.model.entity.Search;
import edu.cnm.deepdive.flickpick.model.pojo.MovieResult;
import edu.cnm.deepdive.flickpick.service.MovieWebService.SearchMoviesTask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchFragment extends Fragment implements OnClickListener {

  ListView listView;

  ArrayList<String> holdFilter;
  ArrayList<String> genre;
  ArrayList<Integer> year;
  ArrayList<String> director;
  ArrayList<String> actors;
  ArrayList<ArrayList<String>> search;


  /**
   *  Instantiates UI on creation of fragment.
   * @param inflater inflates fragment_search layout
   * @param container
   * @param savedInstanceState
   * @return
   */
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_search, container, false);
    listView = view.findViewById(R.id.lv);
    holdFilter = new ArrayList<>();
    genre = new ArrayList<>();
    year = new ArrayList<>();
    director = new ArrayList<>();
    actors = new ArrayList<>();
    search = new ArrayList<>();
    return view;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    View view = getView();
    Button add_filter_1 = view.findViewById(R.id.add_genre);
    add_filter_1.setOnClickListener(this);
    Button add_year_single = view.findViewById(R.id.add_year_single);
    add_year_single.setOnClickListener(this);
    Button add_decade = view.findViewById(R.id.add_year_decade);
    add_decade.setOnClickListener(this);
  }

  private void onGenreClicked() {
    View view = getView();
    Spinner genre_spinner = view.findViewById(R.id.genre_spinner);
    ArrayAdapter<String> adapter = (ArrayAdapter<String>) genre_spinner.getAdapter();
    int pos = genre_spinner.getSelectedItemPosition();
    String selectedGenre = adapter.getItem(pos);
    genre.add(selectedGenre);
    updateFilter(selectedGenre);
  }

  private void onYearSingleClicked() {
    View view = getView();
    TextInputLayout year_input = view.findViewById(R.id.year_entry_holder);
    EditText input = view.findViewById(R.id.year_entry);
    String selectedYear = year_input.getEditText().getText().toString();
    int yearInt = Integer.parseInt(selectedYear);
    year.add(yearInt);
    updateFilter(selectedYear);
    Search search = new Search();
    search.setSpecYear(yearInt);
    new SearchMoviesTask(){
      @Override
      protected void onPostExecute(List<MovieResult> movieResults) {
        Log.v("movies", Arrays.toString(movieResults.toArray()));
      }
    }.execute(search);
  }

  private void onDecadeClicked() {
    View view = getView();
    Spinner year_spinner = view.findViewById(R.id.year_spinner);
    ArrayAdapter<String> adapter = (ArrayAdapter<String>) year_spinner.getAdapter();
    int pos = year_spinner.getSelectedItemPosition();
    String selectedYears = adapter.getItem(pos);
    String selectedYearsReal = selectedYears.replaceAll("[^0-9]", "");
    selectedYears = selectedYearsReal;
    int yearsInt = Integer.parseInt(selectedYears);
      for (int i = yearsInt; i <= yearsInt + 9; i++) {
        String tempString = Integer.toString(i);
        year.add(i);
        updateFilter(tempString);
      }
    }

  private void updateFilter(String filter) {
    holdFilter.add(filter);
    ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.list_item, holdFilter);
    listView.setAdapter(adapter);
  }

  private void finalizeSearch() {

  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.add_genre:
        onGenreClicked();
        break;
      case R.id.add_year_single:
        onYearSingleClicked();
        break;
      case R.id.add_year_decade:
        onDecadeClicked();
        break;
    }
  }


}
