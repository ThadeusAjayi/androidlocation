package shopspreeng.locationtest;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentSender;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import static android.content.ContentValues.TAG;
import static java.security.AccessController.getContext;
import static shopspreeng.locationtest.MainActivity.LOCATION_SETTINGS_REQUEST;

/**
 * Created by Thadeus-APMIS on 5/25/2018.
 */

public class Utils {

    public static void checkLocation (final Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        // Find out what the settings say about which providers are enabled
        int mode = Settings.Secure.getInt(
                contentResolver, Settings.Secure.LOCATION_MODE, Settings.Secure.LOCATION_MODE_OFF);

        if (mode == Settings.Secure.LOCATION_MODE_OFF) {
            // Location is turned OFF!
            Log.v("Turned OFF","OFF");

            if (context instanceof LocationService) {
                ((MainActivity)MainActivity.getCurrentActivity()).showTurnOnLocationDialog();
            } else {
                ((MainActivity) context).showTurnOnLocationDialog();
            }

        } else {
            Log.v("Turned ON","ON");
        }
    }

    public static LocationRequest locationRequest () {
        return LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(1000);
    }



}
