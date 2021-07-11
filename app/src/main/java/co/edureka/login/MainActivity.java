package co.edureka.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userName, userPassword;
    Button buttonlogin;
    TextView tv;
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.userName);
        userPassword = (EditText) findViewById(R.id.password);
        tv = (TextView) findViewById(R.id.showText);

        buttonlogin = (Button) findViewById(R.id.login);


    }

    public void loginfunction(View view) {
        // Toast will not work in threads
        Toast.makeText(this, "Edit DATA: "+userName.getText().toString()+" : "+userPassword.getText().toString(),
                Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);


        Bundle bundle = new Bundle();
            bundle.putString(KEY_USERNAME, userName.getText().toString());
            bundle.putString(KEY_PASSWORD, userPassword.getText().toString());

            intent.putExtras(bundle);

        //startActivity(intent);

        startActivityForResult(intent, 2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2){
            String msg = data.getStringExtra("MESSAGE");
            tv.setText(msg);
        }

    }
}