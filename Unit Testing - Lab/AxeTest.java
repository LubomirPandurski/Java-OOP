package rpg_lab;

import org.junit.Assert;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class AxeTest {
    @Test
    public void test_AxeCreation_WillReturn_SameValues_AsCreated(){
        int expectedAttack = 13;
        int expectedDurability = 42;

        Axe axe = new Axe(13,42);

        assertEquals(expectedAttack, axe.getAttackPoints());
        assertEquals(expectedDurability, axe.getDurabilityPoints());
    }

    @Test
    public void test_AxeLoosesDurability_AfterAttacking(){
        int attack = 13;
        int durability = 42;

        Axe axe = new Axe(13,42);

        Dummy dummy = new Dummy(100, 200);

        axe.attack(dummy);

        assertEquals(durability - 1, axe.getDurabilityPoints());

    }

    @Test(expected = IllegalStateException.class)
    public void test_AxeAttack_WhenBroken_Fails(){
        int attack = 13;
        int durability = 0;

        Axe axe = new Axe(13,42);

        Dummy dummy = new Dummy(100, 200);

        assertEquals(0, axe.getDurabilityPoints());

        axe.attack(dummy);

    }

}