package com.example.myjabalpur;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.List;

public class ListAdaptor extends ArrayAdapter<ListItems>
{
    private int color;
    public ListAdaptor(@NonNull Context context, int resource, @NonNull List<ListItems> objects, int color)
    {
        super(context, resource, objects);
        this.color = color;
    }


//    public ListAdaptor(Context context, ArrayList<ListItems> resource)
//    {
//        super(context, 0, resource);
//    }


    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent)
    {
        View listItemView = convertView;

        //Check if the view is being used otherwise inflate the view
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext())
                        .inflate(R.layout.list_item, parent, false);
        }

        ListItems item = getItem(position);

        //The Text Written in the ArrayList
        TextView placeTextView = listItemView.findViewById(R.id.placetextview);
        placeTextView.setText(item.getName());

        //The Rating of the places in the ArrayList
        RatingBar placeRatingBar = listItemView.findViewById(R.id.placeratingbar);
        placeRatingBar.setRating(item.getRating());

        //The images in the arraylist
        ImageView placeImage = listItemView.findViewById(R.id.image);
        placeImage.setImageResource(item.getImagesrc());
        placeImage.setVisibility(View.VISIBLE);

        if(item.isHasSecondImage() == true)
        {
            Log.i("Msg", "YEs");
            ImageView veg_nonvegImage = listItemView.findViewById(R.id.image2);
            veg_nonvegImage.setImageResource(item.getVeg_nonvegimgsrc());
            veg_nonvegImage.setVisibility(View.VISIBLE);
        }
        else
        {
            ImageView veg_nonvegImage = listItemView.findViewById(R.id.image2);
            veg_nonvegImage.setVisibility(View.INVISIBLE);
        }

        View view = listItemView.findViewById(R.id.linearlayout);
        int viewColor = ContextCompat.getColor(getContext(), color);
        // Set the background color of the text container View
        view.setBackgroundColor(viewColor);

        return listItemView;
    }

    @Override
    public int getPosition(@Nullable ListItems item)
    {
        return super.getPosition(item);
    }
}
