package com.gildedrose;

public class GildedRose {
    Item[] items;
    String reports;
    org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GildedRose.class);

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            logger.debug("START ->" + " Name = " + items[i].name + ", SellIn = " + items[i].sellIn + ", Quality = " + items[i].quality);
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        if (items[i].name.startsWith("Conjured")) {
                            if (items[i].quality == 1) {
                                items[i].quality = items[i].quality - 1;
                            } else if (items[i].sellIn < 0 && items[i].quality != 0 && items[i].quality > 0) {
                                items[i].quality = items[i].quality - 2;
                            } else {
                                items[i].quality = items[i].quality - 1;
                            }
                        } else {
                            items[i].quality = items[i].quality - 1;
                        }
                    }
                }
            } else {
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

//    public void isAnnoying(Item item) {
//        reports = reports + "is Annoying <br />";
//        item.sellIn = item.sellIn - 1;
//
//        if (item.quality < 50 && item.sellIn >= 0) {
//            item.quality = item.quality + 1;
//        } else if (item.quality > 0 && item.sellIn < 0) {
//            if (item.quality == 1) {
//                item.quality = item.quality - 1;
//            } else {
//                item.quality = item.quality - 2;
//            }
//        }
//    }
//
//    public void isAgedBrie(Item item) {
//        reports = reports + "is Aged Brie <br />";
//        item.sellIn = item.sellIn - 1;
//
//        if (item.quality < 50) {
//            item.quality = item.quality + 1;
//        }
//    }
//
//    public void isTAFKAL80ETCconcert(Item item) {
//        reports = reports + "is TAFKAL80ETC Concert <br />";
//        item.sellIn = item.sellIn - 1;
//
//        if (item.quality < 50) {
//            if (item.sellIn < 11 && item.sellIn > 5) {
//                if (item.quality < 50) {
//                    if (item.quality == 49) {
//                        item.quality = item.quality + 1;
//                    } else {
//                        item.quality = item.quality + 2;
//                    }
//                }
//            } else if (item.sellIn < 6 && item.sellIn > 0) {
//                if (item.quality < 50) {
//                    if (item.quality == 49) {
//                        item.quality = item.quality + 1;
//                    } else {
//                        item.quality = item.quality + 3;
//                    }
//                }
//            } else if (item.sellIn == 0) {
//                item.quality = item.quality - item.quality;
//            } else {
//                if (item.quality < 50) {
//                    item.quality = item.quality + 1;
//                }
//            }
//        }
//        return this.items = item;
//    }
//
//    public void isConjured(Item item) {
//        reports = reports + "is Conjured <br />";
//        item.sellIn = item.sellIn - 1;
//
//        if (item.quality > 0) {
//            if (item.quality == 1) {
//                item.quality = item.quality - 1;
//            } else if (item.sellIn < 0 && item.quality > 0) {
//                item.quality = item.quality - 2;
//            } else {
//                item.quality = item.quality - 1;
//            }
//        }
//    }

}