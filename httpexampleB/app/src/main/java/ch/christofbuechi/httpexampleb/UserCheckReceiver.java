package ch.christofbuechi.httpexampleb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by bui on 02.09.15.
 */
public class UserCheckReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String userToCheck = intent.getStringExtra("User");
        Log.d(this.getClass().getName(), "User to Check: " + userToCheck);

        Boolean isProvisioned = checkIfUserIsProvisioned(userToCheck);

        if (isProvisioned) {
        Log.d(this.getClass().getName(), "User is Provisioned: " + userToCheck);
            Toast.makeText(context, "User is Provisioned: " + userToCheck,
                    Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkIfUserIsProvisioned(String userToCheck) {
        //actually there is just one user provisioned
        if ("HA123456".equals(userToCheck))
            return true;
        else
            return false;
    }
}
