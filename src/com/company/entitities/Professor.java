package com.company.entitities;

public class Professor extends Supervisor{

    public Professor() {
        //TODO add a dynamic way to set the middle point
        move(0,5);
    }

    @Override
    public double getAwareness() {
        return super.getAwareness()*1.75;
    }
}
