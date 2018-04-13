package com.hormiga6.javapractice.accesscontrol.api;

import com.hormiga6.javapractice.accesscontrol.impl.Accessor;

public class Item {
    private int value;

    static {
        Accessor.setDefault(new AccessorImpl());
    }

    Item(){
    }

    public void setValue(int newValue){
        value = newValue;
    }

    public int getValue(){
        return value;
    }
}
