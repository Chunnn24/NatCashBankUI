package com.example.natcashbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.natcashbank.databinding.ActivityOnBoardingBinding;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends AppCompatActivity {

    private AdapterOnboard adapterOnboard;
    private ActivityOnBoardingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnBoardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapterOnboard = new AdapterOnboard(this);
        adapterOnboard.setData(getListOB());
        binding.ViewPager2.setAdapter(adapterOnboard);
        binding.LlScroll.setViewPager(binding.ViewPager2);

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextItem = binding.ViewPager2.getCurrentItem() + 1;
                if (nextItem < adapterOnboard.getItemCount()){
                    binding.ViewPager2.setCurrentItem(nextItem);
                } else {
                    Intent i = new Intent(OnBoardingActivity.this,RegulationsActivity.class);
                    startActivity(i);
                }
                binding.ViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        int lastItemPosition = adapterOnboard.getItemCount() ;
                        if (position == lastItemPosition - 1 && positionOffset == 0) {
                            binding.btnNext.setText("Get Started");
                        } else {
                            binding.btnNext.setText("Next");
                        }
                    }
                });
            }
        });
    }
    private List<OnBoardingItem> getListOB() {
        List<OnBoardingItem> onBoardingItems = new ArrayList<>();
        onBoardingItems.add(new OnBoardingItem(R.drawable.img_9,"Super utility","Easy to use, high security, support multiple platforms. Payment, transfer money anytime, anywhere !"));
        onBoardingItems.add(new OnBoardingItem(R.drawable.img_8, "Easy and safe", "Easy to pay Electricity Bill, Water Supply and Microfinance services"));
        onBoardingItems.add(new OnBoardingItem(R.drawable.img_10, "Super promotions", "Topup, Pincode discount up to 10%. Have chance to get cashback up to 100%. More payment, more saving!"));
        return onBoardingItems;
    }
}