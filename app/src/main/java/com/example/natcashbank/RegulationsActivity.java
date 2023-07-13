package com.example.natcashbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;

import com.example.natcashbank.databinding.ActivityRegulationsBinding;
import com.google.android.material.textfield.TextInputLayout;

public class RegulationsActivity extends AppCompatActivity {
    private ActivityRegulationsBinding binding;

    private static final String MY_SHARE_PREFERENCE = "MY_SHARE_PREFERENCE";

    private static final String KEY_PHONE = "KEY_PHONE";

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegulationsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences(MY_SHARE_PREFERENCE,MODE_PRIVATE);

        binding.btnAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegulationsActivity.this,RegisterActivity.class);
                startActivity(i);

                binding.txtInput.onEditorAction(EditorInfo.IME_ACTION_DONE);

                // put data khi click vào button
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_PHONE,binding.txtInput.getText().toString());
                editor.apply();
            }
        });
    }
}