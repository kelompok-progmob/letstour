package com.progmob.letstour.data;

import com.progmob.letstour.model.ModelCountry;

import java.util.ArrayList;

public class CountryData {

    public static String[][] collection = new String[][]{
            {
                    "1", //id
                    "Bali", //name
                    "http://en.presidentpost.id/wp-content/uploads/2018/01/Bali.jpeg" //image
            },
            {
                    "2", //id
                    "Lombok", //name
                    "https://i0.wp.com/firstlomboktour.com/wp-content/uploads/2018/03/Kesukaan-pemandu-wisata-Gili-Kedis-Lombok-sumber-ig-travelspotindonesia.jpg?fit=750%2C836&ssl=1" //image
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
                    "https://indonesiatraveling.com/wp-content/uploads/2019/01/ora-beach-resort-01.jpg" //image
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
