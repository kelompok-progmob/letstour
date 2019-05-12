package com.progmob.letstour.data;

import com.progmob.letstour.model.ModelCountry;

import java.util.ArrayList;

public class CountryData {

    public static String[][] collection = new String[][]{
            {
                    "1", //id
                    "Bali", //name
                    "https://images.pexels.com/photos/1694621/pexels-photo-1694621.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" //image
            },
            {
                    "2", //id
                    "Lombok", //name
                    "https://www.bali.com/media/image/663/best-resorts-bali.jpg" //image
            },
            {
                    "3", //id
                    "Papua", //name
                    "https://www.diveworldwide.com/images/galleries/asia_indonesia_dive_raja_ampat_gallery_papua_resort_thomas_haider.jpg" //image
            },
            {
                    "4", //id
                    "Yogyakarta", //name
                    "https://www.dbs.com/iwov-resources/images/newsroom/indonesia/Blog/tempat%20wisata%20indonesia/image%20artikel-%20wisata%20Indonesia-%20yogyakarta.jpg" //image
            },
            {
                    "5", //id
                    "Kalimantan", //name
                    "https://www.dbs.com/iwov-resources/images/newsroom/indonesia/Blog/tempat%20wisata%20indonesia/image%20artikel-%20wisata%20Indonesia-%20kalimantan.jpg" //image
            },
            {
                    "6", //id
                    "Sulawesi", //name
                    "https://www.dbs.com/iwov-resources/images/newsroom/indonesia/Blog/tempat%20wisata%20indonesia/image%20artikel-%20wisata%20Indonesia-wakatobi.jpg" //image
            }
    };

    public static ArrayList<ModelCountry> getListData(){
        ModelCountry model = null;
        ArrayList<ModelCountry> list = new ArrayList<>();

        for (String[] data : collection) {
            model = new ModelCountry();

            model.setId(data[0]);
            model.setName(data[1]);
            model.setImage(data[2]);

            list.add(model);
        }

        return list;
    }

}
