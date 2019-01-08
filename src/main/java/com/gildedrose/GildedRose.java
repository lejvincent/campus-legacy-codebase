package com.gildedrose;

public class GildedRose {
    Item[] items;
    String reports;
    org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GildedRose.class);

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            reports= reports + "START -> Name = " + item.name + ", SellIn = " + item.sellIn + ", Quality = " + item.quality;
            if (item.name.equals("Aged Brie")) {
                item = this.isAgedBrie(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item = this.isTAFKAL80ETCconcert(item);
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                return;
            } else if (item.name.startsWith("Conjured")) {
                item = this.isConjured(item);
            } else {
                item = this.isAnnoying(item);
            }
            reports = reports + "END -> Name = " + item.name + ", SellIn = " + item.sellIn + ", Quality = " + item.quality;
        }
        logger.debug("Reports : " + reports);
    }

    public Item[] getItems() {
        return items;
    }

    public Item isAnnoying(Item item) {
        reports = reports + "is Annoying";
        item.sellIn = item.sellIn - 1;

        if (item.quality < 50 && item.sellIn >= 0) {
            item.quality = item.quality + 1;
        } else if (item.quality > 0 && item.sellIn < 0) {
            if (item.quality == 1) {
                item.quality = item.quality - 1;
            } else {
                item.quality = item.quality - 2;
            }
        }
        return item;
    }

    public Item isAgedBrie(Item item) {
        reports = reports + "is Aged Brie";
        item.sellIn = item.sellIn - 1;

        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        return item;
    }

    public Item isTAFKAL80ETCconcert(Item item) {
        reports = reports + "is TAFKAL80ETC Concert";
        item.sellIn = item.sellIn - 1;

        if (item.quality < 50 && item.sellIn < 11 && item.sellIn > 5) {
            if (item.quality == 49) {
                item.quality = item.quality + 1;
            } else {
                item.quality = item.quality + 2;
            }
        } else if (item.quality < 50 && item.sellIn < 6 && item.sellIn > 0) {
            if (item.quality == 49) {
                item.quality = item.quality + 1;
            } else {
                item.quality = item.quality + 3;
            }
        } else if (item.quality < 50 && item.sellIn == 0) {
            item.quality = 0;
        } else if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        return item;
    }

    public Item isConjured(Item item) {
        reports = reports + "is Conjured";
        item.sellIn = item.sellIn - 1;

        if (item.quality == 1) {
            item.quality = item.quality - 1;
        } else if (item.quality > 0 && item.sellIn < 0) {
            item.quality = item.quality - 2;
        } else if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        return item;
    }

}