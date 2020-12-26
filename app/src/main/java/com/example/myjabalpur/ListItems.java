package com.example.myjabalpur;

public class ListItems
{

    private String name;
    private float rating;
    private int imagesrc;
    private int veg_nonvegimgsrc;
    private boolean hasSecondImage = false;
    private String location;

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }



    public boolean isHasSecondImage()
    {
        return hasSecondImage;
    }

    public void setHasSecondImage(boolean hasSecondImage)
    {
        this.hasSecondImage = hasSecondImage;
    }

    public ListItems(String name, float rating, int imgsrc, String location, boolean hasSecondImage)
    {
        this.name = name;
        this.rating = rating;
        this.imagesrc = imgsrc;
        this.location = location;
        this.hasSecondImage = hasSecondImage;
    }

    public int getVeg_nonvegimgsrc()
    {
        return veg_nonvegimgsrc;
    }

    public void setVeg_nonvegimgsrc(int veg_nonvegimgsrc)
    {
        this.veg_nonvegimgsrc = veg_nonvegimgsrc;
    }

    public ListItems(String name, float rating, int imgsrc, String location, int veg_nonvegimgsrc, boolean hasSecondImage)
    {
        this.name = name;
        this.rating = rating;
        this.imagesrc = imgsrc;
        this.location = location;
        this.veg_nonvegimgsrc = veg_nonvegimgsrc;
        this.hasSecondImage = hasSecondImage;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public float getRating()
    {
        return rating;
    }

    public void setRating(float rating)
    {
        this.rating = rating;
    }

    public int getImagesrc()
    {
        return imagesrc;
    }

    public void setImagesrc(int imagesrc)
    {
        this.imagesrc = imagesrc;
    }


}
