package com.gildedrose;

public class GildedRose {
    Item[] items;
    String reports;
    org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GildedRose.class);

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        reports = " INIT -> " + items[0];
        for (Item item : items) {
            reports = reports + " START -> " + item.name + ", " + item.sellIn + ", " +  item.quality;
            System.out.println(item);
            this.isNotSulfuras(item);
        }
        reports = reports + " END -> " + items[0];
        logger.debug(reports);
    }

    private void isNotSulfuras(Item item) {

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            if (item.quality < 50) {
                this.isQualityLowerThanFifty(item);
            } else {
                item.sellIn = item.sellIn - 1;
            }
            item.sellIn = item.sellIn - 1;
        }
    }

    private void isQualityLowerThanFifty(Item item) {
        if (item.sellIn > 0) {
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                this.isBackstage(item);
            } else {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            }
        } else if (item.name.equals("Aged Brie")) {
            item.quality = item.quality + 2;
        } else {
            this.isSellInNegative(item);
        }
    }

    private void isBackstage(Item item) {
        if (item.sellIn < 11 && item.sellIn > 5) {
            this.isBetween5And11(item);
        } else if (item.sellIn < 6) {
            this.isBetween0And6(item);
        } else {
            item.quality = item.quality + 1;
        }
    }

    private void isBetween5And11(Item item) {
        if (item.quality == 49) {
            item.quality = item.quality + 1;
        } else {
            item.quality = item.quality + 2;
        }
    }

    private void isBetween0And6(Item item) {
        if (item.quality == 49) {
            item.quality = item.quality + 1;
        } else if (item.quality == 48) {
            item.quality = item.quality + 2;
        } else {
            item.quality = item.quality + 3;
        }
    }

    private void isSellInNegative(Item item) {
        if (item.name.startsWith("Conjured")) {
            item.quality = item.quality - 2;
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        } else {
            this.isNotConjuredOrBackstage(item);
        }
    }

    private void isNotConjuredOrBackstage(Item item) {
        if (item.quality == 1) {
            item.quality = item.quality - 1;
        } else {
            if (item.quality != 0) {
                item.quality = item.quality - 2;
            }
        }
    }

    public Item[] getItems() {
        return items;
    }
}