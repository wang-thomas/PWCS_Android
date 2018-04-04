package com.whartonsummit.android_app.pwcs_android.Models;

/**
 * Created by zhileizheng on 3/31/18.
 */

public enum Location {
    ANNENBERG, INNATPENN, IRVINE, THESTUDY, MARRIOTT, SHERATON;

    @Override
    public String toString() {
        switch (this) {
            case IRVINE:
                return "Irvine Auditorium";
            case ANNENBERG:
                return "Annenberg Center";
            case INNATPENN:
                return "Inn At Penn";
            case THESTUDY:
                return "The Study";
            case MARRIOTT:
                return "Marriott Downtown";
            case SHERATON:
                return "SHERATON";
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
            case ANNENBERG:
                coordinates[0] = 39.9528219;
                coordinates[1] = -75.1962859;
                return coordinates;
            case IRVINE:
                coordinates[0] = 39.9509218;
                coordinates[1] = -75.1929818;
                return coordinates;
            case SHERATON:
                coordinates[0] = 39.9548644;
                coordinates[1] = -75.1941684;
                return coordinates;
            case MARRIOTT:
                coordinates[0] = 39.952575;
                coordinates[1] = -75.160527;
                return coordinates;
            case THESTUDY:
                coordinates[0] = 39.954523;
                coordinates[1] = -75.190019;
                return coordinates;
            default:
                return coordinates;
        }
    }

    public String toSearchTerm() {
        switch (this) {
            case IRVINE:
                return "Irvine+Auditorium";
            case ANNENBERG:
                return "Annenberg+Center+for+the+Performing+Arts";
            case INNATPENN:
                return "The+Inn+at+Penn,+a+Hilton+Hotel";
            case THESTUDY:
                return "The+Study+at+University+City";
            case MARRIOTT:
                return "Philadelphia+Marriott+Downtown";
            case SHERATON:
                return "Sheraton+Philadelphia+University+City+Hotel";
            default:
                return "TBA";
        }
    }
}
