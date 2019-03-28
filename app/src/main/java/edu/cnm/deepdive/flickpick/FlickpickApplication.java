package edu.cnm.deepdive.flickpick;

import android.app.Application;
import com.facebook.stetho.Stetho;


public class FlickpickApplication extends Application {

  private static FlickpickApplication instance = null;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
    Stetho.initializeWithDefaults(this); // Comment out this line to disable Stetho.
  }

  public static FlickpickApplication getInstance() {
    return instance;
  }
}
