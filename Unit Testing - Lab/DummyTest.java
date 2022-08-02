package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    private  static  final  int ALIVE_HEALTH = 10;
    private static final int DEAD_HEALTH = 0;
    private static final int EXPERIENCE = 30;

    private Dummy aliveDummy;
    private Dummy deadDummy;

    @Before
    public void setUp(){
        this.aliveDummy = new Dummy(ALIVE_HEALTH, EXPERIENCE);
        this.deadDummy = new Dummy(DEAD_HEALTH, EXPERIENCE);
    }

    @Test
    public void test_Dummy_LosesHealth_WhenAttacked(){
        int attackPoints = 1;

        aliveDummy.takeAttack(attackPoints);

        assertEquals(ALIVE_HEALTH - attackPoints, aliveDummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void test_DeadDummy_CannotBeAttacked(){
        int attackPoints = 1;

        deadDummy.takeAttack(attackPoints);
    }

    @Test
    public void test_DeadDummy_Gives_Experience(){
        int actual = deadDummy.giveExperience();

        assertEquals(EXPERIENCE, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void test_AliveDummy_CannotGive_Experience(){
        aliveDummy.giveExperience();
    }

}