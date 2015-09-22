package ch.christofbuechi.httpexampleb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;import java.lang.Boolean;import java.lang.Override;import java.lang.String;

/**
 * Created by bui on 02.09.15.
 */
public class UserCheckReceiverRequest extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        String userToCheck = intent.getStringExtra("User");
        Log.d(this.getClass().getName(), "User to Check: " + userToCheck);

        Boolean isProvisioned = checkIfUserIsProvisioned(userToCheck);

        if (isProvisioned) {
            Log.d(this.getClass().getName(), "User is Provisioned: " + userToCheck);
//            Toast.makeText(context, "User is Provisioned: " + String.valueOf(isProvisioned),
//                    Toast.LENGTH_LONG).show();
        }
        Intent respondIntent = new Intent();
        respondIntent.setAction("ch.christofbuechi.android.mybroadcastRespond");
        respondIntent.putExtra("isProvisioned", isProvisioned);
        context.sendBroadcast(respondIntent);


    }

    private boolean checkIfUserIsProvisioned(String userToCheck) {
        //actually there is just one user provisioned - it abstracts the check
        if ("HA123456".equals(userToCheck))
            return true;
        else
            return false;
    }
}
