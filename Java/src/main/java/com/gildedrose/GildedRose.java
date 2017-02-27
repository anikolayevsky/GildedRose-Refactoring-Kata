package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            switch(items[i].name) {
                case "Sulfuras":
                    break;
                case "Backstage passes":
                    items[i] = new BackstagePasses(items[i].name, items[i].sellIn, items[i].quality);
                    break;
                case "Aged Brie":
                    items[i] = new AgedBrie(items[i].name, items[i].sellIn, items[i].quality);
                    break;
                case "Conjured":
                    items[i] = new Conjured(items[i].name, items[i].sellIn, items[i].quality);
                    break;
                default:
                    items[i] = new Normal(items[i].name, items[i].sellIn, items[i].quality);
                    break;

            }
            items[i].tick();
        }
    }

}