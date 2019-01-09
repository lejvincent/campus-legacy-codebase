package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void VerifyIfItemSellIndecreaseUnderZero() {
        Item[] items = new Item[] { new Item("Foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(-1);
    }

    @Test
    void VerifyIfQualityItemIsNeverNegative() {
        Item[] items = new Item[] { new Item("Foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void VerifyIfQualityItemIsNeverMoreFifty() {
        Item[] items = new Item[] { new Item("Foo", 14, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(48);
    }

    @Test
    void VerifyIfConjuredItemDecreaseRightWhenSellInIsPositive() {
        Item[] items = new Item[] { new Item("Conjured", 3, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(7);
    }

    @Test
    void VerifyIfConjuredItemDecreaseRightWhenSellInIsNegative() {
        Item[] items = new Item[] { new Item("Conjured", -1, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(-2);
        assertThat(app.items[0].quality).isEqualTo(6);
    }

    @Test
    void VerifyIfItemNameWithConjuredNotAtStartIsSkipped() {
        Item[] items = new Item[] { new Item("Foo Conjured", -1, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(6);
    }

    @Test
    void VerifyIfAgedBrieActuallyIncreasesInQualityTheOlderItGets() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(10);
    }

    @Test
    void VerifyIfBackstageQualityDecreaseCorrectlyDuringLastTenDays() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(10);
    }

    @Test
    void VerifyIfBackstageQualityDecreaseCorrectlyDuringLastFiveDays() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(11);
    }

    @Test
    void VerifyIfBackstageQualityEqualsToZeroWhenSellInIsOver() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void VerifyIfBackstageQualityUpCorrectlyWhenMoreThan10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(9);
    }

    @Test
    void VerifyIfAgingRedWineQualityNotChangeAboveZero() {
        Item[] items = new Item[] { new Item("Aging Red Wine", 15, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(8);
    }

    @Test
    void VerifyIfAgingRedWineGainQualityUnderZero() {
        Item[] items = new Item[] { new Item("Aging Red Wine", -5, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(9);
    }

    @Test
    void VerifyIfAgingRedWineGainQualityUnderMinus100() {
        Item[] items = new Item[] { new Item("Aging Red Wine", -120, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(7);
    }
}
