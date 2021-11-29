package com.gildedrose;

import com.gildedrose.items.*;

public class ItemUpdaterFactory {
    public final static String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public final static String AGED_BRIE = "Aged Brie";
    public final static String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public final static String CONJURED_ITEM = "Conjured Mana Cake";

    public static ItemUpdater createItem(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                return new AgedBrie();
            case BACKSTAGE_PASSES:
                return new BackStagePass();
            case CONJURED_ITEM:
                return new Conjured();
            case SULFURAS:
                return new Sulfuras();
            default:
                return new NormalItem();
        }
    }
}
