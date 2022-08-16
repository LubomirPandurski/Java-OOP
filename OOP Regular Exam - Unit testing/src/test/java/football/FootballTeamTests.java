package football;

import org.junit.Assert;
import org.junit.Test;

public class FootballTeamTests {


   @Test
    public void test_if_footballer_is_added(){
       Footballer footballer = new Footballer("Gosho");
        FootballTeam footballTeam = new FootballTeam("FK", 1);
       footballTeam.addFootballer(footballer);
       Assert.assertEquals(1,footballTeam.getCount());
   }

   @Test(expected = IllegalArgumentException.class)
    public void test_if_footballers_is_full(){
       Footballer footballer = new Footballer("Gosho");
       FootballTeam footballTeam = new FootballTeam("FK", 0);
       footballTeam.addFootballer(footballer);
       Assert.assertEquals(0, footballTeam.getCount());
   }

     @Test
      public void test_removing_footballer(){
         Footballer footballer = new Footballer("Gosho");
         Footballer footballer1 = new Footballer("pesho");
         FootballTeam footballTeam = new FootballTeam("FK", 2);
         footballTeam.addFootballer(footballer);
         footballTeam.addFootballer(footballer1);
         footballTeam.removeFootballer("Gosho");
         Assert.assertEquals(1, footballTeam.getCount());
     }

     @Test(expected = IllegalArgumentException.class)
     public void test_if_footballer_is_in_list(){
       Footballer footballer = new Footballer("Gosho");
       Footballer footballer1 = new Footballer("pesho");
       FootballTeam footballTeam = new FootballTeam("FK", 1);
       footballTeam.addFootballer(footballer);
       footballTeam.removeFootballer("pesho");
   }

   @Test
    public void test_get_statiscits(){

   }
    @Test
    public void test_if_footballer_is_for_sale(){
        Footballer footballer = new Footballer("Gosho");
        FootballTeam footballTeam = new FootballTeam("FK", 2);
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale("Gosho");
        Assert.assertFalse(footballer.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_if_footballer_for_sale_is_not_in_list(){
        Footballer footballer = new Footballer("Gosho");
        FootballTeam footballTeam = new FootballTeam("FK", 2);
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale("pesho");
    }

    @Test(expected = NullPointerException.class)
    public void test_if_team_name_is_null(){
       FootballTeam footballTeam = new FootballTeam(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_if_vacant_positions_less_than_zero(){
       FootballTeam footballTeam = new FootballTeam("FK", -1);
    }
}
