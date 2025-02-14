package com.example.bankaccsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bankaccsystem.R;

public class LoginActivity extends Activity {
    private EditText uname;
    private EditText pword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        uname = (EditText) findViewById(R.id.username);
        pword = (EditText) findViewById(R.id.password);
    }

    public void login(View view) {
        String username = uname.getText().toString();
        String password = pword.getText().toString();

        if (username.equals("YS") && password.equals("1234")) {
            // Successfully logged in
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            finish();
        } else {

            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
        }
    }
}
