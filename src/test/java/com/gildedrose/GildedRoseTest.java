package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {

    @Test
    void agedBrieQualityIncreased (){
        Item[] items = new Item[] { new Item("Aged Brie", 20, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(11);
    }

    @Test
    void QualityDecreased (){
        Item[] items = new Item[] { new Item("Annoying Band", 20, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(9);
    }

    @Test
    void QualityShouldBeAboveFifty (){
        Item[] items = new Item[] { new Item("Aged Brie", 20, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void QualityShouldBeNeverLowerZero (){
        Item[] items = new Item[] { new Item("Annoying Band", 20, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }
}
