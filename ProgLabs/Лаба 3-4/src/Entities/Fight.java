package Entities;

import Enums.Emotion;
import Enums.Thing;
import Exceptions.NoClothesException;

public class Fight {

    public void kick(Creatures c1, Creatures c2){
        String var1 = c1.getName();
        String var2 = c2.getName();
        System.out.println(var1 + " дал пинка " + var2);
        c1.setEmotion(Emotion.HAPPY);
        c2.setEmotion(Emotion.ANGRY);
        c2.setMood((int)(c2.getMood() * 0.6));



    }
    public void spit(Creatures c1, Creatures c2){
        String var1 = c1.getName();
        String var2 = c2.getName();
        System.out.println(var1 + " плюет на " + var2);
        c1.setEmotion(Emotion.HAPPY);
        c2.setEmotion(Emotion.ANGRY);
        c2.setMood((int)(c2.getMood() * 0.5));

    }
    public void spitOn(Creatures c1, Creatures c2) throws NoClothesException {
        if (c2.getClothes() == null || c2.getClothes().isEmpty()){
            throw new NoClothesException("Нет одежды, не на что плевать");
        }
        String var1 = c1.getName();
        String var2 = c2.getName();
        System.out.println(var1 + " плюет в " + var2 + " на " + c2.getClothes());
        c1.setEmotion(Emotion.HAPPY);
        c2.setEmotion(Emotion.ANGRY);
        c2.setMood((int)(c2.getMood() * 0.5));

    }
    public void throwSmth(Creatures c1, Thing thing){
        String var1 = c1.getName();
        String var2;
        switch (thing){
            case ROCK -> var2 = "Камень";
            case STICK -> var2 = "Палку";
            case CAMERA -> var2 = "Фотоаппарат";
            case POSTER -> var2 = "Плакат";
            default -> var2 = "Ничего";
        }
        System.out.println(var1 + " бросает " + var2);
    }
    public void throwSmth(Creatures c1, Creatures c2, Thing thing){
        String var1 = c1.getName();
        String var2 = c2.getName();
        String var3;
        switch (thing){
            case ROCK -> var3 = "Камень";
            case STICK -> var3 = "Палку";
            case CAMERA -> var3 = "Фотоаппарат";
            case POSTER -> var3 = "Плакат";
            default -> var3 = "Ничего";
        }
        System.out.println(var1 + " бросает в" + var2 + " " + var3);
        c1.setEmotion(Emotion.HAPPY);
        c2.setEmotion(Emotion.ANGRY);
        c2.setMood((int)(c2.getMood() * 0.7));
    }
    public void hit(Creatures c1, Creatures c2){
        String var1 = c1.getName();
        String var2 = c2.getName();
        System.out.println(var1 + " ударил " + var2);
        c1.setEmotion(Emotion.HAPPY);
        c2.setEmotion(Emotion.ANGRY);
        c2.setMood((int)(c2.getMood() * 0.7));

    }


}
