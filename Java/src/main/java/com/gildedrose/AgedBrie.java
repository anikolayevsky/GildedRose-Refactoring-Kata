package com.gildedrose;

/**
 * Created by alexnikolayevsky on 2/27/17.
 */
public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void tick() {
        this.sellIn -= 1;
        this.quality += 1;
        if(this.quality > 50) {
            this.quality = 50;
        }
    }
}
