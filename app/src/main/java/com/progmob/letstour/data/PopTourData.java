package com.progmob.letstour.data;

import com.progmob.letstour.model.ModelCountry;
import com.progmob.letstour.model.ModelPopTour;

import java.util.ArrayList;

public class PopTourData {

    public static String[][] collection = new String[][]{
            {
                    "1", //id
                    "1", //id_country
                    "Terasering View", //name
                    "https://www.pegipegi.com/travel/wp-content/uploads/2017/07/foto-wisata-sawah-teras-sering-jatiluwih-tabanan-161203m-001.jpg", //imag,e
                    "Tabanan, Bali", //location
                    "1", //is_popular
                    "A Beautiful Rice Field View",
                    "This is the descriptin of this tour, to my team, please note that this must be change according to the title of each view"
            },
            {
                    "2", //id
                    "1", //id_country
                    "Sea View", //name
                    "https://d22ir9aoo7cbf6.cloudfront.net/wp-content/uploads/sites/4/2018/10/blue-lagoon-beach-Bali.jpg", //image
                    "Sanur, Bali", //location
                    "1", //is_popular
                    "A Beautiful Sea View",
                    "This is the descriptin of this tour, to my team, please note that this must be change according to the title of each view"
            },
            {
                    "2", //id
                    "1", //id_counãtry
                    "Kuta Beach", //name
                    "https://www.bali.com/media/image/285/bali-kuta-beach-sunset-atmosphere.jpg", //image
                    "Kuta, Bali", //location
                    "1", //is_popular
                    "A Beautiful Kuta Beach",
                    "This is the descriptin of this tour, to my team, please note that this must be change according to the title of each view"
            }
    };

    public static ArrayList<ModelPopTour> getListData(){
        ModelPopTour model = null;
        ArrayList<ModelPopTour> list = new ArrayList<>();

        for (String[] data : collection) {
            model = new ModelPopTour();

            model.setId(data[0]);
            model.setId_country(data[1]);
            model.setName(data[2]);
            model.setImage(data[3]);
            model.setLocation(data[4]);

            list.add(model);
        }

        return list;
    }

}
