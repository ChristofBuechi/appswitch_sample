package ch.christofbuechi.httpexamplea;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.UUID;

public class LoginActivity extends AppCompatActivity {


    public static final String ACTION = "mypersonalbroadcast";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button = (Button) findViewById(R.id.other_app_button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptStartNewActivity();
            }
        });

        Button buttonCheckUserHA123456 = (Button) findViewById(R.id.checkuserHA123456);
        buttonCheckUserHA123456.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUserHA123456();
            }
        });

        Button buttonCheckUserHA654321 = (Button) findViewById(R.id.checkuserHA654321);
        buttonCheckUserHA654321.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUserHA654321();
            }
        });

        Button buttonCheckUserHA111111 = (Button) findViewById(R.id.checkuserHA111111);
        buttonCheckUserHA111111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUserHA111111();
            }
        });
    }

    public void attemptStartNewActivity() {
        Intent intent = getPackageManager().getLaunchIntentForPackage("ch.christofbuechi.httpexampleb");
        if (intent != null) {

            Snackbar
                    .make(getWindow().getDecorView().findViewById(android.R.id.content), R.string.installed, Snackbar.LENGTH_LONG)
                    .show(); // Don’t forget to show!

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {

                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("ch.christofbuechi.httpexampleb", "ch.christofbuechi.httpexampleb.IntentStartActivity"));
                    intent.putExtra("userID", "HA123456");
                    intent.putExtra("sessionId", UUID.randomUUID().toString());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }, 500);

        } else {
            Snackbar
                    .make(getWindow().getDecorView().findViewById(android.R.id.content), R.string.not_installed, Snackbar.LENGTH_LONG)
                    .show(); // Don’t forget to show!

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setData(Uri.parse("market://details?id=" + "ch.hsr.hsrlunch"));
                    startActivity(intent);
                }
            }, 500);
        }
    }

    private void checkUserHA123456() {
        Log.d("BroadcastQueue", "send: checkUserHA123456");
        Intent intent = new Intent();
        intent.setAction("ch.christofbuechi.android.mybroadcastRequest");
        intent.putExtra("User", "HA123456");
        sendBroadcast(intent);
    }

    private void checkUserHA654321() {
        Log.d("BroadcastQueue", "send: checkUserHA654321");
        Intent intent = new Intent();
        intent.setAction("ch.christofbuechi.android.mybroadcastRequest");
        intent.putExtra("User", "HA654321");
        sendBroadcast(intent, "ch.christofbuechi.httpB_perm");
    }


    private void checkUserHA111111() {
        Log.d("BroadcastQueue", "send: checkUserHA111111");
        Intent intent = new Intent(ACTION);
        intent.putExtra("User", "HA111111");
        intent.setAction("ch.christofbuechi.android.mybroadcastRequest");
        sendOrderedBroadcast(intent, "ch.christofbuechi.httpB_perm");



//        IntentFilter filter = new IntentFilter(ACTION);
//        registerReceiver(new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                Bundle results = getResultExtras(true);
//                String trail = results.getString("User");
//                results.putString("User", trail + "->" + "receiver" + "isprovisioned");
//                Log.i("receiver", "Same Class Receiver");
//            }
//        }, filter);


//        Intent intent = new Intent(ACTION);
//        intent.putExtra("User", "HA111111");
//
//        sendOrderedBroadcast(intent, null, new BroadcastReceiver() {
//            @SuppressLint("NewApi")
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                Bundle results = getResultExtras(true);
//
//                String trail = results.getString("User");
////                results.putString("User", trail + "->" + "sometext");
//                Log.i(this.getClass().getName(), "Final Result Receiver = " + results.getString("User", "nil"));
//            }
//        }, null, Activity.RESULT_OK, null, null);
    }
}

