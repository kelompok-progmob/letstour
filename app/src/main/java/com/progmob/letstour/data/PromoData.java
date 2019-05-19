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
            {
                    "Come at sunday to Prambanan Temple to get 40% off !", //caption
                    "Hello fellas ! come at sunday to Prambanan Temple to get 40% off !", //shareMessage
                    "https://upload.wikimedia.org/wikipedia/commons/f/fc/Prambanan_Java245.jpg" //image
            },
            {
                    "Come at april to Wakatobi to get 30% off !", //caption
                    "Hello fellas ! come at april to Wakatobi to get 30% off !", //shareMessage
                    "https://i0.wp.com/discoveryourindonesia.com/wp-content/uploads/2013/06/Tomia-Island-Life.jpg?w=700&ssl=1" //image
            },
            {
                    "Come at December to Gili Kondo to get 20% off !", //caption
                    "Hello fellas ! come at December to Gili Kondo to get 20% off !", //shareMessage
                    "http://indonesia-tourism.com/blog/wp-content/uploads/2013/02/gili.jpg" //image
            },
            {
                    "Come at friday to Kecak Dance to get 10% off !", //caption
                    "Hello fellas ! come at friday to Kecak Dance to get 10% off !", //shareMessage
                    "http://www.whatsnewbali.com/wp-content/uploads/2018/04/uluwatu-kecak-dance.jpg" //image
            },
    };

    public static String[][] collectionIndo = new String[][]{
            {
                    "Datanglah sore hari ke Lombok Mount View untuk mendapat diskon 50%!", // caption
                    "Halo teman-teman! Datanglah sore hari ke Lombok Mount View untuk mendapat diskon 50%!", // shareMessage
                    "http://www.ponty.dk/rinja01a.jpg" // gambar
            },
            {
                    "Datanglah pada hari Minggu ke Candi Prambanan untuk mendapat diskon 40%!", // caption
                    "Halo teman-teman! Datanglah pada hari Minggu ke Candi Prambanan untuk mendapat diskon 40%!", // shareMessage
                    "https://upload.wikimedia.org/wikipedia/commons/f/fc/Prambanan_Java245.jpg" // image
            },
            {
                    "Datanglah pada bulan april ke Wakatobi untuk mendapat diskon 30%!", // caption
                    "Halo teman-teman! Datanglah pada bulan april ke Wakatobi untuk mendapat diskon 30%!", // shareMessage
                    "https://i0.wp.com/discoveryourindonesia.com/wp-content/uploads/2013/06/Tomia-Island-Life.jpg?w=700&ssl=1" // image
            },
            {
                    "Datanglah pada bulan Desember ke Gili Kondo untuk mendapat diskon 20%!", // caption
                    "Halo teman-teman! Datanglah pada bulan Desember ke Gili Kondo untuk mendapat diskon 20%!", // shareMessage
                    "http://indonesia-tourism.com/blog/wp-content/uploads/2013/02/gili.jpg" // image
            },
            {
                    "Datanglah pada hari Jumat ke Tari Kecak untuk mendapat diskon 10%!", // caption
                    "Halo teman! Datanglah pada hari Jumat ke Tari Kecak untuk mendapat diskon 10%!", // shareMessage
                    "http://www.whatsnewbali.com/wp-content/uploads/2018/04/uluwatu-kecak-dance.jpg" // image
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
