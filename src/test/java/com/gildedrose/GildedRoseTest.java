package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {

    @Test
    void agedBrieQualityIncreased() {
        Item[] items = new Item[]{new Item("Aged Brie", 20, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(11);
    }

    @Test
    void QualityDecreased() {
        Item[] items = new Item[]{new Item("Annoying Band", 20, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(9);
    }

    @Test
    void QualityShouldNotBeAboveFifty() {
        Item[] items = new Item[]{new Item("Aged Brie", 20, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void QualityShouldBeNeverLowerZero() {
        Item[] items = new Item[]{new Item("Annoying Band", 20, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void sulfuraSQualityStaysTheSame() {
        Item[] items = new Item[]{new Item("Sulfuras", 20, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void BackstageQualityIncreaseCorrectlyUnderEleven() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 9, 14)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(16);
    }

    @Test
    void BackstageQualityIncreaseCorrectlyUnderSix() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 14)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(17);


    }

    @Test
    void BackstageQualityIncreaseCorrectlyNeverAboveFifty() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(50);

    }

    @Test
    void BackstageQualityIncreaseCorrectlyAboveTen() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 48)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(49);

    }

    @Test
    void ConjuredItemsShouldDegradeInQualityTwiceAsFastAsNormalItems() {
        Item[] items = new Item[]{new Item("Conjured", 4, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(48);
    }

    @Test
    void AgingRedWineQualityDontChangeWhithSellInAboveZero() {
        Item[] items = new Item[]{new Item("Aging Red Wine", 4, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(20);
    }

    @Test
    void AgingRedWineQualityIncreaseCorrectlyUnderZeroAboveMinusHundred() {
        Item[] items = new Item[]{new Item("Aging Red Wine", -20, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(21);
    }

    @Test
    void AgingRedWineQualityDecreaseCorrectlyUnderMinusHundred() {
        Item[] items = new Item[]{new Item("Aging Red Wine", -120, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(19);
    }

    @Test
    void pleaseFixIt() {
        Item[] items = new Item[]{new Item("Funny Pony", 0, 15)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(14);
    }
}
