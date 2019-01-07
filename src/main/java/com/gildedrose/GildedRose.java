package com.gildedrose;

public class GildedRose {
    Item[] items;
    org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GildedRose.class);

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            logger.debug("START ->" + " Name = " + items[i].name + ", SellIn = " + items[i].sellIn + ", Quality = " + items[i].quality);
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                logger.debug("Name is not 'Aged Brie' and not 'Backstage passes to a TAFKAL80ETC concert'");
                if (items[i].quality > 0) {
                    logger.debug("Quality is more than 0");
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        logger.debug("Name is not 'Sulfuras, Hand of Ragnaros'");
                        if (items[i].name.contains("Conjured")) {
                            logger.debug("Name contains 'Conjured'");
                            if (items[i].quality == 1) {
                                logger.debug("Item contains 'Conjured' and its quality is equals to 1. Actually = " + items[i].quality);
                                items[i].quality = items[i].quality - 1;
                                logger.debug("And quality lost 1 decrease to " + items[i].quality);
                            } else if (items[i].sellIn < 0) {
                                logger.debug("Item contains 'Conjured' and its quality is under to 0. Actually = " + items[i].quality);
                                items[i].quality = items[i].quality - 2;
                                logger.debug("And quality lost 2 and decrease to " + items[i].quality);
                            } else {
                                logger.debug("Item contains 'Conjured' and its quality is above to 1. Actually = " + items[i].quality);
                                items[i].quality = items[i].quality - 1;
                                logger.debug("And quality lost 1 decrease to " + items[i].quality);
                            }
                        } else {
                            logger.debug("Name don't contains 'Conjured'");
                            items[i].quality = items[i].quality - 1;
                            logger.debug("And quality lost 1 and decrease to " + items[i].quality);
                        }
                    }
                }
            } else {
                logger.debug("Is 'Aged Brie' or 'Backstage passes to a TAFKAL80ETC concert'");
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
            logger.debug("END ->" + " Name = " + items[i].name + ", SellIn = " + items[i].sellIn + ", Quality = " + items[i].quality);
        }
    }

    public Item[] getItems() {
        return items;
    }
}