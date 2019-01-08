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
            Anno(item, 1, item.quality - 1, item.quality - 2);
        }
        return item;
    }

    private void Anno(Item item, int i, int i2, int i3) {
        if (item.quality == i) {
            item.quality = i2;
        } else {
            item.quality = i3;
        }
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

        CM(item);
        return item;
    }

    private void CM(Item item) {
        if (item.quality < 50 && item.sellIn < 11 && item.sellIn > 5) {
            CM1(item, 2);
        } else if (item.quality < 50 && item.sellIn < 6 && item.sellIn > 0) {
            CM1(item, 3);
        } else if (item.quality < 50 && item.sellIn == 0) {
            item.quality = 0;
        } else if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void CM1(Item item, int i) {
        Anno(item, 49, item.quality + 1, item.quality + i);
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