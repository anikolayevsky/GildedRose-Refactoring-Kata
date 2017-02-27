package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void testItem() {
        Item[] items = new Item[] { new Item("foo", 1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void testExponentialDegrading() {
        Item[] items = new Item[] { new Item("foo", -1, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testAgedBie() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 1), new Item("Aged Brie", 1, 50)  };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);

        assertEquals("Aged Brie", app.items[1].name);
        assertEquals(0, app.items[1].sellIn);
        assertEquals(50, app.items[1].quality);
    }

    @Test
    public void testSulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras", 0, 0), new Item("Sulfuras", 50, 50)  };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

        assertEquals("Sulfuras", app.items[0].name);
        assertEquals(50, app.items[1].sellIn);
        assertEquals(50, app.items[1].quality);
    }

    @Test
    public void testBackstagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes", 0, 5),
                new Item("Backstage passes", 10, 5),
                new Item("Backstage passes", 5, 5),
                new Item("Backstage passes", 12, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

        assertEquals("Backstage passes", app.items[1].name);
        assertEquals(9, app.items[1].sellIn);
        assertEquals(7, app.items[1].quality);

        assertEquals("Backstage passes", app.items[2].name);
        assertEquals(4, app.items[2].sellIn);
        assertEquals(8, app.items[2].quality);

        assertEquals("Backstage passes", app.items[3].name);
        assertEquals(11, app.items[3].sellIn);
        assertEquals(6, app.items[3].quality);
    }

    @Test
    public void testConjured() {
        Item[] items = new Item[] { new Item("Conjured", 0, 0), new Item("Conjured", 1, 0), new Item("Conjured", 0, 5), new Item("Conjured", 1, 3)  };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

        assertEquals("Conjured", app.items[1].name);
        assertEquals(0, app.items[1].sellIn);
        assertEquals(0, app.items[1].quality);

        assertEquals("Conjured", app.items[2].name);
        assertEquals(-1, app.items[2].sellIn);
        assertEquals(1, app.items[2].quality);

        assertEquals("Conjured", app.items[3].name);
        assertEquals(0, app.items[3].sellIn);
        assertEquals(1, app.items[3].quality);
    }

}
