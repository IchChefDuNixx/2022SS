package TheGoldenBucket;

public class Utilities {
    //private Food[] foods;

    static Food[] enlargeFoodArray(Food[] t){
        Food[] returnArray = new Food[t.length+1];
        int i=0;
        for(Food f : t){
            returnArray[i++]=f;
        }
        return returnArray;
    }

    static Drink[] enlargeDrinkArray(Drink[] t){
        Drink[] returnArray = new Drink[t.length+1];
        int i=0;
        for(Drink f : t){
            returnArray[i++]=f;
        }
        return returnArray;
    }

    static Order[] enlargeOrderArray(Order[] o){
        Order[] returnArray = new Order[o.length+1];
        int i=0;
        for(Order f : o){
            returnArray[i++]=f;
        }
        return returnArray;
    }
}
