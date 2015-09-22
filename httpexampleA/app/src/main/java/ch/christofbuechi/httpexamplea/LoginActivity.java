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

public class LoginActivity extends AppCompatActivity {


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
                    intent.putExtra("sessionId", "65464541645445151554");
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
}

