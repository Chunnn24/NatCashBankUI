package com.example.natcashbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.natcashbank.databinding.ActivityLoginHomeBinding;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

public class LoginHomeActivity extends AppCompatActivity {
    private ActivityLoginHomeBinding binding;
    private MyAdapter userAdapter;
    private AdapterMenuINews adapterMenuINews;
    private AdapterFeature adapterFeature;

    private static final String MY_SHARE_PREFERENCE = "MY_SHARE_PREFERENCE";
    private static final String KEY_PHONE = "KEY_PHONE";
    private static final String KEY_NAME = "KEY_NAME";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getFeature();
        getSlider();
        getMenu();
        getINews();
        getData();

        binding.scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int scrollY = binding.scrollView.getScrollY();

                // Xác định vị trí để hiển thị view
                int desiredScrollPosition = 600; // Vị trí cuộn tới yêu cầu

                if (scrollY >= desiredScrollPosition) {
                    binding.LlViewGone.setVisibility(View.VISIBLE);
                } else {
                    binding.LlViewGone.setVisibility(View.GONE);
                }
            }
        });

    }

    private void getData() {
        sharedPreferences = getSharedPreferences(MY_SHARE_PREFERENCE,MODE_PRIVATE);

        String phone = sharedPreferences.getString(KEY_PHONE,null);
        if (phone != null){
            binding.txtNumberUser.setText(phone);
        }
        String name = sharedPreferences.getString(KEY_NAME,null);
        if (name != null){
            binding.txtUserName.setText(name);
        }

        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                finish();
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("MY_SHARE_PREFERENCE", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", true);
        editor.apply();

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
    private void getSlider() {
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.banner, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.banner, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.banner, ScaleTypes.FIT));

        binding.imgSlider.setImageList(slideModels, ScaleTypes.FIT);
    }
    private void getFeature() {
        adapterFeature = new AdapterFeature(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1,GridLayoutManager.HORIZONTAL,false);
        binding.RcFeature.setLayoutManager(gridLayoutManager);

        adapterFeature.setData(getListFeature());
        binding.RcFeature.setAdapter(adapterFeature);
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
    private List<Feature> getListFeature() {
        List<Feature> fList = new ArrayList<>();
        fList.add(new Feature(R.drawable.img_deposit,"Deposit"));
        fList.add(new Feature(R.drawable.img_withdraw,"With Draw"));
        fList.add(new Feature(R.drawable.img_banking,"Banking"));
        fList.add(new Feature(R.drawable.img_qr,"My QR"));
        return fList;
    }
}