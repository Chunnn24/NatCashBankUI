package com.example.natcashbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterMenuINews extends RecyclerView.Adapter<AdapterMenuINews.MenuINewsHolder> {

    private Context nContext;
    private List<INews> mListINews;

    public void setData(List<INews> list){
        this.mListINews = list;
        notifyDataSetChanged();
    }

    public AdapterMenuINews(Context nContext) {
        this.nContext = nContext;
    }

    @NonNull
    @Override
    public MenuINewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_menu_inews,parent,false);
        return new MenuINewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuINewsHolder holder, int position) {
        INews iNews = mListINews.get(position);
        if(iNews == null){
            return;
        }
        holder.txtNameINews.setText(iNews.getPromotion());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(nContext,LinearLayoutManager.HORIZONTAL,false);
        holder.rcvINews.setLayoutManager(linearLayoutManager);

        AdapterINews adapterINews = new AdapterINews();
        adapterINews.setData(iNews.getiNewsList());

        holder.rcvINews.setAdapter(adapterINews);
    }

    @Override
    public int getItemCount() {
        if (mListINews != null){
            return mListINews.size();
        }
        return 0;
    }

    public class MenuINewsHolder extends RecyclerView.ViewHolder{
        private TextView txtNameINews;
        private RecyclerView rcvINews;

        public MenuINewsHolder(@NonNull View itemView) {
            super(itemView);
            txtNameINews = itemView.findViewById(R.id.txt_promotion);
            rcvINews = itemView.findViewById(R.id.rcv_INews);
        }
    }
}
