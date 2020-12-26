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
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Hotels#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Hotels extends Fragment
{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Hotels()
    {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Hotels.
     */
    // TODO: Rename and change types and number of parameters
    public static Hotels newInstance(String param1, String param2)
    {
        Hotels fragment = new Hotels();
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
        items.add(new ListItems("Hotel GuruMukh", 4.0f, R.drawable.hotels, "Hotel+GuruMukh, Jabalpur+KaramChand+Chowk",false));
        items.add(new ListItems("Hotel Dwarika", 3.3f, R.drawable.hotels, "Hotel+Dwarika+Inn, Jabalpur+Civic+Center",false));
        items.add(new ListItems("Vijan Palace", 3.9f, R.drawable.hotels, "Vijan+Palace , Jabalpur+Vijan+Market+Near+KaramChand+Chowk",false));
        items.add(new ListItems("Hotel Ajanta", 3.4f, R.drawable.hotels, "Hotel Ajanta, Jabalpur+Patel+Mohalla+Marhatal",false));
        items.add(new ListItems("Hotel Chandini", 2.9f, R.drawable.hotels, "Hotel Chandini, Jabalpur+Near+Bus+Stand+Wright+Town",false));
        items.add(new ListItems("Hotel Anushree", 3.8f, R.drawable.hotels, "Hotel Anushree, Jabalpur+Naudra+Bridge",false));


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

        ListAdaptor adaptor = new ListAdaptor(getActivity(), 0, items, R.color.fragment_hotels);

        listview.setAdapter(adaptor);
        return view;
    }
}