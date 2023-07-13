package com.example.natcashbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.UserHolderView> {

    private Context mContext;
    private List<ItemMenu> mList;

    public MyAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<ItemMenu> list){
        this.mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu,parent,false);
        return new UserHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolderView holder, int position) {
        ItemMenu user = mList.get(position);
        if(user==null){
            return;
        }
        holder.imgUser.setImageResource(user.getResourceId());
        holder.txName.setText(user.getText());
        if(position == 1){
            holder.imgUser.setBackgroundResource(R.drawable.transferbank_menu);
        } else if (position == 2) {
            holder.imgUser.setBackgroundResource(R.drawable.topup_menu);
        }else if (position == 3) {
            holder.imgUser.setBackgroundResource(R.drawable.data_menu);
        }else if (position == 4) {
            holder.imgUser.setBackgroundResource(R.drawable.water_menu);
        }else if (position == 5) {
            holder.imgUser.setBackgroundResource(R.drawable.electricity_menu);
        }else if (position == 6) {
            holder.imgUser.setBackgroundResource(R.drawable.billpayment_menu);
        }else if (position == 7) {
            holder.imgUser.setBackgroundResource(R.drawable.serviec_menu);
        }
    }

    @Override
    public int getItemCount() {
        if(mList != null){
            return mList.size();
        }
        return 0;
    }

    public class UserHolderView extends RecyclerView.ViewHolder{
        private ImageButton imgUser;
        private TextView txName;

        public UserHolderView(@NonNull View itemView) {
            super(itemView);
            imgUser = itemView.findViewById(R.id.btn_menu);
            txName = itemView.findViewById(R.id.txt_menu);
        }
    }

}
