package me.cullycross.arbuz.content;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;
import com.parse.ParseClassName;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;

/**
 * Created by: cullycross
 * Date: 9/5/15
 * For my shining stars!
 */

@ParseClassName("streets")
public class CrimeLocation extends ParseObject implements ClusterItem {

    public static final String LOCATION = "location";
    public static final String BUILDING = "building";
    public static final String STREET = "street";
    public static final String MONTH = "month";
    public static final String YEAR = "year";
    public static final String TOTAL = "total";
    public static final String TOTAL_POINTS = "total_points";
    public static final String BODILY_HARM_WITH_FATAL_CONS = "bodily_harm_with_fatal_cons";
    public static final String BRIGANDAGE = "brigandage";
    public static final String DRUGS = "drugs";
    public static final String EXTORTION = "extortion";
    public static final String FRAUD = "fraud";
    public static final String HEAVY = "heavy";
    public static final String HOOLIGANISM = "hooliganism";
    public static final String INTENTIONAL_INJURY = "intentional_injury";
    public static final String LOOTING = "looting";
    public static final String MURDER = "murder";
    public static final String RAPE = "rape";
    public static final String THEFT = "theft";

    @Override
    public boolean equals(Object o) {
        try {
            return this.getObjectId().equals(((CrimeLocation) o).getObjectId());
        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getObjectId().hashCode();
    }

    @Override
    public LatLng getPosition() {
        final ParseGeoPoint point = getLocation();
        return new LatLng(point.getLatitude(), point.getLongitude());
    }

    /*public WeightedLatLng getWeightedLatLng() {
        return new WeightedLatLng(getPosition(), getTotalPoints());
    }*/

    public ParseGeoPoint getLocation() {
        return getParseGeoPoint(LOCATION);
    }

    public String getBuilding() {
        return getString(BUILDING);
    }

    public String getStreet() {
        return getString(STREET);
    }

    public int getMonth() {
        return getInt(MONTH);
    }

    public int getYear() {
        return getInt(YEAR);
    }

    public int getTotal() {
        return getInt(TOTAL);
    }

    public int getTotalPoints() {
        return getInt(TOTAL_POINTS);
    }

    public int getBodilyHarmWithFatalCons() {
        return getInt(BODILY_HARM_WITH_FATAL_CONS);
    }

    public int getBrigandage() {
        return getInt(BRIGANDAGE);
    }

    public int getDrugs() {
        return getInt(DRUGS);
    }

    public int getExtortion() {
        return getInt(EXTORTION);
    }

    public int getFraud() {
        return getInt(FRAUD);
    }

    public int getHeavOsoboHeav() {
        return getInt(HEAVY);
    }

    public int getHooliganism() {
        return getInt(HOOLIGANISM);
    }

    public int getIntentionalInjury() {
        return getInt(INTENTIONAL_INJURY);
    }

    public int getLooting() {
        return getInt(LOOTING);
    }

    public int getMurder() {
        return getInt(MURDER);
    }

    public int getRape() {
        return getInt(RAPE);
    }

    public int getTheft() {
        return getInt(THEFT);
    }
}
