package com.example.natcashbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.natcashbank.databinding.ActivityOnBoardingLanguageBinding;
public class OnBoardingLanguageActivity extends AppCompatActivity {
    private ActivityOnBoardingLanguageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnBoardingLanguageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.LlTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.LlTest.setBackgroundResource(R.drawable.custom_ob);
                binding.btnGone.setVisibility(View.GONE);
            }
        });
        binding.LlCreole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.LlCreole.setBackgroundResource(R.drawable.custom_ob);
                binding.btnGone.setVisibility(View.GONE);
            }
        });binding.LlFrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.LlFrance.setBackgroundResource(R.drawable.custom_ob);
                binding.btnGone.setVisibility(View.GONE);
            }
        });
        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OnBoardingLanguageActivity.this,OnBoardingActivity.class);
                startActivity(i);
            }
        });
    }
}