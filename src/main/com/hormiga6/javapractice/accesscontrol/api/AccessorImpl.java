package com.hormiga6.javapractice.accesscontrol.api;

import com.hormiga6.javapractice.accesscontrol.api.Item;
import com.hormiga6.javapractice.accesscontrol.impl.Accessor;

final class AccessorImpl extends Accessor {
    @Override
    protected Item newItem() {
        return new Item();
    }
}
