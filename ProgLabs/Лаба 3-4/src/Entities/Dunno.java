package Entities;

import java.util.Objects;

public class Dunno extends Mites {
    public Dunno(String name){
        super(name);

    }
    @Override
    public String toString() {
        return "Dunno{"
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
        Dunno m = (Dunno) obj;
        return m.name.equals(name) && m.indexOfHappiness == indexOfHappiness && m.vision == vision;

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vision, indexOfHappiness);
    }



}
