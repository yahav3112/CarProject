package com.example.carproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LogInActivity extends AppCompatActivity {

    private TextInputEditText etUsernameOrEmail, etPassword;
    private MaterialButton btnLogin;
    private TextView tvGotoRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
        setupListeners();
    }

    private void initViews() {
        etUsernameOrEmail = findViewById(R.id.etUsernameOrEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvGotoRegister = findViewById(R.id.tvGotoRegister);
    }

    private void setupListeners() {
        btnLogin.setOnClickListener(v -> {
            String userOrEmail = etUsernameOrEmail.getText() != null ? etUsernameOrEmail.getText().toString().trim() : "";
            String password = etPassword.getText() != null ? etPassword.getText().toString().trim() : "";

            if (TextUtils.isEmpty(userOrEmail) || TextUtils.isEmpty(password)) {
                Toast.makeText(LogInActivity.this, R.string.error_empty_fields, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LogInActivity.this, R.string.login_success, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LogInActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tvGotoRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LogInActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}
