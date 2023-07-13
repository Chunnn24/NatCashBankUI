package com.example.natcashbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.natcashbank.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private MyAdapter userAdapter;
    private AdapterMenuINews adapterMenuINews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getMenu();
        getINews();
        getSlider();

        binding.txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getSlider() {
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.banner, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.banner, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.banner, ScaleTypes.FIT));

        binding.imgSlider.setImageList(slideModels, ScaleTypes.FIT);
    }

    private void getINews() {
        adapterMenuINews = new AdapterMenuINews(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.rcvMenuINews.setLayoutManager(linearLayoutManager);

        adapterMenuINews.setData(getListINews());
        binding.rcvMenuINews.setAdapter(adapterMenuINews);
    }

    private List<INews> getListINews() {
        List<INews> nList = new ArrayList<>();
        List<ItemINews> mList = new ArrayList<>();

        mList.add(new ItemINews(R.drawable.img_inew1, "Attractive promotion from Lumicash %10"));
        mList.add(new ItemINews(R.drawable.img_inew2, "Attractive promotion from Lumicash %50"));

        nList.add(new INews("Promotion", mList));
        nList.add(new INews("Hot deal", mList));
        nList.add(new INews("Big voucher", mList));
        nList.add(new INews("Promotion", mList));

        return nList;
    }

    private void getMenu() {
        userAdapter = new MyAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false);
        binding.recyclerview.setLayoutManager(gridLayoutManager);

        userAdapter.setData(getListUser());
        binding.recyclerview.setAdapter(userAdapter);
    }

    private List<ItemMenu> getListUser() {
        List<ItemMenu> list = new ArrayList<>();
        list.add(new ItemMenu(R.drawable.imgtfmoney, "Transfer Money"));
        list.add(new ItemMenu(R.drawable.img_tfbank, "Transfer Bank"));
        list.add(new ItemMenu(R.drawable.topup_menu, "Top Up"));
        list.add(new ItemMenu(R.drawable.img_data, "Data"));
        list.add(new ItemMenu(R.drawable.img, "Water"));
        list.add(new ItemMenu(R.drawable.img_1, "Electricity"));
        list.add(new ItemMenu(R.drawable.img_2, "Bill payment"));
        list.add(new ItemMenu(R.drawable.img_service, "Service payment"));
        return list;
    }
}