package com.shobakaBarabaka.collection;

import java.util.Objects;

public class Coordinates {
    /**
     * X  coordinate of Organization
     * X must be greater than -795
     */
    private long x;//Значение поля должно быть больше -795

    /**
     * Y coordinate of Organization
     * Y can't be null
     */
    private Long y; //Поле не может быть null



    /**
     * set X coordinate
     * @param x X coordinate
     */
    public void setX(long x) {
        if (x <= -795) throw new IllegalArgumentException("X must be > -795");
        this.x = x;
    }


    /**
     * set Y coordinate
     * @param y Y coordinate
     */
    public void setY(Long y) {
        if (y == null) throw new IllegalArgumentException("Y can't be null");
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * @return a string representation of the {@link Coordinates} object
     */
    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                "}";
    }
}
