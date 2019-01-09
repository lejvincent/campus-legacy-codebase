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
}
