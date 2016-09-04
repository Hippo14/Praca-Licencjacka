package wmp.uksw.pl.pracalicencjacka_prototyp2.user;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MSI on 2015-11-21.
 */
public class ProfileUser {

    String name;
    String email;
    String password;
    String accountType;
    String userImage;


    public ProfileUser(String name, String email, String password, String accountType, String userImage) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
        this.userImage = userImage;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserImage() {
        return userImage;
    }
}
