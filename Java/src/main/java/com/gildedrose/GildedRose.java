package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Boolean degradeQuality;
            Integer qualityFactor;
            Boolean degradeSellIn = true;
            Integer sellInFactor = 1;
            if(items[i].name.equals("Sulfuras")) {
                degradeSellIn = false;
                sellInFactor = 0;
            }
            adjustSellin(items[i], sellInFactor, degradeSellIn);
            switch (items[i].name) {
                case "Sulfuras":
                    degradeQuality = false;
                    qualityFactor = 0;
                    break;
                case "Backstage passes":
                    degradeQuality = false;
                    qualityFactor = 1;
                    if (items[i].sellIn < 11) {
                        degradeQuality = false;
                        qualityFactor = 2;
                    }

                    if (items[i].sellIn < 6) {
                        degradeQuality = false;
                        qualityFactor = 3;
                    }
                    if (items[i].sellIn < 0) {
                        degradeQuality = true;
                        qualityFactor = items[i].quality;
                    }
                    break;
                case "Aged Brie":
                    degradeQuality = false;
                    qualityFactor = 1;
                    break;
                case "Conjured":
                    degradeQuality = true;
                    qualityFactor = 2;
                    if (items[i].sellIn < 0) {
                        qualityFactor = 4;
                    }
                    break;
                default:
                    degradeQuality = true;
                    qualityFactor = 1;
                    if (items[i].sellIn < 0) {
                        qualityFactor = 2;
                    }
                    break;
            }
            adjustQuality(items[i], qualityFactor, degradeQuality);
        }
    }

    protected static void adjustQuality(Item item, Integer amount, Boolean degrade) {
        if (degrade) {
            item.quality = (item.quality - amount > 0) ? item.quality - amount : 0;
        } else {
            item.quality =  (item.quality + amount < 50) ? item.quality + amount : 50;
        }
    }

    protected static void adjustSellin(Item item, Integer amount, Boolean degrade) {
        if(degrade) {
            item.sellIn = item.sellIn - amount;
        } else {
            item.sellIn = item.sellIn + amount;
        }
    }
}