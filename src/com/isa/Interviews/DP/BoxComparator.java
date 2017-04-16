package com.isa.Interviews.DP;

import java.util.Comparator;

/**
 * Created by isa on 2017-04-16.
 */
class Box{
    public int width;
    public int height;
    public int depth;
    public Box(int w, int h, int d) {
        width = w;
        height = h;
        depth = d;
    }

    public boolean canBeUnder(Box b) {
        if (width > b.width && height > b.height && depth > b.depth) {
            return true;
        }
        return false;
    }

    public boolean canBeAbove(Box b) {
        if (b == null) {
            return true;
        }
        if (width < b.width && height < b.height && depth < b.depth) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Box(" + width + "," + height + "," + depth + ")";
    }
}

public class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box x, Box y){
        return y.height - x.height;
    }
}