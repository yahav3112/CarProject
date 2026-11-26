package com.example.carproject;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText etFullName, etRegisterUsername, etRegisterEmail, etRegisterPassword, etPhone;
    private RadioGroup rgGender;
    private MaterialButton btnRegister;
    private TextView tvGotoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
        setupListeners();
    }

    private void initViews() {
        etFullName = findViewById(R.id.etFullName);
        etRegisterUsername = findViewById(R.id.etRegisterUsername);
        etRegisterEmail = findViewById(R.id.etRegisterEmail);
        etRegisterPassword = findViewById(R.id.etRegisterPassword);
        etPhone = findViewById(R.id.etPhone);
        rgGender = findViewById(R.id.rgGender);
        btnRegister = findViewById(R.id.btnRegister);
        tvGotoLogin = findViewById(R.id.tvGotoLogin);
    }

    private void setupListeners() {
        btnRegister.setOnClickListener(v -> {
            String fullName = etFullName.getText() != null ? etFullName.getText().toString().trim() : "";
            String username = etRegisterUsername.getText() != null ? etRegisterUsername.getText().toString().trim() : "";
            String email = etRegisterEmail.getText() != null ? etRegisterEmail.getText().toString().trim() : "";
            String password = etRegisterPassword.getText() != null ? etRegisterPassword.getText().toString().trim() : "";
            String phone = etPhone.getText() != null ? etPhone.getText().toString().trim() : "";
            int selectedGenderId = rgGender.getCheckedRadioButtonId();

            if (TextUtils.isEmpty(fullName) || TextUtils.isEmpty(username) ||
                    TextUtils.isEmpty(email) || TextUtils.isEmpty(password) ||
                    TextUtils.isEmpty(phone) || selectedGenderId == -1) {
                Toast.makeText(RegisterActivity.this, R.string.error_register_empty, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(RegisterActivity.this, R.string.register_success, Toast.LENGTH_LONG).show();
                finish(); // Return to LoginActivity
            }
        });

        tvGotoLogin.setOnClickListener(v -> finish());
    }
}
