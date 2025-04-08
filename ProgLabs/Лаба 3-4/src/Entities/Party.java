package Entities;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Party {
    public void start(Creatures ... c) throws IndexOutOfBoundsException {
        if (c.length > 0) {
            int[] eachHappiness = new int[c.length];
            for (int i = 0; i < c.length; i++) {
                eachHappiness[i] = c[i].getMood();
            }
            for (int m : eachHappiness) {
                if (m < 50) System.out.println("Есть несчастный человек, вечеринка не начнется");
                else System.out.println("Все счастливы, начинаем вечеринку");
            }
        }
        else throw new IndexOutOfBoundsException("Вечеринка не может начаться без людей");
    }
    public void drink(Creatures c) {
        c.setVision(c.getVision()*0.75);
        c.setMood((int)(c.getMood()*1.5));
        System.out.println(c.getName() + " выпил, зрение упало, настроение повысилось");
    }

    public void dance(Creatures c) {
        c.setMood((int)(c.getMood()*1.25));
        System.out.println(c.getName() + " потанцевал, настроение повысилось");
    }
}
