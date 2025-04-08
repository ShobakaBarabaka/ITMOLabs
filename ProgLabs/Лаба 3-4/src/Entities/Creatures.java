package Entities;

import Enums.Emotion;

abstract public class Creatures{
    String name;
    String clothes;
    Emotion emotion;
    public Creatures(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
    abstract void setMood(Environment environment);
    abstract void setMood(int x);
    abstract int getMood();
    abstract void setClothes(String cl);
    abstract String getClothes();
    abstract void setEmotion(Emotion emotion);
    abstract void getEmotion();
    abstract void setVision(Environment environment);
    abstract void setVision(double v);
    abstract double getVision();

}
