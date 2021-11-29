package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdater;

public class Sulfuras implements ItemUpdater {

    @Override
    public void updateItemQuality(Item item) {
        //"Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
        if (item.quality != 80) {
            item.quality = 80;
        }
    }

    @Override
    public void decreaseSellIn(Item item) {
        //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    }
}
