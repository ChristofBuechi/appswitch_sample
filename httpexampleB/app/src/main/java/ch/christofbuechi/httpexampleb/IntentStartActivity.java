package ch.christofbuechi.httpexampleb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class IntentStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String sessionId = getIntent().getStringExtra("sessionId");
        String userID = getIntent().getStringExtra("userID");


        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("sessionId", sessionId);
        intent.putExtra("userID", userID);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
