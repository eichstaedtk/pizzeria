package de.brandenburg.th.se.pizzeria.domain;

import de.brandenburg.th.se.pizzeria.application.MainViewWindow;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by konrad.eichstaedt@gmx.de on 22.12.23.
 */
public class Pizzeria implements PizzeriaBoundary {

  private static final Logger logger = Logger.getLogger(Pizzeria.class.getName());
  private Set<Speisekarte> speisekarten = new HashSet<>();

  static MainViewWindow mainViewWindow;

  public void erstelleSpeisekarte(String name) {
      Speisekarte speisekarte = new Speisekarte(name);
      speisekarten.add(speisekarte);
  }
  public Set<Speisekarte> getSpeisekarten() {
    return speisekarten;
  }

  public static void main(String args[]) {
    logger.log(Level.INFO,"Die Pizzeria ist eroeffnet!");
    if(mainViewWindow == null) {
      mainViewWindow = new MainViewWindow();
    }
      mainViewWindow.openWindow(1024,768);
  }
}
