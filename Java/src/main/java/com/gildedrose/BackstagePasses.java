package com.gildedrose;

/**
 * Created by alexnikolayevsky on 2/27/17.
 */
public class BackstagePasses extends Item {
    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void tick() {
        this.sellIn -= 1;
        if(this.sellIn < 0) {
            this.quality = 0;
            return;
        }
        this.quality += 1;
        if (this.sellIn < 11) {
            this.quality += 1;
        }
        if (this.sellIn < 6) {
            this.quality += 1;
        }
    }
}
