package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    //Normal Item
    @Test
    void given_NormalItem_WithNameFoo_When_QualityIsUpdated_Then_ReturnSameName() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals("foo", gildedRose.items[0].name);
    }

    @Test
    void given_NormalItem_WithSellIn0_When_QualityIsUpdated_Then_DecreaseSellIn() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(-1, gildedRose.items[0].sellIn);
    }

    @Test
    void given_NormalItem_WithQuality0_When_QualityIsUpdated_Then_DoNothing() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    void given_NormalItem_WithQuality10AndSellIn1_When_QualityIsUpdated_Then_DecreaseQuality() {
        Item[] items = new Item[]{new Item("foo", 1, 10)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(9, gildedRose.items[0].quality);
    }

    @Test
    void given_NormalItem_WithQuality10AndSellIn0_When_QualityIsUpdated_then_decreaseQualityBy2() {
        Item[] items = new Item[]{new Item("foo", 0, 10)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(8, gildedRose.items[0].quality);
    }

    @Test
    void given_NormalItemWithNegativeQuality_When_QualityIsUpdated_Then_SetQualityTo0() {
        Item[] items = new Item[] { new Item("foo", 1, -3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    //Aged Brie Item
    @Test
    void given_AgedBrieItemWithSellIn10AndQuality0_When_QualityIsUpdated_Then_IncreaseQualityBy1() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 0)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(1, gildedRose.items[0].quality);
    }

    @Test
    void given_AgedBrieItemWithSellIn10AndQuality50_When_QualityIsUpdated_Then_DoNothing() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 50)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(50, gildedRose.items[0].quality);
    }

    // Backstage Passes Item
    @Test
    void given_BackstagePassesWithSellInAbove10_When_QualityIsUpdated_Then_IncreaseQualityBy1() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 20, 0)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(1, gildedRose.items[0].quality);
    }

    @Test
    void given_BackstagePassesWithSellIn10_When_QualityIsUpdated_Then_IncreaseQualityBy2() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(2, gildedRose.items[0].quality);
    }

    @Test
    void given_BackstagePassesWithSellIn2_When_QualityIsUpdated_Then_IncreaseQualityBy3() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 2, 0)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(3, gildedRose.items[0].quality);
    }

    @Test
    void given_BackstagePassesWithSellIn0AndQuality50_When_QualityIsUpdated_Then_QualityDropsTo0() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    void given_BackstagePassesWithQualityOf49_when_qualityIsUpdated_then_increaseQualityBy3ToMax50() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(50, gildedRose.items[0].quality);
    }

    // Sulfuras Item
    @Test
    void given_SulfurasItemWithQuality80_When_QualityIsUpdated_Then_QualityStaysSame() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(80, gildedRose.items[0].quality);
    }

    @Test
    void given_SulfurasItemWithSellIn5_When_QualityIsUpdated_Then_SellInStays5() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 50)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(5, gildedRose.items[0].sellIn);
    }

    // Conjured Item
    @Test
    void given_ConjuredItemWithQuality4_When_QualityIsUpdated_Then_DecreaseQualityBy2() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 5, 4)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(2, gildedRose.items[0].quality);
    }

    @Test
    void given_ConjuredItemWithNegativeSellIn_When_QualityIsUpdated_Then_DecreaseQualityBy4() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", -4, 4)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
}
