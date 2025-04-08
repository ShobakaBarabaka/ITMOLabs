package Entities;

import java.util.Objects;

public class Miga extends MoonMans {
    public Miga(String name){
        super(name);

    }

    @Override
    public String toString() {
        return "Miga{"
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
        Miga m = (Miga) obj;
        return m.name.equals(name) && m.indexOfHappiness == indexOfHappiness && m.vision == vision;

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vision, indexOfHappiness);
    }


}
