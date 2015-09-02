package ch.christofbuechi.httpexampleb;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends ActionBarActivity {
    private String sessionId;
    private String userID;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sessionId = getIntent().getStringExtra("sessionId");
        userID = getIntent().getStringExtra("userID");


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

    }

    @Override
    protected void onResume() {
        super.onResume();

        mTextView = (TextView) findViewById(R.id.sourceTextView);
        if (sessionId != null && sessionId.length() > 0 && userID != null && userID.length() > 0) {
            mTextView.setText("Your sessionID: " + sessionId + "\n" + "I'm started by Intent" + "\n" + "Login as user: " + userID);
        } else {
            mTextView.setText("Im started normal!! :-(");
        }
    }

    private void checkUserHA654321() {
        Intent intent = new Intent();
        intent.setAction("ch.christofbuechi.android.mybroadcastRequest");
        intent.putExtra("User", "HA654321");
        sendBroadcast(intent);
    }

    private void checkUserHA123456() {
        Intent intent = new Intent();
        intent.setAction("ch.christofbuechi.android.mybroadcastRequest");
        intent.putExtra("User", "HA123456");
        sendBroadcast(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
