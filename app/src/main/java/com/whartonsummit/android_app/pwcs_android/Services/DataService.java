package com.whartonsummit.android_app.pwcs_android.Services;

import com.whartonsummit.android_app.pwcs_android.Models.TimelineObj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhileizheng on 3/29/18.
 */

public class DataService {

    public static DataService instance;

    HashMap<Integer, List<TimelineObj>> timelines;

    private DataService() {
        populateTimeline();
    }

    public static DataService getInstance() {
        if (instance == null) {
            instance = new DataService();
        }
        return instance;
    }

    public List<TimelineObj> getScheduleForDay(int i) {
        return timelines.get(i);
    }

    public void populateTimeline() {
        timelines = new HashMap<Integer, List<TimelineObj>>();
        List<TimelineObj> day1 = new ArrayList<>();
        day1.add(new TimelineObj("Finance Panel", "8AM - 9AM", "Annenburg Center", "Hello World"));
        day1.add(new TimelineObj("Finance Panel", "8AM - 9AM", "Annenburg Center", "Hello World"));
        day1.add(new TimelineObj("Finance Panel", "8AM - 9AM", "Annenburg Center", "Hello World"));
        List<TimelineObj> day2 = new ArrayList<>();
        day2.add(new TimelineObj("Finance Panel", "8AM - 9AM", "Annenburg Center", "Hello World"));
        List<TimelineObj> day3 = new ArrayList<>();
        timelines.put(1, day1);
        timelines.put(2, day2);
        timelines.put(3, day3);
    }

    



}
