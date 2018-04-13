package com.hormiga6.javapractice.accesscontrol.impl;

import com.hormiga6.javapractice.accesscontrol.api.Item;

public abstract class Accessor {
    private static volatile  Accessor DEFAULT;
    public static Accessor getDefault() {
        Accessor a = DEFAULT;
        if(a != null){
            return a;
        }
        try {
            //see static block in Item
            Class.forName(Item.class.getName(),true, Item.class.getClassLoader());
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return DEFAULT;
    }

    public static void setDefault(Accessor accessor) {
        if(DEFAULT != null){
            throw new IllegalStateException();
        }
        DEFAULT = accessor;
    }

    public Accessor(){
    }

    protected abstract Item newItem();
}
