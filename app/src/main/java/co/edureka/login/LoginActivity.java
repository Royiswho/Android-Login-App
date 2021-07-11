package co.edureka.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    TextView username1, password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username1 = (TextView) findViewById(R.id.userName);
        password1 = (TextView) findViewById(R.id.password);

        Bundle bundle = getIntent().getExtras();

            String username = bundle.getString(KEY_USERNAME);
            String pw       = bundle.getString(KEY_PASSWORD);

        //log
        //toast
        username1.setText(username);
        password1.setText(pw);

        Intent intent = new Intent();

        if (pw.equalsIgnoreCase("password")){
            intent.putExtra("MESSAGE", "SUCCESS...");
        }
        else {
            intent.putExtra("MESSAGE", "Please enter the right password...");
        }
        setResult(2, intent);
        finish();//kill current activity
    }
}