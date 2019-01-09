package com.gildedrose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GildedRose {
    final static Logger logger = LoggerFactory.getLogger(GildedRose.class);
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            this.increaseQuality(item);
        }
    }

    public void increaseQuality(Item item)
    {
       item.quality ++;
       item.sellIn --;
    }

    public Item[] getItems() {
        return items;
    }
}