package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdater;

public class NormalItem implements ItemUpdater {

    @Override
    public void updateItemQuality(Item item) {
        decreaseQuality(item, getQualityDecrease(item.sellIn));
    }

    @Override
    public void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }

    protected int getQualityDecrease(int sellIn) {
        //İf sellin less than 0 than decrease 2 otherwise 1
        return sellIn < 0 ? 2 : 1;
    }

    protected void decreaseQuality(Item item, int qualityDecrease) {
        if (item.quality > 0) {
            item.quality = item.quality - qualityDecrease;
        }
        // Quality must not be negative
        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}
