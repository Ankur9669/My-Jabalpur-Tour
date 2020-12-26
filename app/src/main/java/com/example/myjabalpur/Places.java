package com.example.myjabalpur;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;


import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Places#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Places extends Fragment
{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Places()
    {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Places.
     */
    // TODO: Rename and change types and number of parameters
    public static Places newInstance(String param1, String param2)
    {
        Places fragment = new Places();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.word_list, container, false);

        ArrayList<ListItems> items = new ArrayList<>();
        items.add(new ListItems("BhedaGhat", 4.7f, R.drawable.bhedaghat, "BhedaGhat, Jabalpur+MadhyaPradesh", false));
        items.add(new ListItems("LamhetaGhat", 3.4f, R.drawable.ghugra, "Lamhetaghat, Jabalput+Sagra", false));
        items.add(new ListItems("Bargi", 4.6f, R.drawable.bargi, "Bargi Dam, Jabalpur", false));
        items.add(new ListItems("Payli", 3.7f, R.drawable.payli, "Payli, Jabalpur", false));
        items.add(new ListItems("Nidan Fall", 4.7f, R.drawable.nidanfall, "Nidan Fall, Katangi", false));
        items.add(new ListItems("Panchvati", 4.9f, R.drawable.bhedaghat, "PanchVati, Bhedaghat+Jabalpur", false));
        items.add(new ListItems("Gwarighat", 4.1f, R.drawable.gwarighat, "Gwarighat, Jabalpur", false));
        items.add(new ListItems("Jilaharighat", 3.1f, R.drawable.gwarighat, "Jilahri Ghat, Jabalpur", false));
        items.add(new ListItems("Tilwaraghat", 4.0f, R.drawable.tilwaraghat, "TilwaraGhat, Jabalpur", false));
        items.add(new ListItems("Madan Mahal Fort", 3.7f, R.drawable.madanmahal, "Madan Mahal Fort, Jabalpur+GurudevColony", false));
        items.add(new ListItems("Roopnath", 4.6f, R.drawable.roopnath,"Roopnath Mandir, Sihora Road + Darshani", false));
        items.add(new ListItems("Dumna", 4.1f, R.drawable.dumna, "Dumna Nature Reserve, Jabalpur", false));
        items.add(new ListItems("Bhawartal Garden", 4.2f, R.drawable.bhawartal, "Bhawartal Garden, Jabalpur+NapierTown", false));


        ListAdaptor adaptor = new ListAdaptor(getActivity(),0, items, R.color.fragment_places);

        ListView listView = view.findViewById(R.id.listview);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String temp = items.get(position).getLocation();

                //This is the intent for getting to the google maps
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + temp);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        listView.setAdapter(adaptor);
        return view;
    }
}