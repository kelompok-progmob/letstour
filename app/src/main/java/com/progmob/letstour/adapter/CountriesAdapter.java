package com.progmob.letstour.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.progmob.letstour.R;
import com.progmob.letstour.TourListActivity;
import com.progmob.letstour.model.ModelCountry;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Herlambang
 */

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.MyViewHolder>{

    private LayoutInflater inflater;
    private Context context;
    private ArrayList<ModelCountry> list;

    public ArrayList<ModelCountry> getList() {
        return list;
    }

    public void setList(ArrayList<ModelCountry> list) {
        this.list = list;
    }

    public CountriesAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = inflater.inflate(R.layout.item_countries, parent, false);
        return new MyViewHolder(rootView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.mNama.setText(getList().get(position).getName());

        Picasso.with(context)
                .load(getList().get(position).getImage())
                .placeholder(R.drawable.placeholder_vertical)
                .into(holder.mImage);

        holder.mCard.setTag(position);
        holder.mCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (int) view.getTag();
                ModelCountry data = getList().get(position);

                Intent intent = new Intent(context, TourListActivity.class); // gets the previously created intent
                intent.putExtra("tipe", "0");
                intent.putExtra("id", data.getId());
                intent.putExtra("name",data.getName());
                intent.putExtra("image", data.getImage());
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return getList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mNama;
        private ImageView mImage;
        private CardView mCard;

        public MyViewHolder(View itemView) {
            super(itemView);

            mNama = itemView.findViewById(R.id.item_countries_name);
            mImage = itemView.findViewById(R.id.item_countries_image);
            mCard = itemView.findViewById(R.id.item_countries_card);

        }
    }
}
