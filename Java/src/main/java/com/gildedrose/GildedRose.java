package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        for(Item item : items) {
            switch(item.name) {
                case "Sulfuras":
                    break;
                case "Backstage passes":
                    item = new BackstagePasses(item.name, item.sellIn, item.quality);
                    break;
                case "Aged Brie":
                    item = new AgedBrie(item.name, item.sellIn, item.quality);
                    break;
                case "Conjured":
                    item = new Conjured(item.name, item.sellIn, item.quality);
                    break;
                default:
                    item = new Normal(item.name, item.sellIn, item.quality);
                    break;

            }
        }
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            items[i].tick();
        }
    }

}