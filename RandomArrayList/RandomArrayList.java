package RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
        private Random random = new Random();
        public Object getRandomElement(){
            int index = this.random.nextInt(super.size());
            Object arrayElement = super.get(index);
            super.remove(index);
            return arrayElement;
        }
}
