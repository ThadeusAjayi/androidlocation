package shopspreeng.locationtest;

import android.app.IntentService;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Thadeus-APMIS on 5/25/2018.
 */

public class LocationService extends IntentService {

    public static final String NAME = LocationService.class.getSimpleName();

    LocationService() {
        super(NAME);
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
       Utils.checkLocation(this);
    }
}
