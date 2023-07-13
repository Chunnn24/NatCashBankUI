package com.example.natcashbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterINews extends RecyclerView.Adapter<AdapterINews.INewsViewHolder> {

    private Context nContext;
    private List<ItemINews> mINew;

    public AdapterINews() {
    }

    public AdapterINews(Context nContext) {
        this.nContext = nContext;
    }
    public void setData(List<ItemINews> list){
        this.mINew = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public INewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inew,parent,false);
        return new INewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull INewsViewHolder holder, int position) {
        ItemINews itemINews = mINew.get(position);
        if (itemINews == null){
            return;
        }
        holder.imgINew.setImageResource(itemINews.getImgINew());
        holder.txtINew.setText(itemINews.getTxtINew());
    }

    @Override
    public int getItemCount() {
        if (mINew != null){
            return mINew.size();
        }
        return 0;
    }

    public class INewsViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgINew;
        private TextView txtINew ;
        public INewsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgINew = itemView.findViewById(R.id.img_iNew);
            txtINew = itemView.findViewById(R.id.txt_iNew);
        }
    }
}
