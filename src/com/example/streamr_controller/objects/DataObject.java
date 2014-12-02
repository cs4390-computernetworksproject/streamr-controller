package com.example.streamr_controller.objects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Base for all of our data objects.
 */
@SuppressWarnings("serial")
public abstract class DataObject implements Serializable {
    
    public abstract int getId();

    /**
     * Check if this DataObject exists in an ArrayList list.
     *
     * @param list The list to look through.
     * @return Whether or not this object is new to the list its being added to.
     */
    public boolean isNew(ArrayList <? extends DataObject > list) {
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                DataObject object = list.get(i);

                if (object.getId() == this.getId()) {
                    return false;
                }
            }
        }
        return true;
    }
}
