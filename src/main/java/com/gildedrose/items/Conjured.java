package com.gildedrose.items;

public class Conjured extends NormalItem {
    @Override
    protected int getQualityDecrease(int sellIn) {
        //"Conjured" items degrade in Quality twice as fast as normal items
        return 0 < sellIn ? 2 : 4;
    }
}
