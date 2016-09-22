package problem4.factory;

import problem4.models.food.*;

public class FoodFactory {

    public static Food createFood(String str){

        switch (str.toLowerCase()){
            case "cram":
                return new Cram(2);
            case "lembas":
                return new Lembas(3);
            case "apple":
                return new Apple(1);
            case "melon":
                return new Melon(1);
            case "honeycake":
                return new HoneyCake(5);
            case "mushrooms":
                return new Mushrooms(-10);
            default:
                return new OtherFood(-1);
        }
    }
}
