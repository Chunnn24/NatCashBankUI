package com.example.natcashbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;

import com.example.natcashbank.databinding.ActivityHomeBinding;
import com.example.natcashbank.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private static final String MY_SHARE_PREFERENCE = "MY_SHARE_PREFERENCE";
    private static final String KEY_PHONE = "KEY_PHONE";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        sharedPreferences = getSharedPreferences(MY_SHARE_PREFERENCE,MODE_PRIVATE);



        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, LoginHomeActivity.class);
                startActivity(intent);

                binding.txtAccount.onEditorAction(EditorInfo.IME_ACTION_DONE);

                // put data khi click vào button
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_PHONE,binding.txtAccount.getText().toString());
                editor.apply();
            }
        });
    }
}