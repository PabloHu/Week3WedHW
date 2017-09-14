package com.example.admin.week3wedhw;

/**
 * Created by Admin on 9/13/2017.
 */

public class Animal {
    int ANIMAL_ID;
    String ANIMAL_NAME;
    String ANIMAL_TYPE;
    int ANIMAL_AGE;
    int ANIMAL_WEIGHT;
    int ANIMAL_IMAGE;
    String KIWI_TIMESTAMP;

    /*
    public Animal(String ANIMAL_NAME, String ANIMAL_TYPE, int ANIMAL_AGE, int ANIMAL_WEIGHT, int ANIMAL_IMAGE) {
        this.ANIMAL_NAME = ANIMAL_NAME;
        this.ANIMAL_TYPE = ANIMAL_TYPE;
        this.ANIMAL_AGE = ANIMAL_AGE;
        this.ANIMAL_WEIGHT = ANIMAL_WEIGHT;
        this.ANIMAL_IMAGE = ANIMAL_IMAGE;
    }
*/
    public int getANIMAL_ID() {
        return ANIMAL_ID;
    }

    public void setANIMAL_ID(int ANIMAL_ID) {
        this.ANIMAL_ID = ANIMAL_ID;
    }

    public String getANIMAL_NAME() {
        return ANIMAL_NAME;
    }

    public void setANIMAL_NAME(String ANIMAL_NAME) {
        this.ANIMAL_NAME = ANIMAL_NAME;
    }

    public String getANIMAL_TYPE() {
        return ANIMAL_TYPE;
    }

    public void setANIMAL_TYPE(String ANIMAL_TYPE) {
        this.ANIMAL_TYPE = ANIMAL_TYPE;
    }

    public int getANIMAL_AGE() {
        return ANIMAL_AGE;
    }

    public void setANIMAL_AGE(int ANIMAL_AGE) {
        this.ANIMAL_AGE = ANIMAL_AGE;
    }

    public int getANIMAL_WEIGHT() {
        return ANIMAL_WEIGHT;
    }

    public void setANIMAL_WEIGHT(int ANIMAL_WEIGHT) {
        this.ANIMAL_WEIGHT = ANIMAL_WEIGHT;
    }

    public int getANIMAL_IMAGE() {
        return ANIMAL_IMAGE;
    }

    public void setANIMAL_IMAGE(int ANIMAL_IMAGE) {
        this.ANIMAL_IMAGE = ANIMAL_IMAGE;
    }

    public String getKIWI_TIMESTAMP() {
        return KIWI_TIMESTAMP;
    }

    public void setKIWI_TIMESTAMP(String KIWI_TIMESTAMP) {
        this.KIWI_TIMESTAMP = KIWI_TIMESTAMP;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "ANIMAL_ID=" + ANIMAL_ID +
                ", ANIMAL_NAME='" + ANIMAL_NAME + '\'' +
                ", ANIMAL_TYPE='" + ANIMAL_TYPE + '\'' +
                ", ANIMAL_AGE=" + ANIMAL_AGE +
                ", ANIMAL_WEIGHT=" + ANIMAL_WEIGHT +
                ", ANIMAL_IMAGE=" + ANIMAL_IMAGE +
                ", KIWI_TIMESTAMP='" + KIWI_TIMESTAMP + '\'' +
                '}';
    }
}
