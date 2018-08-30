package com.example.ajay.paytmintegration;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ajay.paytmintegration.Interface.ItemClickListener;
import com.example.ajay.paytmintegration.Interface.OnViewClickListener;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView imageView;
    TextView textViewName,textViewPosition;
    public CheckBox checkBox;

    ItemClickListener clickListener;
    OnViewClickListener viewClickListener;
    View itemView;

    public MyHolder(View itemView, OnViewClickListener viewClickListener) {
        super(itemView);

        this.viewClickListener = viewClickListener;
        this.itemView = itemView;
        imageView = itemView.findViewById(R.id.iv_playerimage);
        textViewName = itemView.findViewById(R.id.textview_name);

        textViewPosition = itemView.findViewById(R.id.textview_position);
        checkBox = itemView.findViewById(R.id.cb_checkbox);

       // checkBox.setOnClickListener(this);
        itemView.setOnClickListener(this);


    }

   /* public void setViewListener(OnViewClickListener viewClickListener ){
        this.viewClickListener  = viewClickListener;
    }
*/
    public  void setItemClickListener( ItemClickListener clickListener){
         this.clickListener = clickListener;
    }

    @Override
    public void onClick(View v) {
       /* if(v ==  checkBox ){
          clickListener.onItemClick(v,getAdapterPosition());
        }else if(v == itemView){
            viewClickListener.onViewClick(v,getAdapterPosition());
         }*/

        if(v == itemView){
            viewClickListener.onViewClick(v,getAdapterPosition());
        }

    }
}
