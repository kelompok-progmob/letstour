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
import com.progmob.letstour.TourDetailActivity;
import com.progmob.letstour.TourListActivity;
import com.progmob.letstour.model.ModelTour;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Herlambang
 */

public class ActTourAdapter extends RecyclerView.Adapter<ActTourAdapter.MyViewHolder>{

    private LayoutInflater inflater;
    private Context context;
    private ArrayList<ModelTour> list;

    public ArrayList<ModelTour> getList() {
        return list;
    }

    public void setList(ArrayList<ModelTour> list) {
        this.list = list;
    }

    public ActTourAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = inflater.inflate(R.layout.item_act_tour, parent, false);
        return new MyViewHolder(rootView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.mNama.setText(getList().get(position).getName());
        holder.mLocation.setText(getList().get(position).getLocation());
        holder.mSubtitle.setText(getList().get(position).getSubtitle());

        Picasso.with(context)
                .load(getList().get(position).getImage())
                .placeholder(R.drawable.placeholder_vertical)
                .into(holder.mImage);

        holder.mCard.setTag(position);
        holder.mCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (int) view.getTag();
                ModelTour data = getList().get(position);

                Intent intent = new Intent(context, TourDetailActivity.class); // gets the previously created intent
                intent.putExtra("name",data.getName());
                intent.putExtra("image", data.getImage());
                intent.putExtra("location", data.getLocation());
                intent.putExtra("subtitle", data.getSubtitle());
                intent.putExtra("price", data.getPrice());
                intent.putExtra("overview", data.getOverview());
                intent.putExtra("description", data.getDescription());
                intent.putExtra("preparation", data.getPreparation());
                intent.putExtra("youtube", data.getYoutube());
                intent.putExtra("maps", data.getMaps());
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return getList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mNama,mLocation,mSubtitle;
        private ImageView mImage;
        private CardView mCard;

        public MyViewHolder(View itemView) {
            super(itemView);

            mNama = itemView.findViewById(R.id.item_tour_nama);
            mImage = itemView.findViewById(R.id.item_tour_image);
            mLocation = itemView.findViewById(R.id.item_tour_lokasi);
            mSubtitle = itemView.findViewById(R.id.item_tour_subtitle);
            mCard = itemView.findViewById(R.id.item_tour_card);

        }
    }
}
