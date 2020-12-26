package com.example.myjabalpur;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Restaurants#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Restaurants extends Fragment
{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Restaurants()
    {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Restaurants.
     */
    // TODO: Rename and change types and number of parameters
    public static Restaurants newInstance(String param1, String param2)
    {
        Restaurants fragment = new Restaurants();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.word_list, container, false);

        ArrayList<ListItems> items = new ArrayList<>();
        items.add(new ListItems("Darbar", 4.3f, R.drawable.vegphoto, "Darbar restaurant, Jabalpur+Jayanti+Complex",R.drawable.vegicon, true));
        items.add(new ListItems("Tava", 4.1f, R.drawable.vegphoto, "Tava restaurant, Jabalpur+Maharishi+Dayanand+Saraswati+Chowk",R.drawable.vegicon, true));
        items.add(new ListItems("Royal Cafe", 3.8f, R.drawable.vegphoto, "Royal+Cafe+Restaurant, Jabalpur+Maharishi+Dayanand+Saraswati+Chowk",R.drawable.vegicon, true));
        items.add(new ListItems("Avtar Restaurant", 3.7f, R.drawable.nonvegphoto, "Hotel+Avtar+Bar+and+Restaurant, Jabalpur+Dr+Bharat+Rd+Russel+Chowk",R.drawable.nonvegicon, true));
        items.add(new ListItems("Best Choice", 4.2f, R.drawable.nonvegphoto, "Best+Choice,Jabalpur+Shastri+Bridge+Rd+Napier+Town",R.drawable.nonvegicon, true));
        items.add(new ListItems("Parampara Restaurant", 4.4f, R.drawable.vegphoto, "Parampara Restaurant, Jabalpur+4rth+Bridge+Road+Opposite+sahil+Honda+Napier+Town",R.drawable.vegicon, true));
        items.add(new ListItems("Navnita Restaurant", 4.0f, R.drawable.vegphoto, "NavNita Restaurant, Jabalpur+Opposite+Anand+Cinema+Napier+Town",R.drawable.vegicon, true));
        items.add(new ListItems("Kamling Chinese", 4.0f, R.drawable.nonvegphoto, "Kamling Chinese Restaurant, Jabalpur+Gulati+Complex+Opposite+Maharishi+College+Napier+Town",R.drawable.nonvegicon, true));


        ListAdaptor adaptor = new ListAdaptor(getActivity(), 0, items, R.color.fragment_restaurants);

        ListView listview = view.findViewById(R.id.listview);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
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

        listview.setAdapter(adaptor);
        return view;
    }
}