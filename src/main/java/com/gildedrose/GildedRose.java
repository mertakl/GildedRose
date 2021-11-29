package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : this.items) {
            ItemUpdater updater = ItemUpdaterFactory.createItem(item);
            updater.decreaseSellIn(item);
            updater.updateItemQuality(item);
        }
    }
}
