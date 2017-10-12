package com.example.lionwitcher.autorepair;

import android.util.Log;
import android.widget.EditText;

/**
 * Created by LionWitcher on 12.10.2017.
 */

public class Car {
    private String brand; //TO DO -> Brand brand
    private String model; //To Do -> Model model
    private String VIN;
    private int year;
    private int odometr;
    private String purchaseDate;
    private static final int VIN_LENGTH = 17;
    private final String LOG_TAG = this.getClass().getSimpleName();
    private int errorCode = Errors.NONE_STATUS;

    Car(){
        brand = "";
        model = "";
        VIN = "";
        year = 0;
        odometr = 0;
        purchaseDate = "";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVIN(){
        return VIN;
    }

    public void setVIN(String VIN){
        this.VIN = VIN;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public int getOdometr(){
        return odometr;
    }

    public void setOdometr(int odometr){
        this.odometr = odometr;
    }

    static boolean validVIN(String VIN){ //TO DO pattern
        if (VIN.length() == VIN_LENGTH){
            return true;
        }
        return false;
    }

    public void parseVIN(EditText VIN){
        if (VIN != null && !VIN.getText().toString().equals("")) {
            String temp = VIN.getText().toString().trim().toUpperCase();
            if (validVIN(temp)) {
                this.VIN = temp;
            } else {
                Log.e(LOG_TAG, "VIN has incorrect format!");
            }
        } else {
            Log.e(LOG_TAG, "VIN has empty value!");
        }
    }

    public void parseOdometr(EditText odometr) {
        if (odometr != null && !odometr.getText().toString().equals("")) {
            this.odometr = Integer.parseInt(odometr.getText().toString());
        } else {
            Log.e(LOG_TAG, "Odometr has empty value!");
        }
    }


    @Override
    public String toString() {
        return "Brand: " + brand + "; Model: " + model + "; VIN: " + VIN +
                "; Year: " + year + "; Odometr: " + odometr + " Data: " + purchaseDate;
    }

}
