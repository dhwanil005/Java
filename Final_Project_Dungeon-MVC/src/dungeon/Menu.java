package dungeon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * Menu for our dungeon game.
 */

public class Menu extends JMenuBar {
  private JCheckBoxMenuItem wrapOrNot;
  private JLabel rows;
  private JLabel columns;
  private JLabel numberOfMonsters;
  private JLabel treasureAndArrowAvailability;
  private JButton exit;
  private JButton restart;
  private JButton reset;

  /**
   * Constructor for our Menu Class.
   * 
   * @param fr the frame where menu will be there.
   */
  public Menu(JFrame fr) {
    JMenuBar menuBar;
    JMenu menu;

    menuBar = new JMenuBar();
    menu = new JMenu("Dungeon");
    menu.getAccessibleContext()
        .setAccessibleDescription("Menu Items to alter paramaters of Dungeon");
    menuBar.add(menu);
    wrapOrNot = new JCheckBoxMenuItem("Wrap Or Not?");
    menu.add(wrapOrNot);
    rows = new JLabel();
    columns = new JLabel();
    numberOfMonsters = new JLabel();
    treasureAndArrowAvailability = new JLabel();
    menu.add(rows);
    menu.add(columns);
    menu.add(numberOfMonsters);
    menu.add(treasureAndArrowAvailability);
    restart = new JButton("Restart,Different Parameters");
    menu.add(restart);
    reset = new JButton("Restart, same Parameters");
    menu.add(reset);
    exit = new JButton("Exit Game");
    menu.add(exit);
    fr.setJMenuBar(menuBar);

  }

  /**
   * Method for handling clicks over menu.
   * 
   * @param listener object of controller.
   * @param model    read only model object.
   * @param view     view of dungeon game.
   */
  public void addClickListener(DungeonControllerIntf listener, ReadOnlyDungeonIntf model,
      DungeonViewIntf view) {
    wrapOrNot.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        listener.gameRestart(model.getDungeonRows(), model.getDungeonColumns(),
            model.getDungeonInterConnectivity(), model.getDungeonTreasureAndArrowAvailability(),
            model.getDungeonWrapOrNot(), model.getDungeonNumberOfMonsters(), model.getPlayerName());
        view.refresh();
      }
    });
    exit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        listener.quit();
      }
    });
    reset.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        listener.resetGame();
        view.refresh();
      }
    });
    restart.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        listener.gameRestart(model.getDungeonRows(), model.getDungeonColumns(),
            model.getDungeonInterConnectivity(), model.getDungeonTreasureAndArrowAvailability(),
            model.getDungeonWrapOrNot(), model.getDungeonNumberOfMonsters(), model.getPlayerName());
        view.refresh();

      }
    });
    rows.setText("Rows:" + model.getDungeonRows());
    columns.setText("Columns:" + model.getDungeonColumns());
    numberOfMonsters.setText("Number Of Monsters:" + model.getDungeonNumberOfMonsters());
    treasureAndArrowAvailability.setText("Percentage of caves with treasure and arrows"
        + model.getDungeonTreasureAndArrowAvailability() + "%");

  }

}
