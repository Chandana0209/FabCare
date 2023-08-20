package com.example.foodex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {

    private ArrayList<ItemList> item;


    ItemClicked activity;


    public interface ItemClicked
    {
        void onItemClicked(int index);
    }
    public ItemListAdapter(Context context, ArrayList<ItemList>list)
    {
        item=list;
        activity=(ItemClicked)context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivMake;
        TextView tvItem,tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMake=itemView.findViewById(R.id.ivMake);
            tvItem=itemView.findViewById(R.id.tvItem);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    activity.onItemClicked(item.indexOf((ItemList) v.getTag()));


                }
            });


        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(item.get(position));
        holder.tvPrice.setText(item.get(position).getItemPrice());
        holder.tvItem.setText(item.get(position).getItemName());

        if(item.get(position).getMake().equals("dress"))
        {
            holder.ivMake.setImageResource(R.drawable.dress);
        }

        else if(item.get(position).getMake().equals("formal"))
        {
            holder.ivMake.setImageResource(R.drawable.formal);
        }

        else if(item.get(position).getMake().equals("hoodie"))
        {
            holder.ivMake.setImageResource(R.drawable.hoodie);
        }

        else if(item.get(position).getMake().equals("jeans"))
        {
            holder.ivMake.setImageResource(R.drawable.jeans);
        }

        else if(item.get(position).getMake().equals("jumpsuit"))
        {
            holder.ivMake.setImageResource(R.drawable.jumpsuit);
        }

        else if(item.get(position).getMake().equals("skirt"))
        {
            holder.ivMake.setImageResource(R.drawable.skirt);
        }

        else if(item.get(position).getMake().equals("westernwear"))
        {
            holder.ivMake.setImageResource(R.drawable.westernwear);
        }

        else if(item.get(position).getMake().equals("sportwear"))
        {
            holder.ivMake.setImageResource(R.drawable.sportwear);
        }

        else if(item.get(position).getMake().equals("tshirt"))
        {
            holder.ivMake.setImageResource(R.drawable.tshirt);
        }
        else
        {
            holder.ivMake.setImageResource(R.drawable.traditional);
        }

    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}
