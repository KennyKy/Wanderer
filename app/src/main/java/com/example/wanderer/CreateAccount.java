package com.example.wanderer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wanderer.database.dao.UsersDAO;
import com.example.wanderer.database.model.UserModel;
import androidx.appcompat.app.AppCompatActivity;

public class CreateAccount extends AppCompatActivity {
    private EditText editUser;
    private EditText editPassword;
    private EditText editEmail;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
        editUser = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        editEmail = findViewById(R.id.editEmail);
        signup = findViewById(R.id.create_account);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel userModel = new UserModel();

                userModel.setUsername(editUser.getText().toString());
                userModel.setEmail(editEmail.getText().toString());
                userModel.setPassword(editPassword.getText().toString());

                if (editUser.getText().toString() == "" || editEmail.getText().toString() == "" || editPassword.getText().toString() == ""){
                    Toast.makeText(CreateAccount.this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show();

                    return;
                }

                UserModel verifyUserModel = new UserModel();
                UsersDAO dao = new UsersDAO(CreateAccount.this);

                verifyUserModel = dao.select(userModel.getUsername());

                if ( verifyUserModel != null ) {
                    Toast.makeText(CreateAccount.this, "Usuário já cadastrado, por favor insira outro usuário.", Toast.LENGTH_SHORT).show();
                } else {
                    if ( dao.insert(userModel) != -1 ) {
                        Toast.makeText(CreateAccount.this, "Usuário cadastrado.", Toast.LENGTH_LONG).show();
                        Intent login = new Intent(CreateAccount.this, MainActivity.class);
                        startActivity(login);
                    }
                }
            }
        });
    }
}
