package com.hormiga6.javapractice.accesscontrol.impl;

import com.hormiga6.javapractice.accesscontrol.api.Item;
import com.hormiga6.javapractice.accesscontrol.impl.Accessor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ItemUserTest {
    @Test
    public void createItem(){
        //can't create item. compile error
        //new Item();

        Item item = Accessor.getDefault().newItem();
        item.setValue(1);
        assertThat(item.getValue(), is(1));
    }
}
