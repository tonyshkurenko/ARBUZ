package me.cullycross.arbuz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;
import java.util.List;

import me.cullycross.arbuz.R;
import me.cullycross.arbuz.activities.MapActivity;
import me.cullycross.arbuz.content.CrimeLocation;

/**
 * Created by: cullycross
 * Date: 9/6/15
 * For my shining stars!
 *
 * good morning, sorry for this glitch, it's 8 am, I didn't sleep for a long time, just working
 */
public class CrimeInfoViewAdapter implements GoogleMap.InfoWindowAdapter {

    private LayoutInflater mInflater;
    private Context mContext;

    public CrimeInfoViewAdapter (LayoutInflater inflater, Context ctx) {
        this.mInflater = inflater;
        this.mContext = ctx;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        CrimeLocation neededCrime = ((MapActivity) mContext).getClickedCrime();

        // kill me
        if (neededCrime != null) {
            List<String> crimeStats = new ArrayList<>();

            if(neededCrime.getBodilyHarmWithFatalCons() != 0) {
                crimeStats.add("BodilyHarmWithFatalCons: "
                        + neededCrime.getBodilyHarmWithFatalCons());
            }

            if(neededCrime.getBrigandage() != 0) {
                crimeStats.add("Brigandage: "
                        + neededCrime.getBrigandage());
            }

            if(neededCrime.getDrugs() != 0) {
                crimeStats.add("Drugs: "
                        + neededCrime.getDrugs());
            }

            if(neededCrime.getExtortion() != 0) {
                crimeStats.add("Extortion: "
                        + neededCrime.getExtortion());
            }

            if(neededCrime.getFraud() != 0) {
                crimeStats.add("Fraud: "
                        + neededCrime.getFraud());
            }

            if(neededCrime.getHeavOsoboHeav() != 0) {
                crimeStats.add("HeavOsoboHeavy: "
                        + neededCrime.getHeavOsoboHeav());
            }

            if(neededCrime.getHooliganism() != 0) {
                crimeStats.add("Hooliganism: "
                        + neededCrime.getHooliganism());
            }

            if(neededCrime.getIntentionalInjury() != 0) {
                crimeStats.add("IntentionalInjury: "
                        + neededCrime.getIntentionalInjury());
            }

            if(neededCrime.getLooting() != 0) {
                crimeStats.add("Looting: "
                        + neededCrime.getLooting());
            }

            if(neededCrime.getMurder() != 0) {
                crimeStats.add("Murder: "
                        + neededCrime.getMurder());
            }

            if(neededCrime.getRape() != 0) {
                crimeStats.add("Rape: "
                        + neededCrime.getRape());
            }

            if(neededCrime.getTheft() != 0) {
                crimeStats.add("Theft: "
                        + neededCrime.getTheft());
            }

            if(crimeStats.size() == 0) {
                return null;
            }

            View popup = mInflater.inflate(R.layout.infowindow_layout, null);

            ListView crimes = (ListView)popup.findViewById(R.id.list_view_crimes);
            TextView address = (TextView) popup.findViewById(R.id.text_view_address);

            address.setText(neededCrime.getStreet() + neededCrime.getBuilding());
            crimes.setAdapter(new ArrayAdapter<>(
                    mContext, android.R.layout.simple_list_item_1, crimeStats));

            return popup;
        }
        return null;
    }
}
