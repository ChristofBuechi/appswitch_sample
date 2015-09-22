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
}
