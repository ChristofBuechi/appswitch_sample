package ch.christofbuechi.httpexampleb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by bui on 02.09.15.
 */
public class UserCheckReceiverRespond extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        boolean isProvisioned = intent.getBooleanExtra("isProvisioned", false);
        Toast.makeText(context, "User is Provisioned: " + isProvisioned,
                Toast.LENGTH_LONG).show();
    }


}
