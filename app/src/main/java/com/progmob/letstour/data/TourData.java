package com.progmob.letstour.data;

import com.progmob.letstour.model.ModelTour;

import java.util.ArrayList;

public class TourData {

    public static String[][] collection = new String[][]{

            {
                    "1", //id_country
                    "6", // id_category
                    "1", //is_popular
                    "Medical Recreation", //name
                    "https://cdn.rentalmobilbali.net/wp-content/uploads/2011/12/permandian-pura-tirta-empul.jpg", //image
                    "Tampak Siring, Bali", //location
                    "A Holy Mountain Spring", //subtitle
                    "The site serves as a legendary setting of a traditional tale about good versus evil. It is also a national cultural heritage site.", //description
                    "USD 23,5", // price
                    "Tirta Empul, meaning ‘holy water spring’ is actually the name of a water source located within the temple. The spring feeds various purification baths, pools and fish ponds surrounding the outer perimeter, which all flow to the Tukad Pakerisan River. Various sites throughout the region and many other archaeological relics relate to local myths and legends.", // overview
                    "Besides information regarding Jatiluwih rice terrace entrance fee. You also will get related information on Jatiluwih rice field, such as:", // preparation
            },
            {
                    "1", //id_country
                    "3", // id_category
                    "1", //is_popular
                    "Terasering View", //name
                    "https://www.pegipegi.com/travel/wp-content/uploads/2017/07/foto-wisata-sawah-teras-sering-jatiluwih-tabanan-161203m-001.jpg", //image
                    "Tabanan, Bali", //location
                    "A Beautiful Rice Field View", //subtitle
                    "This site is one of the island’s must-see natural panoramas on par with Mount Batur and the caldera of Kintamani", //description
                    "USD 23,5", // price
                    "Nominated for designation as a UNESCO World Heritage site, Jatiluwih offers a beautiful view of contoured rice terraces irrigated using an impressive communal water system developed by Balinese farmers. The scenic drive through the quaint villages and verdant slopes of the central coastal regency of Tabanan adds to the experience.", // overview
                    "Besides information regarding Jatiluwih rice terrace entrance fee. You also will get related information on Jatiluwih rice field, such as:", // preparation
            },
            {
                    "1", //id_country
                    "4", // id_category,
                    "1", //is_popular
                    "Sea View", //name
                    "https://d22ir9aoo7cbf6.cloudfront.net/wp-content/uploads/sites/4/2018/10/blue-lagoon-beach-Bali.jpg", //image
                    "Sanur, Bali", //location
                    "A Beautiful Sea View", //subtitle
                    "Sanur Beach, Bali's earliest beach resort, features a relaxed coastal ambiance. Located on the eastern side of the island's isthmus", //description
                    "USD 23,5", // price
                    "Among Bali’s first hotels and beachfront retreats, together with an eclectic mix of restaurants, shops and bars and an assortment of innovative and modern entertainment venues share the Sanur Beach coastline. Known for its laidback atmosphere, Sanur Beach maintains its wealth in arts and culture, making it an ideal destination to enjoy the best of both eras, classic and contemporary.", // overview
                    "Besides information regarding Jatiluwih rice terrace entrance fee. You also will get related information on Jatiluwih rice field, such as:", // preparation
            },
            {
                    "1", //id_country
                    "1", // id_category
                    "1", //is_popular
                    "Kuta Beach", //name
                    "https://www.bali.com/media/image/285/bali-kuta-beach-sunset-atmosphere.jpg", //image
                    "Kuta, Bali", //location
                    "A Beautiful Kuta Beach", //subtitle
                    "Kuta Beach is on the western side of the island's narrow isthmus. It's considered Bali's most famous beach resort destination.", //description
                    "USD 23,5", // price
                    "Once a simple, rustic and quiet fishing village, Kuta Beach has witnessed a transformation over the past years. This is due to the rise of various accommodation options, dining and shopping scenes. The rapid growth owes much to visitors, beachcombers and art lovers from nearby Australia. Expatriates also helped pioneer surfing in Kuta, as well.", // overview
                    "Besides information regarding Jatiluwih rice terrace entrance fee. You also will get related information on Jatiluwih rice field, such as:", // preparation
            },
            {
                    "1", //id_country
                    "2", // id_category
                    "0", //is_popular
                    "Kecak Dance", //name
                    "http://www.whatsnewbali.com/wp-content/uploads/2018/04/uluwatu-kecak-dance.jpg", //image
                    "Uluwatu, Bali", //location
                    "Sakral Dance", //subtitle
                    "The Kecak Fire Dance is one of Bali’s most iconic art performances, famous for its dominant use of human vocals in place of gamelan instruments to accompany the dance-drama at its core.", //description
                    "USD 23,5", // price
                    "Kecak Fire Dance show is included as part of the package if you booked a common tour to the temple, and which perfectly serves as a closing highlight to your day out in Bali’s south peninsula area. However, you can go just for the show and purchase tickets at the amphitheatre’s ticket booth up front. Tickets for walk-ins range between IDR 70,000 and 100,000 depending on low and peak season, and includes pamphlets containing the synopsis of the drama.", // overview
                    "Besides information regarding Jatiluwih rice terrace entrance fee. You also will get related information on Jatiluwih rice field, such as:", // preparation
            },
            {
                    "2", //id_country
                    "1", // id_category
                    "1", //is_popular
                    "Park Tour", //name
                    "http://www.indonesia-tourism.com/west-nusa-tenggara/images/Taman-Mayura.jpg", //image
                    "Mataram, Lombok", //location
                    "A Beautiful Mataram Park", //subtitle
                    "This park was built in 1744 by Lombok's King. The center piece of the garden is a delightful pool, in the middle of which is a Bale Kambang.", //description
                    "USD 23,5", // price
                    "Curiously, its architecture shows both Hindu as well as Islamic influences, whereas around the place statues made of stone are found in a Moslem hajji form.", // overview
                    "Besides information regarding Mayura Park rice terrace entrance fee. You also will get related information on Mayura Park rice field, such as:", // preparation
            },
            {
                    "2", //id_country
                    "3", // id_category
                    "1", //is_popular
                    "Gili Kondo", //name
                    "http://indonesia-tourism.com/blog/wp-content/uploads/2013/02/gili.jpg", //image
                    "Sambelia, East Lombok", //location
                    "A Beautiful Lombok Island", //subtitle
                    "Gili Bagek / Gili Kondo is a small island that located in the Water of Sambelia District and it can be reached via Transat beach in Sambelia District (about 25 minutes).", //description
                    "USD 23,5", // price
                    "At this 20 ha island, which also part of 33 gili or islands in East Lombok, at several times in a week there will be tourists from the travel agent that manage this island. Those visitors are like doing swimming or snorkeling, camping or bbq-ing. Since 1992, The Perama Tour & Travel has been trusted by the government of East Lombok to manage and to conserve Gili Kondo and also Gili Bidara.", // overview
                    "Besides information regarding Gili Kondo rice terrace entrance fee. You also will get related information on Gili Kondo rice field, such as:", // preparation
            },
            {
                    "2", //id_country
                    "7", // id_category
                    "1", //is_popular
                    "Mount View", //name
                    "http://www.ponty.dk/rinja01a.jpg", //image
                    "Mataram, Lombok", //location
                    "A Beautiful Lombok Mount", //subtitle
                    "Mount Rinjani (Gunung Rinjani), which is the third highest mountain of Indonesia (3,726 m), is located in this national park, giving this park its name.", //description
                    "USD 23,5", // price
                    "Rinjani has best panaroma among the mountains in Indonesia. Each year (June-August), it has been visited by many tourists from local or abroad. The temperatures average about 20 ° C; lowest 12 ° C, and there will be strong winds which are common at the peak in August.", // overview
                    "Besides information regarding Mount Rinjani rice terrace entrance fee. You also will get related information on Mount Rinjani rice field, such as:", // preparation
            },
            {
                    "3", //id_country
                    "3", // id_category
                    "1", //is_popular
                    "Raja Ampat", //name
                    "http://rajaampat.indonesia-tourism.com/images/rajaampat.jpg", //image
                    "Sorong, West Papua", //location
                    "A Beautiful Papua Island", //subtitle
                    "The east part of Indonesia offers lots of hidden beautiful places on which lush nature and majestic islands reside. Raja Ampat District is not an exception", //description
                    "USD 23,5", // price
                    "The fact is that Raja Ampat was the part of Sorong District in the past. It became a new district since 2003 and offers a distinct tourist charm to everyone. According to the locals, there are about 30,000 people living in that region with their unique culture and local foods.", // overview
                    "Besides information regarding Raja Ampat rice terrace entrance fee. You also will get related information on Raja Ampat rice field, such as:", // preparation
            },
            {
                    "3", //id_country
                    "4", // id_category
                    "1", //is_popular
                    "Cendrawasih Cape", //name
                    "https://www.indonesia-tourism.com/west-papua/images/cendrawasih_cape.jpg", //image
                    "Manokwari, West Papua", //location
                    "A Beautiful Papua Island", //subtitle
                    "Cendrawasih Cape is the pride of West Papua Province. part from beaches and flora, the site consists of mostly water. It becomes the home of hundreds of species of fishes and mollusks.", //description
                    "USD 23,5", // price
                    "As mentioned earlier, Cendrawasih Cape consists of many features. However, most part of the area is the sea. No wonder, tourists can enjoy numerous water sports and explore some beautiful beaches in the location. The sea water is crystal clear with its green Tosca color. Not to mention the waves are calm, so visitors can swim in it safely.", // overview
                    "Besides information regarding Cendrawasih Cape rice terrace entrance fee. You also will get related information on Cendrawasih Cape rice field, such as:", // preparation
            },
            {
                    "3", //id_country
                    "3", // id_category
                    "1", //is_popular
                    "Lake View", //name
                    "https://www.indonesia-tourism.com/west-papua/images/kabori_lake.jpg", //image
                    "Manokwari, West Papua", //location
                    "A Beautiful Papua Lake", //subtitle
                    "Kabori Lake has a similar feature to regular lakes. Not to mention the water is calm, so fishers won’t be hard to spot fishes there.", //description
                    "USD 23,5", // price
                    "The nuance is peaceful and cold, especially in the morning. It is true the lake is quite deep with its green water. That means it is not suitable for inexperienced swimmers. In order to avoid problems, tourists should choose other fun activities like fishing. It is safer and more rewarding. Several big fishes even live in that lake.", // overview
                    "Besides information regarding Kabori Lake rice terrace entrance fee. You also will get related information on Kabori Lake rice field, such as:", // preparation
            },
            {
                    "4", //id_country
                    "2", // id_category
                    "1", //is_popular
                    "Keraton Visit", //name
                    "https://www.indonesia-tourism.com/yogyakarta/images/keraton_yogyakarta.jpg", //image
                    "Winongo, Yogyakarta", //location
                    "A Beautiful Palace", //subtitle
                    "Keraton Yogyakarta is a palace complex in the city of Yogyakarta, Yogyakarta Special Region, Indonesia. It is the seat of the reigning Sultan of Yogyakarta and his family.", //description
                    "USD 23,5", // price
                    "The visitors can enjoy the atmosphere of the kraton in former times by visiting the life-size diorama of wedding ceremonies on the palace meeting hall, performed by puppets, which are intentionally arranged to create such an atmosphere. Sets of Javanese musical instruments, antiques and heirlooms have made the palace of Yogyakarta worth to visit.", // overview
                    "Besides information regarding Kabori Lake rice terrace entrance fee. You also will get related information on Kabori Lake rice field, such as:", // preparation
            },
            {
                    "4", //id_country
                    "6", // id_category
                    "1", //is_popular
                    "Beach View", //name
                    "https://www.indonesia-tourism.com/yogyakarta/images/parangtritis-1.jpg", //image
                    "Kretek, Yogyakarta", //location
                    "A Beautiful Beach", //subtitle
                    "Parangtritis is an enchanting sloping beach combined with rocky hills, dunes, and a white sandy beach. Besides being famous as a recreational spot.", //description
                    "USD 23,5", // price
                    "Many people come to the beach to do meditation. Up to now, this area is remaining functioned as the place to perform the traditional ceremony called labuhan. Many hotels and restaurants are available for sunbathe lovers. It is said that the name of Parangtritis is expresses a natural phenomenon. From the wall of one of the hills drops off water containing calcium continuously dripped down and finally formed a pool with very clear water in it.", // overview
                    "Besides information regarding Kabori Lake rice terrace entrance fee. You also will get related information on Kabori Lake rice field, such as:", // preparation
            },
            {
                    "4", //id_country
                    "5", // id_category
                    "0", //is_popular
                    "Prambanan Temple", //name
                    "https://upload.wikimedia.org/wikipedia/commons/f/fc/Prambanan_Java245.jpg", //image
                    "Sleman, Yogyakarta", //location
                    "A Beautiful Temple", //subtitle
                    "The Prambanan temple is the largest Hindu temple of ancient Java, and the first building was completed in the mid-9th century. It was likely started by Rakai Pikatan as the Hindu Sanjaya Dynasty's.", //description
                    "USD 23,5", // price
                    "The temple complex of Prambanan lies among green fields and villages. It has eight shrines, of which the three main ones are dedicated to Shiva, Vishnu and Brahma. The main temple of Shiva rises to a height of 130 feet and houses the magnificent statue of Shiva's consort, Durga. There are 224 temples in the complex three of them, the main temples are Brahma Temple in the north, Vishnu Temple in the south, and the biggest among the three which lies between Brahma and Vishnu temples is Shiva Temple (47 meters high).", // overview
                    "Besides information regarding Kabori Lake rice terrace entrance fee. You also will get related information on Kabori Lake rice field, such as:", // preparation
            },
            {
                    "5", //id_country
                    "2", // id_category
                    "1", //is_popular
                    "Museum Visit", //name
                    "https://www.indonesia-tourism.com/central-kalimantan/images/balanga_museum.jpg", //image
                    "Palangkaraya, Kalimantan", //location
                    "A Beautiful Museum", //subtitle
                    "Balanga Museum has different types of collections of material culture (cultural objects) are grouped into collections of ethnographic, historical, archeology, keramologic, numismatic and heraldic.", //description
                    "USD 23,5", // price
                    "When you enter the exhibition space then you will feel the atmosphere of traditional life of the Dayak. Collection organized on the life cycle, starting from the equipment phase ceremonies of birth, marriage and death final. Guides will not forget to tell you about the uniqueness of Tiwah ceremony. Here you will see the uniqueness of traditional weapons such as Chopsticks, Duhung, Mandau, miniature longhouse called Betang, tool inviter fish called Mihing, sculpture Sapundu and Hampatung Karuhei, fetish Penyang, miscellaneous goods brass, various jars of ceramics from China of the Ming and Ching dynasty called Balanga and Malawen plate.", // overview
                    "Besides information regarding Kabori Lake rice terrace entrance fee. You also will get related information on Kabori Lake rice field, such as:", // preparation
            },
            {
                    "5", //id_country
                    "1", // id_category
                    "0", //is_popular
                    "Waterfall Recreation", //name
                    "https://www.indonesia-tourism.com/central-kalimantan/images/tosah_waterfall.jpg", //image
                    "Murung, Kalimantan", //location
                    "A Beautiful Waterfall", //subtitle
                    "Tosah Waterfall has a distance for about 45 minutes from the capital of Puruk Cahu. To get there can take the route through Muara Teweh.", //description
                    "USD 23,5", // price
                    "Tosah Waterfall has a height of about 15 m with a waterfall path is divided into three, two large and one small, the amount of water will be more and more during the rainy season. Under the fall of the water formed natural pools for bathing, but can not stand the cold water make linger for a shower there. Tosah Waterfall located in Muara Ja'an Village, Murung District, Murung Raya Regency of Central Kalimantan.", // overview
                    "Besides information regarding Kabori Lake rice terrace entrance fee. You also will get related information on Kabori Lake rice field, such as:", // preparation
            },
            {
                    "5", //id_country
                    "4", // id_category
                    "1", //is_popular
                    "Capital City Tour", //name
                    "https://www.indonesia-tourism.com/central-kalimantan/images/muara_teweh.jpg", //image
                    "Murung, Kalimantan", //location
                    "A Beautiful Capital City", //subtitle
                    "This town surrounded by forest and elongated following the river flow. This town is the one crowd countryside in Barito river, which divide Kalimantan islnd from Banjarmasin, South Kalimantan to Murung Raya regency, Central Kalimantan.", //description
                    "USD 23,5", // price
                    "Muara Teweh presenting a unique view. In this small town, there are quite a lot of floating homes, set along the banks of Barito River. Such kind of house can be regarded as local wisdom to avoid the danger of flooding. Due to flooding in Muara Teweh generally in puddle, not a flood, so however high the flood that occurred will not drown the houses. Along the river, visitors will also find a charming natural scenery. Watching dense and green forests of Borneo and listen to the song of the typical animals there, is a valuable experience that you cannot find in other places.", // overview
                    "Besides information regarding Kabori Lake rice terrace entrance fee. You also will get related information on Kabori Lake rice field, such as:", // preparation
            },
            {
                    "6", //id_country
                    "7", // id_category
                    "1", //is_popular
                    "Selayar Island", //name
                    "https://www.indonesia-tourism.com/south-sulawesi/images/selayar_island.jpg", //image
                    "Selayar, Sulawesi", //location
                    "A Beautiful Island", //subtitle
                    "Selayar is an island that located in Selayar islands regency, South Sulawesi. Selayar Island is separated from the mainland of South Sulawesi that stretches from north to south between Sulawesi Island and Takabonerate island.", //description
                    "USD 23,5", // price
                    "The west coast and the northern part of the island is in the form of rocks and steep cliffs, while the east coast and most of the south coast is a form of sloping beach and forest areas, such as production and plantation. The specificity of this island is coming from the endemic fauna of Tarsius tarsier. The inhabitants that live in this island are coming from some tribes like Makassar people, Bugis and Mandar. All those people who live in Selayar are speaking Selayar language.", // overview
                    "Besides information regarding Kabori Lake rice terrace entrance fee. You also will get related information on Kabori Lake rice field, such as:", // preparation
            },
            {
                    "6", //id_country
                    "2", // id_category
                    "1", //is_popular
                    "Colonial Tour", //name
                    "https://www.indonesia-tourism.com/south-sulawesi/images/fort_rotterdam.jpg", //image
                    "Makassar, Sulawesi", //location
                    "A Beautiful Fort", //subtitle
                    "Fort Rotterdam or Benteng Ujung Pandang is an Old Dutch colonial fort in Makassar, overlooking the harbor. It is one of the top attractions in Makassar.", //description
                    "USD 23,5", // price
                    "Fort Rotterdam consists of five towers, four on each corner and one at the main entrance. Inside are thirteen buildings, eleven made by the Dutch and two were built by the Japanese. The oldest building was built in 1686 and is called the Speelman's house, after the admiral who concurred the fort although he never actually lived in the house. The house was used by Dutch governors till mid-19th century. Currently a museum is housed here. Other structures were used as sleeping quarters for officers, prison or warehouses.", // overview
                    "Besides information regarding Kabori Lake rice terrace entrance fee. You also will get related information on Kabori Lake rice field, such as:", // preparation
            },
            {
                    "6", //id_country
                    "3", // id_category
                    "1", //is_popular
                    "Wakatobi", //name
                    "https://i0.wp.com/discoveryourindonesia.com/wp-content/uploads/2013/06/Tomia-Island-Life.jpg?w=700&ssl=1", //image
                    "Makassar, Sulawesi", //location
                    "A Beautiful Beach View", //subtitle
                    "Wakatobi is officially a part of Sulawesi. The islands, more about that in a sec, are off the north-eastern coast of the mainland.", //description
                    "USD 23,5", // price
                    "The name Wakatobi comes from the first two letters of the islands; Wangi Wangi, Kaledupa, Tomia and Binongko. It’s catchy and better than Gipaiako, which you’d get if you use the last two letters from the name of each island.", // overview
                    "Besides information regarding Kabori Lake rice terrace entrance fee. You also will get related information on Kabori Lake rice field, such as:", // preparation
            }

    };

    public static ArrayList<ModelTour> getListData(int is_popular, int id_country, int tipe){
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
            model.setPrice(data[8]);
            model.setOverview(data[9]);
            model.setPreparation(data[10]);

            if(is_popular == Integer.valueOf(data[2])){
                if(tipe == 0){
                    if(id_country == Integer.valueOf(data[0])){
                        list.add(model);
                    }
                }
                else{
                    if(id_country == Integer.valueOf(data[1])){
                        list.add(model);
                    }
                }
            }

        }

        return list;
    }

}
