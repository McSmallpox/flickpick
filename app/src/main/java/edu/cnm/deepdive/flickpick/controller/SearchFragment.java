package edu.cnm.deepdive.flickpick.controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import edu.cnm.deepdive.flickpick.R;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment implements OnClickListener {

  ArrayList<String> Genre;
  int[] Year;
  String[] Director;
  String[] Actors;
  String[] Writer;
  String[] Composer;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
   View view = inflater.inflate(R.layout.fragment_search, container, false);
    return view;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    View view = getView();
    Button add_filter_1 = view.findViewById(R.id.add_genre);
    add_filter_1.setOnClickListener(this);
  }

  private void onGenreClicked() {
    View view = getView();
    Spinner genre_spinner = view.findViewById(R.id.genre_spinner);
    ArrayAdapter<String> adapter = (ArrayAdapter<String>) genre_spinner.getAdapter();
    int pos = genre_spinner.getSelectedItemPosition();
    String selectedGenre = adapter.getItem(pos);
      Genre.add(selectedGenre);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.add_genre:
        onGenreClicked();
        break;
    }
  }
}
