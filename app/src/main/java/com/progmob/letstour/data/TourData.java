package com.progmob.letstour.data;

import com.progmob.letstour.model.ModelTour;

import java.util.ArrayList;

public class TourData {

    public static String[][] collection = new String[][]{
//            {
//                    "1", //id_country
//                    "1", // id_category
//                    "1", //is_popular
//                    "Terasering View", //name
//                    "https://www.pegipegi.com/travel/wp-content/uploads/2017/07/foto-wisata-sawah-teras-sering-jatiluwih-tabanan-161203m-001.jpg", //image
//                    "Tabanan, Bali", //location
//                    "A Beautiful Rice Field View", //subtitle
//                    "This is the descriptin of this tour, to my team, please note that this must be change according to the title of each view", //description
//                    "USD 23,5", // price
//                    "Overview", // overview
//                    "Activities", // activities
//                    "Preparation", // preparation
//            },
            {
                    "1", //id_country
                    "1", // id_category
                    "1", //is_popular
                    "Terasering View", //name
                    "https://www.pegipegi.com/travel/wp-content/uploads/2017/07/foto-wisata-sawah-teras-sering-jatiluwih-tabanan-161203m-001.jpg", //image
                    "Tabanan, Bali", //location
                    "A Beautiful Rice Field View", //subtitle
                    "This is the descriptin of this tour, to my team, please note that this must be change according to the title of each view", //description
                    "USD 23,5", // price
                    "Overview", // overview
                    "Activities", // activities
                    "Preparation", // preparation
            },
            {
                    "1", //id_country
                    "1", // id_category,
                    "1", //is_popular
                    "Sea View", //name
                    "https://d22ir9aoo7cbf6.cloudfront.net/wp-content/uploads/sites/4/2018/10/blue-lagoon-beach-Bali.jpg", //image
                    "Sanur, Bali", //location
                    "A Beautiful Sea View", //subtitle
                    "This is the descriptin of this tour, to my team, please note that this must be change according to the title of each view", //description
                    "USD 23,5", // price
                    "Overview", // overview
                    "Activities", // activities
                    "Preparation", // preparation
            },
            {
                    "1", //id_country
                    "1", // id_category
                    "1", //is_popular
                    "Kuta Beach", //name
                    "https://www.bali.com/media/image/285/bali-kuta-beach-sunset-atmosphere.jpg", //image
                    "Kuta, Bali", //location
                    "A Beautiful Kuta Beach", //subtitle
                    "This is the descriptin of this tour, to my team, please note that this must be change according to the title of each view", //description
                    "USD 23,5", // price
                    "Overview", // overview
                    "Activities", // activities
                    "Preparation", // preparation
            },
            {
                    "1", //id_country
                    "1", // id_category
                    "0", //is_popular
                    "Kuta Beach", //name
                    "https://www.bali.com/media/image/285/bali-kuta-beach-sunset-atmosphere.jpg", //image
                    "Kuta, Bali", //location
                    "A Beautiful Kuta Beach", //subtitle
                    "This is the descriptin of this tour, to my team, please note that this must be change according to the title of each view", //description
                    "USD 23,5", // price
                    "Overview", // overview
                    "Activities", // activities
                    "Preparation", // preparation
            }
    };

    public static ArrayList<ModelTour> getListData(int is_popular){
        ModelTour model = null;
        ArrayList<ModelTour> list = new ArrayList<>();

        for (String[] data : collection) {
            model = new ModelTour();

            model.setId_country(data[0]);
            model.setId_category(Integer.valueOf(data[1]));
            model.setIs_popular(Integer.valueOf(data[2]));
            model.setName(data[3]);
            model.setImage(data[4]);
            model.setLocation(data[5]);
            model.setSubtitle(data[6]);
            model.setDescription(data[7]);

            if(is_popular == Integer.valueOf(data[2])){
                list.add(model);
            }

        }

        return list;
    }

}
