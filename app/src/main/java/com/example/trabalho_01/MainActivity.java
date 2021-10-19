package com.example.trabalho_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editUser;
    private EditText editPassword;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUser = findViewById(R.id.editUser);
        editPassword = findViewById(R.id.editPassword);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editUser.getText().toString().isEmpty()) {
                    editUser.setError("Required field!!");
                }
            }
        });
    }
}