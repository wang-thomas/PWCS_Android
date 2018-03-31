package com.whartonsummit.android_app.pwcs_android.Models;

/**
 * Created by zhileizheng on 3/31/18.
 */

public enum Location {
    ANNENBURG, INNATPENN, IRVINE;

    @Override
    public String toString() {
        switch (this) {
            case IRVINE:
                return "Irvine Auditorium";
            case ANNENBURG:
                return "Annenburg Center";
            case INNATPENN:
                return "Inn At Penn";
            default:
                return "TBA";
        }
    }

    public double[] toLatLng() {
        double[] coordinates = new double[2];
        switch (this) {
            case INNATPENN:
                coordinates[0] = 39.9535974;
                coordinates[1] = -75.1958157;
                return coordinates;
            case ANNENBURG:
                coordinates[0] = 39.9528219;
                coordinates[1] = -75.1962859;
                return coordinates;
            case IRVINE:
                coordinates[0] = 39.952819;
                coordinates[1] = -75.1992576;
                return coordinates;
            default:
                return coordinates;
        }
    }
}
