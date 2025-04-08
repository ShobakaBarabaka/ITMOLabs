package Entities;

import Exceptions.EmptyRocketException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Rocket {
    ArrayList<Creatures> passengers = new ArrayList<>();

    public void newPassenger(Creatures c){
        passengers.add(c);
        String name = c.getName();
        System.out.println(name + " теперь пассажир ракеты");
    }
    public void fly() throws EmptyRocketException {
        if (passengers.isEmpty()){
            throw new EmptyRocketException("Вы пытаетесь запустить пустую ракету");
        }
        System.out.println("Ракета на борту с:");
        this.passengers.forEach(passenger -> System.out.println(passenger.name));
        System.out.println("Взлетает");
    }

    public void dropOff(Creatures c) throws EmptyRocketException{
        if (!passengers.contains(c)){
            throw new EmptyRocketException("Вы пытаетесь высадить человека, которого нет в ракете");
        }
        passengers.remove(c);
        String name = c.getName();
        System.out.println(name + " высажен из ракеты");
    }
    private int indexOf(double[] array, double key){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) return i;
        }
        return -1;
    }

    public void captain() throws EmptyRocketException{
        if (this.passengers.isEmpty()){
            throw new EmptyRocketException("Ракета пуста, нельзя выбрать капитана");
        }
        int size = passengers.size();
        double[] visionLVLs = new double[size];
        this.passengers.forEach(p -> visionLVLs[passengers.indexOf(p)]= p.getVision());
        double BestVision = Arrays.stream(visionLVLs).max().getAsDouble();
        Creatures cap = passengers.get(indexOf(visionLVLs, BestVision));
        System.out.println(cap.getName() + " становится капитаном, у него лучшее зрение из команды " + BestVision);

    }

    @Override
    public String toString() {
        return "Rocket{"
                + "passengers = " + passengers.size()
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
        Rocket r = (Rocket) obj;
        return r.passengers == passengers;

    }

    @Override
    public int hashCode() {
        return Objects.hash(passengers);
    }


}
