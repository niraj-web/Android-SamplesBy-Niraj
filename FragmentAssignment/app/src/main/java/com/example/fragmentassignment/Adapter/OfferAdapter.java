
package com.example.fragmentassignment.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.fragmentassignment.MainActivity;
import com.example.fragmentassignment.Model.OffersModel;
import com.example.fragmentassignment.R;
import com.example.fragmentassignment.SecondFragment;
import com.example.fragmentassignment.utils.CommonInterface;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.RecyclerViewHolder> {
    Context mcontext;
    private List<OffersModel.Data> imageList;
    CommonInterface commonInterface;
    private Activity getActivity;


    public OfferAdapter(Context mcontext, List<OffersModel.Data> imageList, Activity getActivity)
    {
        this.mcontext = mcontext;
        this.imageList = imageList;
        this.getActivity = getActivity;
        this.commonInterface = commonInterface;
    }

    @NonNull
    @Override
    public com.example.fragmentassignment.Adapter.OfferAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offers_list, parent,false);
        return new com.example.fragmentassignment.Adapter.OfferAdapter.RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.fragmentassignment.Adapter.OfferAdapter.RecyclerViewHolder holder, int position) {
        holder.offerName.setText(imageList.get(position).getCategoryTitle());
        Glide.with(mcontext)
                .load(imageList.get(position).getImageUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.offersImage);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView offersImage;
        TextView offerName;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            offersImage = itemView.findViewById(R.id.offersImage);
            offerName = itemView.findViewById(R.id.offerName);

           offersImage.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   MainActivity.replaceFragment(getActivity,new SecondFragment(),true);
               }
           });
        }
    }
}