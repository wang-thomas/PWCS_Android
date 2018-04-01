package com.whartonsummit.android_app.pwcs_android.Services;

import com.whartonsummit.android_app.pwcs_android.Models.Location;
import com.whartonsummit.android_app.pwcs_android.Models.Panel;
import com.whartonsummit.android_app.pwcs_android.Models.Speaker;
import com.whartonsummit.android_app.pwcs_android.Models.TimelineObj;
import com.whartonsummit.android_app.pwcs_android.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhileizheng on 3/29/18.
 */

public class DataService {

    public static DataService instance;

    HashMap<Integer, List<TimelineObj>> timelines;
    List<Panel> panels;
    HashMap<String, List<Speaker>> speakers;

    private DataService() {
        populateTimeline();
        populatePanels();
        populateSpeakers();
    }

    public static DataService getInstance() {
        if (instance == null) {
            instance = new DataService();
        }
        return instance;
    }

    /*
    * MARK: Schedules
    * */

    public List<TimelineObj> getScheduleForDay(int i) {
        return timelines.get(i);
    }

    public void populateTimeline() {
        timelines = new HashMap<Integer, List<TimelineObj>>();
        // @TODO: Day 1 Schedules
        List<TimelineObj> day1 = new ArrayList<>();
        day1.add(new TimelineObj("Finance Panel", "8AM - 9AM", "Annenburg Center", "Hello World"));
        day1.add(new TimelineObj("Finance Panel", "8AM - 9AM", "Annenburg Center", "Hello World"));
        day1.add(new TimelineObj("Finance Panel", "8AM - 9AM", "Annenburg Center", "Hello World"));
        // @TODO: Day 2 Schedules
        List<TimelineObj> day2 = new ArrayList<>();
        day2.add(new TimelineObj("Technology Panel", "8AM - 9AM", "Annenburg Center", "Hello World"));
        // @TODO: Day 3 Schedules
        List<TimelineObj> day3 = new ArrayList<>();
        day3.add(new TimelineObj("Closing Panel", "8AM - 9AM", "Annenburg Center", "Hello World"));
        timelines.put(1, day1);
        timelines.put(2, day2);
        timelines.put(3, day3);
    }

    /*
    * MARK: Panels
    * */

    public List<Panel> getPanels() {
        return panels;
    }

    public void populatePanels() {
        panels = new ArrayList<Panel>();
        panels.add(new Panel("Finance Panel", R.drawable.panel_bg_hongkong,
                "Make America Great Again", "9:00AM - 11:00AM",
                Location.ANNENBURG, "The 2018 Penn Wharton China Summit will be held on April 13th-15th, " +
                "2018 at the University of Pennsylvania. Hosted by the China Summit Foundation and the Penn Wharton China Center, " +
                "and further supported by the Chinese embassy and the government of Pennsylvania, PWCS is committed to build an " +
                "influential platform that promotes communications between the two countries and establish connections among " +
                "students oversea in the United States. With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, " +
                "the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. " +
                "2018 is an important year for the development of US-China relationship. We hope to strengthen the communication and " +
                "facilitate cooperation between top students, professionals and corporations from both countries, and contribute " +
                "to the long-lasting friendship between the United States and China."));
        panels.add(new Panel("Internation Relations Panel", R.drawable.panel_bg_beijing,
                "Make America Tech Again", "1:00PM - 3:00PM",
                Location.INNATPENN, "The 2018 Penn Wharton China Summit will be held on April 13th-15th, " +
                "2018 at the University of Pennsylvania. Hosted by the China Summit Foundation and the Penn Wharton China Center, " +
                "and further supported by the Chinese embassy and the government of Pennsylvania, PWCS is committed to build an " +
                "influential platform that promotes communications between the two countries and establish connections among " +
                "students oversea in the United States. With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, " +
                "the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. " +
                "2018 is an important year for the development of US-China relationship. We hope to strengthen the communication and " +
                "facilitate cooperation between top students, professionals and corporations from both countries, and contribute " +
                "to the long-lasting friendship between the United States and China."));
        panels.add(new Panel("Real Estate Panel", R.drawable.panel_bg_chicago,
                "Make America Tech Again", "1:00PM - 3:00PM",
                Location.INNATPENN, "The 2018 Penn Wharton China Summit will be held on April 13th-15th, " +
                "2018 at the University of Pennsylvania. Hosted by the China Summit Foundation and the Penn Wharton China Center, " +
                "and further supported by the Chinese embassy and the government of Pennsylvania, PWCS is committed to build an " +
                "influential platform that promotes communications between the two countries and establish connections among " +
                "students oversea in the United States. With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, " +
                "the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. " +
                "2018 is an important year for the development of US-China relationship. We hope to strengthen the communication and " +
                "facilitate cooperation between top students, professionals and corporations from both countries, and contribute " +
                "to the long-lasting friendship between the United States and China."));
        panels.add(new Panel("Arts and Fashion Panel", R.drawable.panel_bg_la,
                "Make America Tech Again", "1:00PM - 3:00PM",
                Location.INNATPENN, "The 2018 Penn Wharton China Summit will be held on April 13th-15th, " +
                "2018 at the University of Pennsylvania. Hosted by the China Summit Foundation and the Penn Wharton China Center, " +
                "and further supported by the Chinese embassy and the government of Pennsylvania, PWCS is committed to build an " +
                "influential platform that promotes communications between the two countries and establish connections among " +
                "students oversea in the United States. With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, " +
                "the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. " +
                "2018 is an important year for the development of US-China relationship. We hope to strengthen the communication and " +
                "facilitate cooperation between top students, professionals and corporations from both countries, and contribute " +
                "to the long-lasting friendship between the United States and China."));
        panels.add(new Panel("Social Responsibility Panel", R.drawable.panel_bg_shanghai,
                "Make America Tech Again", "1:00PM - 3:00PM",
                Location.INNATPENN, "The 2018 Penn Wharton China Summit will be held on April 13th-15th, " +
                "2018 at the University of Pennsylvania. Hosted by the China Summit Foundation and the Penn Wharton China Center, " +
                "and further supported by the Chinese embassy and the government of Pennsylvania, PWCS is committed to build an " +
                "influential platform that promotes communications between the two countries and establish connections among " +
                "students oversea in the United States. With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, " +
                "the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. " +
                "2018 is an important year for the development of US-China relationship. We hope to strengthen the communication and " +
                "facilitate cooperation between top students, professionals and corporations from both countries, and contribute " +
                "to the long-lasting friendship between the United States and China."));
        panels.add(new Panel("Technology Panel", R.drawable.panel_bg_seattle,
                "Make America Tech Again", "1:00PM - 3:00PM",
                Location.INNATPENN, "The 2018 Penn Wharton China Summit will be held on April 13th-15th, " +
                "2018 at the University of Pennsylvania. Hosted by the China Summit Foundation and the Penn Wharton China Center, " +
                "and further supported by the Chinese embassy and the government of Pennsylvania, PWCS is committed to build an " +
                "influential platform that promotes communications between the two countries and establish connections among " +
                "students oversea in the United States. With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, " +
                "the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. " +
                "2018 is an important year for the development of US-China relationship. We hope to strengthen the communication and " +
                "facilitate cooperation between top students, professionals and corporations from both countries, and contribute " +
                "to the long-lasting friendship between the United States and China."));
    }

    /*
    * MARK: Speakers
    * */

    public List<Speaker> getSpeakerForPanel(String panelName) {
        return speakers.get(panelName);
    }

    public void populateSpeakers() {
        speakers = new HashMap<>();
        List<Speaker> openingSpeakers = new ArrayList<>();
        // TODO: opening speakers:
        openingSpeakers.add(new Speaker("Kevin Rudd", "", "Former Premier of Australia", "The 2018 Penn Wharton China Summit will be held on April 13th-15th, " +
                "2018 at the University of Pennsylvania. Hosted by the China Summit Foundation and the Penn Wharton China Center, " +
                "and further supported by the Chinese embassy and the government of Pennsylvania, PWCS is committed to build an " +
                "influential platform that promotes communications between the two countries and establish connections among " +
                "students oversea in the United States. With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, " +
                "the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. " +
                "2018 is an important year for the development of US-China relationship. We hope to strengthen the communication and " +
                "facilitate cooperation between top students, professionals and corporations from both countries, and contribute " +
                "to the long-lasting friendship between the United States and China.", R.drawable.speaker_kevin_rudd));
        openingSpeakers.add(new Speaker("Fu Ying", "", "China Foreign Minister", "The 2018 Penn Wharton China Summit will be held on April 13th-15th, " +
                "2018 at the University of Pennsylvania. Hosted by the China Summit Foundation and the Penn Wharton China Center, " +
                "and further supported by the Chinese embassy and the government of Pennsylvania, PWCS is committed to build an " +
                "influential platform that promotes communications between the two countries and establish connections among " +
                "students oversea in the United States. With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, " +
                "the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. " +
                "2018 is an important year for the development of US-China relationship. We hope to strengthen the communication and " +
                "facilitate cooperation between top students, professionals and corporations from both countries, and contribute " +
                "to the long-lasting friendship between the United States and China.", R.drawable.speaker_fu_ying));
        openingSpeakers.add(new Speaker("Su Mang", "", "CEO of BaSha", "The 2018 Penn Wharton China Summit will be held on April 13th-15th, " +
                "2018 at the University of Pennsylvania. Hosted by the China Summit Foundation and the Penn Wharton China Center, " +
                "and further supported by the Chinese embassy and the government of Pennsylvania, PWCS is committed to build an " +
                "influential platform that promotes communications between the two countries and establish connections among " +
                "students oversea in the United States. With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, " +
                "the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. " +
                "2018 is an important year for the development of US-China relationship. We hope to strengthen the communication and " +
                "facilitate cooperation between top students, professionals and corporations from both countries, and contribute " +
                "to the long-lasting friendship between the United States and China.", R.drawable.speaker_su_mang));
        List<Speaker> closingSpeakers = new ArrayList<>();
        // TODO: closing speakers:
        closingSpeakers.add(new Speaker("Fu Ying", "", "China Foreign Minister", "The 2018 Penn Wharton China Summit will be held on April 13th-15th, " +
                "2018 at the University of Pennsylvania. Hosted by the China Summit Foundation and the Penn Wharton China Center, " +
                "and further supported by the Chinese embassy and the government of Pennsylvania, PWCS is committed to build an " +
                "influential platform that promotes communications between the two countries and establish connections among " +
                "students oversea in the United States. With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, " +
                "the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. " +
                "2018 is an important year for the development of US-China relationship. We hope to strengthen the communication and " +
                "facilitate cooperation between top students, professionals and corporations from both countries, and contribute " +
                "to the long-lasting friendship between the United States and China.", R.drawable.speaker_fu_ying));
        List<Speaker> financeSpeakers = new ArrayList<>();
        // TODO: closing speakers:
        financeSpeakers.add(new Speaker("Ying Shulin", "", "CEO of Temp", "The 2018 Penn Wharton China Summit will be held on April 13th-15th, " +
                "2018 at the University of Pennsylvania. Hosted by the China Summit Foundation and the Penn Wharton China Center, " +
                "and further supported by the Chinese embassy and the government of Pennsylvania, PWCS is committed to build an " +
                "influential platform that promotes communications between the two countries and establish connections among " +
                "students oversea in the United States. With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, " +
                "the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. " +
                "2018 is an important year for the development of US-China relationship. We hope to strengthen the communication and " +
                "facilitate cooperation between top students, professionals and corporations from both countries, and contribute " +
                "to the long-lasting friendship between the United States and China.", R.drawable.speaker_ying_shu_lin));
        List<Speaker> techSpeakers = new ArrayList<>();
        // TODO: closing speakers:
        techSpeakers.add(new Speaker("Kebin Dai", "", "CEO of Liepin", "The 2018 Penn Wharton China Summit will be held on April 13th-15th, " +
                "2018 at the University of Pennsylvania. Hosted by the China Summit Foundation and the Penn Wharton China Center, " +
                "and further supported by the Chinese embassy and the government of Pennsylvania, PWCS is committed to build an " +
                "influential platform that promotes communications between the two countries and establish connections among " +
                "students oversea in the United States. With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, " +
                "the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. " +
                "2018 is an important year for the development of US-China relationship. We hope to strengthen the communication and " +
                "facilitate cooperation between top students, professionals and corporations from both countries, and contribute " +
                "to the long-lasting friendship between the United States and China.", R.drawable.speaker_kebin_dai));
        List<Speaker> irSpeakers = new ArrayList<>();
        // TODO: closing speakers:
        irSpeakers.add(new Speaker("Kevin Rudd", "", "Prime Minister of Australia", "The 2018 Penn Wharton China Summit will be held on April 13th-15th, " +
                "2018 at the University of Pennsylvania. Hosted by the China Summit Foundation and the Penn Wharton China Center, " +
                "and further supported by the Chinese embassy and the government of Pennsylvania, PWCS is committed to build an " +
                "influential platform that promotes communications between the two countries and establish connections among " +
                "students oversea in the United States. With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, " +
                "the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. " +
                "2018 is an important year for the development of US-China relationship. We hope to strengthen the communication and " +
                "facilitate cooperation between top students, professionals and corporations from both countries, and contribute " +
                "to the long-lasting friendship between the United States and China.", R.drawable.speaker_kevin_rudd));
        List<Speaker> estateSpeakers = new ArrayList<>();
        // TODO: closing speakers:
        estateSpeakers.add(new Speaker("Fu Ying", "", "China Foreign Minister", "The 2018 Penn Wharton China Summit will be held on April 13th-15th, " +
                "2018 at the University of Pennsylvania. Hosted by the China Summit Foundation and the Penn Wharton China Center, " +
                "and further supported by the Chinese embassy and the government of Pennsylvania, PWCS is committed to build an " +
                "influential platform that promotes communications between the two countries and establish connections among " +
                "students oversea in the United States. With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, " +
                "the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. " +
                "2018 is an important year for the development of US-China relationship. We hope to strengthen the communication and " +
                "facilitate cooperation between top students, professionals and corporations from both countries, and contribute " +
                "to the long-lasting friendship between the United States and China.", R.drawable.speaker_fu_ying));
        List<Speaker> socialSpeakers = new ArrayList<>();
        // TODO: closing speakers:
        socialSpeakers.add(new Speaker("Wang Xi", "", "CEO of Whatever", "The 2018 Penn Wharton China Summit will be held on April 13th-15th, " +
                "2018 at the University of Pennsylvania. Hosted by the China Summit Foundation and the Penn Wharton China Center, " +
                "and further supported by the Chinese embassy and the government of Pennsylvania, PWCS is committed to build an " +
                "influential platform that promotes communications between the two countries and establish connections among " +
                "students oversea in the United States. With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, " +
                "the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. " +
                "2018 is an important year for the development of US-China relationship. We hope to strengthen the communication and " +
                "facilitate cooperation between top students, professionals and corporations from both countries, and contribute " +
                "to the long-lasting friendship between the United States and China.", R.drawable.speaker_wang_xi));
        List<Speaker> fashionSpeakers = new ArrayList<>();
        // TODO: closing speakers:
        fashionSpeakers.add(new Speaker("Su Mang", "", "CEO of Basha", "The 2018 Penn Wharton China Summit will be held on April 13th-15th, " +
                "2018 at the University of Pennsylvania. Hosted by the China Summit Foundation and the Penn Wharton China Center, " +
                "and further supported by the Chinese embassy and the government of Pennsylvania, PWCS is committed to build an " +
                "influential platform that promotes communications between the two countries and establish connections among " +
                "students oversea in the United States. With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, " +
                "the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. " +
                "2018 is an important year for the development of US-China relationship. We hope to strengthen the communication and " +
                "facilitate cooperation between top students, professionals and corporations from both countries, and contribute " +
                "to the long-lasting friendship between the United States and China.", R.drawable.speaker_su_mang));
        speakers.put("opening", openingSpeakers);
        speakers.put("closing", closingSpeakers);
        speakers.put("technology", techSpeakers);
        speakers.put("fashion", fashionSpeakers);
        speakers.put("finance", financeSpeakers);
        speakers.put("social", socialSpeakers);
        speakers.put("estate", estateSpeakers);
        speakers.put("ir", irSpeakers);
    }







}
