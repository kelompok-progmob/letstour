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
import com.progmob.letstour.model.ModelPromo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by Herlambang
 */

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.MyViewHolder>{

    private LayoutInflater inflater;
    private Context context;
    private ArrayList<ModelPromo> list;

    public ArrayList<ModelPromo> getList() {
        return list;
    }

    public void setList(ArrayList<ModelPromo> list) {
        this.list = list;
    }

    public PromoAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = inflater.inflate(R.layout.item_promo, parent, false);
        return new MyViewHolder(rootView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.mText.setText(getList().get(position).getCaption());

        Picasso.with(context)
                .load(getList().get(position).getImage())
                .placeholder(R.drawable.placeholder_vertical)
                .into(holder.mImage);

        holder.mBtn.setTag(position);
        holder.mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int) v.getTag();
                ModelPromo data = getList().get(position);

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, data.getCaption());
                sendIntent.setType("text/plain");
                context.startActivity(Intent.createChooser(sendIntent, "Share"));
            }
        });

    }

    @Override
    public int getItemCount() {
        return getList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mText;
        private ImageView mImage;
        private FancyButton mBtn;

        public MyViewHolder(View itemView) {
            super(itemView);

            mText = itemView.findViewById(R.id.item_promo_text);
            mImage = itemView.findViewById(R.id.item_promo_image);
            mBtn = itemView.findViewById(R.id.item_promo_btnshare);

        }
    }
}
