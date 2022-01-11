package sanctuary;

import java.util.ArrayList;

/**
 * Main Class.
 */

public class Driver {

  /** 
 * Main method.
 */
  public static void main(String[] args) {
    Monkey m = new Monkey("Mark", "Guereza", "Male", "Fruits", 9, "Large", 1, "Enclosure");
    Monkey m1 = new Monkey("Jill", "Guereza", "Female", "Eggs", 2, "Small", 2, "Isolation");
    Monkey m2 = new Monkey("Rock", "Drill", "Female", "Fruits", 20, "Large", 3, "Enclosure");
    Sanctuary s = new Sanctuary(0, 0);
    s.addMonkey(m);
    s.addMonkey(m1);
    s.addMonkey(m2);
    Enclosure e = new Enclosure(true, 2, 10, 1);
    e.addMonkeyInEnclosure(m);
    e.addMonkeyInEnclosure(m1);
   
    System.out.println("Sanctuary List");
    ArrayList<Monkey> q = s.printListSanctuary();
    for (int i = 0; i < q.size(); i++) {
      System.out.println(q.get(i).getDetails());
    }
    System.out.println("\n");
    System.out.println("Enclosure List");
    ArrayList<Monkey> x = e.printListEnclosure();
    for (int i = 0; i < x.size(); i++) {
      System.out.println("The monkey's name is:" + q.get(i).getName());
      System.out.println("The monkey's sex is:" + q.get(i).getSex());
      System.out.println("The monkey's Favorite Food is:" + q.get(i).getFavFood());
      
    }
  }
}