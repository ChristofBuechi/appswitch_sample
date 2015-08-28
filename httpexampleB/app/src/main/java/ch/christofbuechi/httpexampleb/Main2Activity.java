package ch.christofbuechi.httpexampleb;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
