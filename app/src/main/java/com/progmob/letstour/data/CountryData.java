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
                    "https://asset.kompas.com/crop/0x0:780x390/780x390/data/photo/2015/06/21/2043250tiu-kelepp780x390.jpg" //image
            },
            {
                    "3", //id
                    "Papua", //name
                    "https://www.swaindestinations.com/south-pacific-islands/images/itineraries/new-guinea-paradise/TPA-056-Waterfall-near-Mt-Hagen.jpg" //image
            },
            {
                    "4", //id
                    "Yogyakarta", //name
                    "https://s27957.pcdn.co/wp-content/uploads/2018/07/things-to-do-in-yogyakarta-borobudur.jpg" //image
            },
            {
                    "5", //id
                    "Kalimantan", //name
                    "https://storage.googleapis.com/tempatwisataunik/2017/01/Danau-Labuan-Cermin.jpg" //image
            },
            {
                    "6", //id
                    "Sulawesi", //name
                    "https://blog.reservasi.com/wp-content/uploads/2018/07/shutterstock_1064654387-1.jpg" //image
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
