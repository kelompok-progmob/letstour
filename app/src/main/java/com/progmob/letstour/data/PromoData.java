package com.progmob.letstour.data;

import android.util.Log;

import com.progmob.letstour.model.ModelCountry;
import com.progmob.letstour.model.ModelPromo;

import java.util.ArrayList;

public class PromoData {

    public static String[][] collection = new String[][]{
            {
                    "Come at afternoon to Lombok Mount View to get 50% off !", //caption
                    "Hello fellas ! come at afternoon to Lombok Mount View to get 50% off !", //shareMessage
                    "http://www.ponty.dk/rinja01a.jpg" //image
            },
    };

    public static ArrayList<ModelPromo> getListData(){
        ModelPromo model = null;
        ArrayList<ModelPromo> list = new ArrayList<>();

        for (String[] data : collection) {
            model = new ModelPromo();

            Log.d("PromoData","add data !");

            model.setCaption(data[0]);
            model.setShareMessage(data[1]);
            model.setImage(data[2]);

            list.add(model);
        }

        return list;
    }

}
