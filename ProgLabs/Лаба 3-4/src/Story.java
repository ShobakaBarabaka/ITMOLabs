import Entities.*;
import Enums.Emotion;
import Enums.MoonPhase;
import Enums.Thing;
import Enums.Weather;
import Exceptions.NoClothesException;

public class Story {
    public static void main(String[] args) {
        Dunno d1 = new Dunno("Незнайка");
        Miga m1 = new Miga("Мига");
        Advertiser r1 = new Advertiser("Рекламщица");
        r1.jump(r1, 3);
        r1.aimTarget(d1);
        r1.takeAPhoto(d1);
        m1.setEmotion(Emotion.ANGRY);
        m1.getEmotion();
        m1.jump(m1, d1);
        Fight f = new Fight();
        f.throwSmth(m1, Thing.POSTER);
        m1.jump(m1, r1);
        f.kick(m1, r1);
        f.kick(r1, m1);
        f.hit(r1,m1);
        m1.setClothes("Пиджак");
        try {
            f.spitOn(r1, m1);
        } catch (NoClothesException e){
            System.out.println(e.getMessage());
        }


        Environment en = new Environment(MoonPhase.ECLIPSE, Weather.CLOUDY);
        Rocket r = new Rocket();
        r.newPassenger(m1);
        r.newPassenger(d1);
        r.captain();
        r.fly();
        Party p = new Party();
        p.dance(m1);
        p.dance(d1);
        p.start(m1,d1,r1);


    }
}