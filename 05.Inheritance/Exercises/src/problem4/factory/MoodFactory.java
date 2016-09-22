package problem4.factory;

import problem4.models.mood.*;

public class MoodFactory {

    public static Mood create(int points){

        if (points < -5){
            return new Angry("Angry");
        }else if(points >= -5 && points < 0){
            return new Sad("Sad");
        }else if(points >= 0 && points < 15){
            return new Happy("Happy");
        }else{
            return new JavaScript("JavaScript");
        }
    }
}
