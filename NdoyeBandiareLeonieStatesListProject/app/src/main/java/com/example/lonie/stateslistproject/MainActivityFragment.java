package com.example.lonie.stateslistproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        String [] liststates = {"Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida"," Georgia","Hawaii","Idaho","Illinois Indiana Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts"," Michigan","Minnesota","Mississippi","Missouri","Montana Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont"," Virginia","Washington","West Virginia","Wisconsin","Wyoming" };
        List<String> stateAR = new ArrayList<String>(Arrays.asList(liststates));

        ArrayAdapter<String> stateadapter = new ArrayAdapter<String>(getActivity(),R.layout.liststateitem,R.id.textView,stateAR);
        ListView lv = (ListView) rootView.findViewById (R.id.listviewlayout);
        lv.setAdapter(stateadapter);
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
