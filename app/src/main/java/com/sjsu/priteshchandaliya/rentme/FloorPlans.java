package com.sjsu.priteshchandaliya.rentme;

/**
 * Created by priteshchandaliya on 7/4/16.
 */
public class FloorPlans {


    private String serial_no;
    private String bedroom;
    private String bathroom;
    private String availability;

    public FloorPlans()
    {

    }

    public FloorPlans(String serial_no,String bedroom, String bathroom, String availability)
    {

        this.serial_no = serial_no;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.availability = availability;
    }

    public void setSerial_no(String serial_no)
    {
        this.serial_no = serial_no;
    }

    public void setBathroom(String bathroom)
    {
        this.bathroom = bathroom;
    }

    public void setBedroom(String bedroom)
    {
        this.bedroom = bedroom;
    }

    public void setAvailability(String availability)
    {
        this.availability = availability;
    }


    public String getSerial_no()
    {
        return serial_no;
    }

    public String getBathroom()
    {
        return bathroom;
    }

    public String getBedroom()
    {
        return bedroom;
    }

    public String getAvailability()
    {
        return availability;
    }




}
