package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GildedRose {
    final static Logger logger = LoggerFactory.getLogger(GildedRose.class);
    Item[] items;
    String reports;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            reports = "START -> " + item.name + ", " + item.sellIn + ", " + item.quality;
            if (!item.name.equals("Sulfuras")) {
                isAnnoyingBandBecauseNotSulfurasBand(item);
            }
            reports = reports + "EXIT -> " + item.name + ", " + item.sellIn + ", " + item.quality;
            logger.debug(reports);
        }
    }

    public void isAnnoyingBandBecauseNotSulfurasBand(Item item) {
        if (!item.name.equals("Aged Brie") && !item.name.startsWith("Backstage passes") && !item.name.startsWith("Aging Red Wine")) {
            this.decreaseQuality(item);
        } else if (item.name.startsWith("Aging Red Wine")) {
            this.WineQuality(item);
        } else {
            this.increaseQuality(item);
        }
    }

    public void increaseQuality(Item item) {

        if (item.quality < 50) {
            backstageIsBetween48And50(item);
            WineQuality(item);
            if (!item.name.startsWith("Aging")) {
                item.quality++;
            }

        }
        item.sellIn--;
    }

    public void backstageIsBetween48And50(Item item) {
        if (item.name.startsWith("Backstage passes") && item.quality != 48 && item.quality != 49) {
            backstageQualityIncreased(item);
        } else if (item.name.startsWith("Backstage passes") && item.quality == 48 && item.sellIn < 10) {
            item.quality++;
        }
    }

    public void backstageQualityIncreased(Item item) {
        if (item.sellIn < 11 && item.sellIn > 5) {
            item.quality = item.quality + 1;
        } else if (item.sellIn < 6 && item.sellIn >= 0) {
            item.quality = item.quality + 2;
        }
    }

    public void WineQuality(Item item) {
        if (item.quality > 0) {
            if (item.sellIn < 0 && item.sellIn > -100 )
            {
                item.quality = item.quality + 1;
            }
            if (item.sellIn <= -100)
            {
                item.quality = item.quality - 1;
            }
        }
    }

    public void decreaseQuality(Item item) {
        if (item.quality > 0) {
            if (item.name.startsWith("Conjured")) {
                if (item.quality != 1) {
                    item.quality = item.quality -2;
                } else {
                    item.quality--;
                }
            } else {
                item.quality--;
            }
        }
        item.sellIn--;
    }

    public Item[] getItems() {
        return items;
    }
}