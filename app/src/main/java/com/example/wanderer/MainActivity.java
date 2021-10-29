package com.example.wanderer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import com.example.wanderer.database.dao.UsersDAO;
import com.example.wanderer.database.model.User;
import com.example.wanderer.utils.Shared;

public class MainActivity extends AppCompatActivity {

    private EditText editUser;
    private EditText editPassword;
    private Button login;
    private Shared shared;
    private TextView createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUser = findViewById(R.id.editUser);
        editPassword = findViewById(R.id.editPassword);
        login = findViewById(R.id.login);
        createAccount = findViewById(R.id.create_account);
        shared = new Shared(MainActivity.this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();

                user.setUsername(editUser.getText().toString());
                user.setPassword(editPassword.getText().toString());

                User verifyUser = new User();
                UsersDAO dao = new UsersDAO(MainActivity.this);

                verifyUser = dao.verifyLogin(user.getUsername(), user.getPassword());

                if ( verifyUser == null ) {
                    Toast.makeText(MainActivity.this, "Usuário ou senha incorretos.", Toast.LENGTH_SHORT).show();
                } else {
                    shared.put("logged_user", verifyUser.getUsername());
                    Intent travel = new Intent(MainActivity.this, Travel.class);
                    startActivity(travel);
                }
            }
        });

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createAccount = new Intent(MainActivity.this, CreateAccount.class);
                startActivity(createAccount);
            }
        });
    }
}