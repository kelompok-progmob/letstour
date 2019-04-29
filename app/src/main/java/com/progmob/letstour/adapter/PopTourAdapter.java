package com.progmob.letstour.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.progmob.letstour.R;
import com.progmob.letstour.TourListActivity;
import com.progmob.letstour.model.ModelCountry;
import com.progmob.letstour.model.ModelPopTour;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Herlambang
 */

public class PopTourAdapter extends RecyclerView.Adapter<PopTourAdapter.MyViewHolder>{

    private LayoutInflater inflater;
    private Context context;
    private ArrayList<ModelPopTour> list;

    public ArrayList<ModelPopTour> getList() {
        return list;
    }

    public void setList(ArrayList<ModelPopTour> list) {
        this.list = list;
    }

    public PopTourAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = inflater.inflate(R.layout.item_pop_tour, parent, false);
        return new MyViewHolder(rootView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.mNama.setText(getList().get(position).getName());
        holder.mLocation.setText(getList().get(position).getLocation());

        Picasso.with(context)
                .load(getList().get(position).getImage())
                .placeholder(R.drawable.placeholder_vertical)
                .into(holder.mImage);

        holder.mCard.setTag(position);
        holder.mCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (int) view.getTag();
                ModelPopTour data = getList().get(position);

                Intent intent = new Intent(context, TourListActivity.class); // gets the previously created intent
                intent.putExtra("tipe", "1");
                intent.putExtra("id", data.getId());
                intent.putExtra("name",data.getName());
                intent.putExtra("image", data.getImage());
                intent.putExtra("location", data.getLocation());
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return getList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mNama,mLocation;
        private ImageView mImage;
        private CardView mCard;

        public MyViewHolder(View itemView) {
            super(itemView);

            mNama = itemView.findViewById(R.id.item_pop_name);
            mImage = itemView.findViewById(R.id.item_pop_image);
            mLocation = itemView.findViewById(R.id.item_pop_location);
            mCard = itemView.findViewById(R.id.item_pop_card);

        }
    }
}
