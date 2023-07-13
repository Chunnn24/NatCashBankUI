package com.example.natcashbank;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterOnboard extends RecyclerView.Adapter<AdapterOnboard.OnboardHolder> {

    private List<OnBoardingItem> iList;
    private Context context;

    public AdapterOnboard(Context context) {
        this.context = context;
    }
    public void setData(List<OnBoardingItem> iList){
        this.iList = iList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OnboardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_container, parent, false);
        return new OnboardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnboardHolder holder, int position) {
        OnBoardingItem item = iList.get(position);
        if (item == null){
            return;
        }
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        holder.image.setImageResource(item.getImage());
    }

    @Override
    public int getItemCount() {
        Log.d("info", "getItemCount: " + iList.size());
        return iList.size();
    }

    public class OnboardHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView description;
        private ImageView image;

        public OnboardHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txt_titleOB);
            description = itemView.findViewById(R.id.txt_descriptionOB);
            image = itemView.findViewById(R.id.img_ob);
        }
    }
}
