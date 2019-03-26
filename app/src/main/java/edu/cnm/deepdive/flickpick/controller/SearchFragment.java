package edu.cnm.deepdive.flickpick.controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import edu.cnm.deepdive.flickpick.R;
import java.util.ArrayList;

public class SearchFragment extends Fragment implements OnClickListener {

  ArrayList<String> genre;
  ArrayList<Integer> year;
  String[] director;
  String[] actors;
  String[] writer;
  String[] composer;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_search, container, false);
    genre = new ArrayList<>();
    year = new ArrayList<>();
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
  }

  private void onYearSingleClicked() {
    View view = getView();
    TextInputLayout year_input = view.findViewById(R.id.year_entry);
    String selectedYear = year_input.getEditText().getText().toString();
    int yearInt = Integer.parseInt(selectedYear);
    year.add(yearInt);
  }

  private void onDecadeClicked() {
    View view = getView();
    Spinner year_spinner = view.findViewById(R.id.year_spinner);
    ArrayAdapter<String> adapter = (ArrayAdapter<String>) year_spinner.getAdapter();
    int[] temp = new int[10];
    int pos = year_spinner.getSelectedItemPosition();
    String selectedYears = adapter.getItem(pos);
    String selectedYearsReal = selectedYears.replaceAll("[^0-9]", "");
    selectedYears = selectedYearsReal;
    int yearsInt = Integer.parseInt(selectedYears);
    for (int i = 0; i <= yearsInt + 9; i++) {
      for (int j = 0; j <= year.size() - 1; j++) {
        if (year.get(j) != i) {
          year.add(i);
        }
      }
    }
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
