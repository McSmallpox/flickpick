package edu.cnm.deepdive.flickpick.controller;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import edu.cnm.deepdive.flickpick.R;
import java.util.ResourceBundle;
import java.util.zip.Inflater;
import org.w3c.dom.Text;

public class SearchFragment extends Fragment implements OnClickListener {


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
   View view = inflater.inflate(R.layout.fragment_search, container, false);
    return view;
  }

  @Override
  public void onClick(View v) {
    
  }
}
