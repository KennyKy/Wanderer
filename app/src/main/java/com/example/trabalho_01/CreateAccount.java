package com.example.trabalho_01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabalho_01.database.dao.UsersDAO;
import com.example.trabalho_01.database.model.User;
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
        editUser = findViewById(R.id.username_text_edit);
        editPassword = findViewById(R.id.password_text_edit);
        editEmail = findViewById(R.id.email_text_edit);
        signup = findViewById(R.id.crate_account_button);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();

                user.setUsername(editUser.getText().toString());
                user.setEmail(editEmail.getText().toString());
                user.setPassword(editPassword.getText().toString());

                User verifyUser = new User();
                UsersDAO dao = new UsersDAO(CreateAccount.this);

                verifyUser = dao.verifyLogin(user.getUsername(), user.getPassword());

                if ( verifyUser != null ) {
                    Toast.makeText(CreateAccount.this, "Usuário já cadastrado, por favor insira outro usuário.", Toast.LENGTH_SHORT).show();
                } else {
                    if ( dao.insert(user) != -1 ) {
                        Toast.makeText(CreateAccount.this, "Usuário cadastrado.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
