package Entities;

import Enums.Emotion;
import Interfaces.Jump;
import Interfaces.Talk;

import java.util.Objects;

public class MoonMans extends Creatures implements Talk, Jump {
    public MoonMans(String name){
        super(name);
    }

    @Override
    public void says(String s) {
        System.out.println(super.name + " говорит " + s);
    }

    @Override
    public void jump(Creatures c1, int x){
        String var1 = c1.getName();
        System.out.println(var1 + " отскочил на " + x + " шага");
    }
    @Override
    public void jump(Creatures c1, Creatures c2){
        String var1 = c1.getName();
        String var2 = c2.getName();
        System.out.println(var1 + " подскочил к " + var2);
    }
    @Override
    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }
    @Override
    public void getEmotion() {
        String var1;
        switch (emotion) {
            case ANGRY -> var1 = " Вышел из себя";
            case HAPPY -> var1 = " Радуется";
            case TIRED -> var1 = " Устал";
            case AFRAID -> var1 = " Испугался";
            case CONFUSED -> var1 = " Растерялся";
            default -> var1 = " Безэмоционален";
        }
        System.out.println(this.name+ var1);
    }

    double vision;
    @Override
    public void setVision(Environment environment){
        double fluentVision = Math.random();
        double moonBuff = 1.5;
        final double fullMoonVision = 1;
        final double crescentMoonVision = 0.6;
        final double eclipseMoonVision = 0.1;
        switch (environment.phase()) {
            case FULL -> this.vision = fluentVision * moonBuff * fullMoonVision;
            case ECLIPSE -> this.vision = fluentVision * moonBuff * crescentMoonVision;
            case CRESCENT -> this.vision = fluentVision * moonBuff * eclipseMoonVision;
        }
    }
    @Override
    public void setVision(double v){
        this.vision = v;
    }
    @Override
    public double getVision() {
        return this.vision;
    }

    int indexOfHappiness;
    @Override
    public void setMood(Environment e) {
        int happiness = (int)(Math.random() * 100);
        int var = happiness;
        switch (e.weather()) {
            case RAINY -> var = (int)(happiness*0.75);
            case SUNNY -> var = (int)(happiness*1.25);
            case CLOUDY -> var = (int)(happiness*0.9);
        }
        this.indexOfHappiness = Math.min(var, 100);
    }
    @Override
    public void setMood(int x){
        this.indexOfHappiness = Math.min(x, 100);

    }
    @Override
    public int getMood() {
        return this.indexOfHappiness;

    }
    @Override
    public void setClothes(String cl){
        this.clothes = cl;
    }
    @Override
    public String getClothes(){
        return this.clothes;
    }

    @Override
    public String toString() {
        return "MoonMans{"
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
        MoonMans m = (MoonMans) obj;
        return m.name.equals(name) && m.indexOfHappiness == indexOfHappiness && m.vision == vision;

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vision, indexOfHappiness);
    }



}
