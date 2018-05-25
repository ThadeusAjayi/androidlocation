package shopspreeng.locationtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by Thadeus-APMIS on 5/25/2018.
 */

public class LocationReciever extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        if (intent.getAction().matches("android.location.PROVIDERS_CHANGED")) {
            context.startService(new Intent(context, LocationService.class));
        }
    }
}
