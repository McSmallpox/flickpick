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

/**
 *
 * @author Ryan Lee
 * @version 1.0
 *
 * Fragment in which users pass filters by which they want to search for films.
 * Includes buttons in xml which, when clicked, invoke methods onGenreClicked(), onYearSingleSelected(),
 * and onDecadeSelected().
 */
public class SearchFragment extends Fragment implements OnClickListener {

  ListView listView;

  ArrayList<String> holdFilter;
  ArrayList<String> genre;
  ArrayList<Integer> year;
  ArrayList<String> director;
  ArrayList<String> actors;
  ArrayList<ArrayList<String>> search;


  /**
   *  Inflates UI on creation of fragment and instantiates ArrayLists.
   * @param inflater inflates fragment_search layout
   * @param container
   * @param savedInstanceState
   * @return view with inflated XML.
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

  /**
   * Instantiating buttons for use in the UI.
   * @param savedInstanceState
   */
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

  /**
   * Invoked when R.id.add_genre is clicked. Adds selected entry to the genre ArrayList
   * and invokes UpdateFilter().
   */
  private void onGenreClicked() {
    View view = getView();
    Spinner genre_spinner = view.findViewById(R.id.genre_spinner);
    ArrayAdapter<String> adapter = (ArrayAdapter<String>) genre_spinner.getAdapter();
    int pos = genre_spinner.getSelectedItemPosition();
    String selectedGenre = adapter.getItem(pos);
    genre.add(selectedGenre);
    updateFilter(selectedGenre);
  }

  /**
   * Invokes when R.id.add_year_single is clicked. Adds selected entry to the year ArrayList
   * and invokes UpdateFilter(). Also Overrides onPostExecute method to return movies released in the selected year.
   */
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

  /**
   * Invokes when R.id.add_year_decade is clicked. Adds selected all years of the selected decade (ex. selected decade is 1990,
   * will add 1990 - 1999) to year ArrayList. Invokes UpdateFilter().
   */
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

  /**
   * Updates ListView within R.id.filter_container with filters passed into it whenever a method is called upon clicking a button.
   * @param filter Passed into when the method is invoked in other methods, such as onGenreClicked(), and will display on the ListView.
   */
  private void updateFilter(String filter) {
    holdFilter.add(filter);
    ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.list_item, holdFilter);
    listView.setAdapter(adapter);
  }

  /**
   * Invokes OnGenreClicked(), onYearSingleClicked(), or onDecadeClicked() whenever their corresponding buttons are clicked.
   * Selected filters are added to their respective ArrayLists and updateFilter() is invoked.
   * @param v
   */
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
