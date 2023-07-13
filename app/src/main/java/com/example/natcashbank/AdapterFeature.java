package com.example.natcashbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterFeature extends RecyclerView.Adapter<AdapterFeature.FeatureHolder>{

    private List<Feature> list;
    private Context context;

    public AdapterFeature(Context context) {
        this.context = context;
    }

    public void setData(List<Feature> list){
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public FeatureHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feature,parent,false);
        return new FeatureHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeatureHolder holder, int position) {
        Feature feature = list.get(position);
        if (feature == null){
            return;
        }
        holder.imgFeature.setImageResource(feature.getImgFeature());
        holder.txtFeature.setText(feature.getTxtFeature());
    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    public class FeatureHolder extends RecyclerView.ViewHolder{
        private ImageButton imgFeature;
        private TextView txtFeature;
        public FeatureHolder(@NonNull View itemView) {
            super(itemView);
            imgFeature = itemView.findViewById(R.id.btn_feature);
            txtFeature = itemView.findViewById(R.id.txt_feature);
        }
    }
}
