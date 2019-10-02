package com.codility.lessons;

/**
 * com.codility.lessons.Dog
 */
public class Dog implements Animal {

    private int numberOfLegs = 5;

    @Override
    public double speed() {
        
        return 5;
    }

    @Override
    public double weight() {
        
        return 10;
    }

    /**
     * @return the numberOfLegs
     */
    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    /**
     * @param numberOfLegs the numberOfLegs to set
     */
    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }
}