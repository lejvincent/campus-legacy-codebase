package com.gildedrose;

public class GildedRose {
    Item[] items;
    String reports;
    org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GildedRose.class);

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        reports = reports + "Init : " + items[0] + "<br>";
        for (Item item : items) {
            reports = reports + "START ->" + " Name = " + item.name + ", SellIn = " + item.sellIn + ", Quality = " + item.quality + "<br>";
            if (item.name.equals("Aged Brie")) {
                this.isAgedBrie(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                this.isTAFKAL80ETCconcert(item);
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                return;
            } else if (item.name.startsWith("Conjured")) {
                this.isConjured(item);
            } else {
                this.isAnnoying(item);
            }
            reports = reports + "END ->" + " Name = " + item.name + ", SellIn = " + item.sellIn + ", Quality = " + item.quality + "<br>";
        }
    }

    public Item[] getItems() {
        return items;
    }

    public void isAnnoying(Item item) {
        reports = reports + "is Annoying <br>";
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
    }

    public void isAgedBrie(Item item) {
        reports = reports + "is Aged Brie <br>";
        item.sellIn = item.sellIn - 1;

        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    public void isTAFKAL80ETCconcert(Item item) {
        reports = reports + "is TAFKAL80ETC Concert <br>";
        item.sellIn = item.sellIn - 1;

        if (item.quality < 50) {
            if (item.sellIn < 11 && item.sellIn > 5) {
                if (item.quality < 50) {
                    if (item.quality == 49) {
                        item.quality = item.quality + 1;
                    } else {
                        item.quality = item.quality + 2;
                    }
                }
            } else if (item.sellIn < 6 && item.sellIn > 0) {
                if (item.quality < 50) {
                    if (item.quality == 49) {
                        item.quality = item.quality + 1;
                    } else {
                        item.quality = item.quality + 3;
                    }
                }
            } else if (item.sellIn == 0) {
                item.quality = item.quality - item.quality;
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    public void isConjured(Item item) {
        reports = reports + "is Conjured <br>";
        item.sellIn = item.sellIn - 1;

        if (item.quality > 0) {
            if (item.quality == 1) {
                item.quality = item.quality - 1;
            } else if (item.sellIn < 0 && item.quality != 0 && item.quality > 0) {
                item.quality = item.quality - 2;
            } else {
                item.quality = item.quality - 1;
            }
        }
    }

}