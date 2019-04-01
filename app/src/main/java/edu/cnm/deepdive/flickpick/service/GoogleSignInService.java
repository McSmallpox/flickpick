package edu.cnm.deepdive.flickpick.service;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import edu.cnm.deepdive.flickpick.FlickpickApplication;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;


/**
 * @author Ryan Lee
 * @version 1.0
 */

public class GoogleSignInService {

  /**
   * Presents options with which to sign in to Google.
   */

  private GoogleSignInClient client;
    private GoogleSignInAccount account;
    private GoogleSignInService (){
      GoogleSignInOptions options =
          new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
              .requestEmail()
              .requestId()
              .build();
      client = GoogleSignIn.getClient(FlickpickApplication.getInstance(), options);
    }

    public static GoogleSignInService getInstance() {
      return InstanceHolder.INSTANCE;
    }
    public GoogleSignInClient getClient() {
      return client;
    }
    public void setClient(GoogleSignInClient client) {
      this.client = client;
    }
    public GoogleSignInAccount getAccount() {
      return account;
    }

  public void setAccount(GoogleSignInAccount account) {
      this.account = account;
    }
    private static class InstanceHolder {
      private static final GoogleSignInService INSTANCE = new GoogleSignInService();
    }
  }
