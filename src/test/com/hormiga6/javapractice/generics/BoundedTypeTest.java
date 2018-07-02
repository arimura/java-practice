package com.hormiga6.javapractice.generics;

import org.junit.Test;
import org.omg.PortableInterceptor.HOLDING;

import java.util.ArrayList;
import java.util.List;

public class BoundedTypeTest {

    @Test(expected = ArrayStoreException.class)
    public void covariant(){
        //This can be compiled because array type is covariant
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in.";
    }

    @Test
    public void invariant(){
        //This can be compiled because generics is invariant
        //List<Object> ol = new ArrayList<Long>();
        //ol.add("hoge");
    }

    @Test
    public void boundedType(){
        //can use HogeImpl as generics parameter.
        Bar<HogeImpl> hogeImpleBar = new Bar<>();
        hogeImpleBar.fuga(new HogeImpl());
    }

    interface Hoge {
        void fuga();
    }

    static class HogeImpl implements Hoge{
        @Override
        public void fuga() {
            System.out.println("hoge impl");
        }
    }

    static class Foo {
        void handle(Hoge hoge){
        }
    }

    static class Bar <T extends Hoge>{
        void fuga(T hoge){
            hoge.fuga();
        }
    }
}
