package com.example.ajay.paytmintegration;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.ajay.paytmintegration.Interface.ItemClickListener;
import com.example.ajay.paytmintegration.Interface.OnViewClickListener;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    private Context context;
    private ArrayList<Player> players;
    public ArrayList<Player> checkedPlayers = new ArrayList<>();

    private OnViewClickListener listener;

    public void setViewListener(OnViewClickListener listener){
        this.listener = listener;
    }

    public MyAdapter(Context context, ArrayList<Player> players) {
        this.context = context;
        this.players = players;
//        listener = (OnViewClickListener) context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler,parent,false);
        MyHolder holder = new MyHolder(view,listener);

        return holder;
    }

    //data is bound to views
    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {

        holder.textViewName.setText(players.get(position).getName());
        holder.textViewPosition.setText(players.get(position).getPosition());
        holder.imageView.setImageResource(players.get(position).getImageSrc());
        holder.checkBox.setChecked(players.get(position).isChecked());
        if (players.get(position).isChecked()) {
            holder.itemView.setBackgroundColor(Color.GRAY);
        } else {
            holder.itemView.setBackgroundColor(Color.WHITE);
        }

      /*  holder.setViewListener(new OnViewClickListener() {
            @Override
            public void onViewClick(View view, int positon) {
                Toast.makeText(context, "clicked on position "+position, Toast.LENGTH_SHORT).show();
            }
        });*/

       /* holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                CheckBox checkBox = (CheckBox) view;
                if (checkBox.isChecked()) {
                    checkedPlayers.add(players.get(position));
//                    holder.checkBox.setChecked(true);
                    players.get(position).setChecked(true);
                } else {
                    checkedPlayers.remove(players.get(position));
                    players.get(position).setChecked(false);
//                    holder.checkBox.setChecked(false);
                }

            }
        });*/

    }

    @Override
    public int getItemCount() {
        return players.size();
    }
}
