package com.gildedrose;

/**
 * Created by alexnikolayevsky on 2/27/17.
 */
public class Normal extends Item {
    public Normal(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void tick() {
        this.sellIn -= 1;
        if(this.quality == 0) {
            return;
        }
        this.quality -= 1;
        this.quality = (this.sellIn < 0) ? this.quality - 1 : this.quality;
    }
}
