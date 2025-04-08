package Entities;

import Interfaces.Camera;

import java.util.Objects;

public class Advertiser extends MoonMans implements Camera {
    public Advertiser(String name){
        super(name);

    }
    @Override
    public void aimTarget(Creatures c1){
        String var1 = c1.getName();
        System.out.println(this.name + " навела на " + var1 + " фотографический аппарат");
    }

    @Override
    public void takeAPhoto(Creatures c1) {
        String var1 = c1.getName();
        System.out.println(this.name + " сделала фото " + var1);
    }

    @Override
    public String toString() {
        return "Advertiser{"
                + "name='" + name + '\''
                + ", indexOfHappiness=" + indexOfHappiness
                + ", vision=" + vision
                + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Advertiser m = (Advertiser) obj;
        return m.name.equals(name) && m.indexOfHappiness == indexOfHappiness && m.vision == vision;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vision, indexOfHappiness);
    }

}
