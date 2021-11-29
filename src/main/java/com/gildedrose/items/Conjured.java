package com.gildedrose.items;

public class Conjured extends NormalItem {
    @Override
    protected int getQualityDecrease(int sellIn) {
        //"Conjured" items degrade in Quality twice as fast as normal items
        return sellIn < 0 ? 4 : 2;
    }
}
