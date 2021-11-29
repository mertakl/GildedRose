package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie extends NormalItem {

    @Override
    public void updateItemQuality(Item item) {
        increaseQuality(item);
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        //The Quality of an item is never more than 50
        if (item.quality > 50) {
            item.quality = 50;
        }
    }
}
