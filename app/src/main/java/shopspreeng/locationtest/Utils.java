package shopspreeng.locationtest;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;

/**
 * Created by Thadeus-APMIS on 5/25/2018.
 */

public class Utils {

    public static void checkLocation (Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        // Find out what the settings say about which providers are enabled
        int mode = Settings.Secure.getInt(
                contentResolver, Settings.Secure.LOCATION_MODE, Settings.Secure.LOCATION_MODE_OFF);

        if (mode == Settings.Secure.LOCATION_MODE_OFF) {
            // Location is turned OFF!
            Log.v("Turned OFF","OFF");
        } else {
            Log.v("Turned ON","ON");
        }
    }

}
