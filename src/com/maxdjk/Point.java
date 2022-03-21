package com.maxdjk;

import java.util.Objects;

public class Point {

    //    ........       F I E L D S      ........

    private int x;
    private int y;


    //    ........       M E T H O D S      ........


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof  Point)) return false;

        var other = (Point) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
