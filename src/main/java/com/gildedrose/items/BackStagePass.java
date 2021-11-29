package com.gildedrose.items;

import com.gildedrose.Item;

public class BackStagePass extends NormalItem {

    @Override
    public void updateItemQuality(Item item) {
        int backstageQualityValue = getQualityChange(item);
        if (backstageQualityValue > 0) {
            increaseQuality(item, backstageQualityValue);
        } else {
            decreaseQuality(item, item.quality);
        }
    }

    protected int getQualityChange(Item item) {
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        //Quality drops to 0 after the concert
        if (item.sellIn < 0) {
            return 0;
        } else if (item.sellIn <= 5) {
            return 3;
        } else if (item.sellIn <= 10) {
            return 2;
        }
        return 1;
    }

    private void increaseQuality(Item item, int qualityIncrease) {
        if (item.quality < 50) {
            item.quality = item.quality + qualityIncrease;
        }
        //The Quality of an item is never more than 50
        if (item.quality > 50) {
            item.quality = 50;
        }
    }
}
