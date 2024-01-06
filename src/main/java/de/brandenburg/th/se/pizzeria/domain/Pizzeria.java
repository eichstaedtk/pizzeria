package de.brandenburg.th.se.pizzeria.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by konrad.eichstaedt@gmx.de on 22.12.23.
 */
public class Pizzeria implements PizzeriaBoundary {

  private static final Logger logger = Logger.getLogger(Pizzeria.class.getName());
  private Set<Speisekarte> speisekarten = new HashSet<>();

  public void erstelleSpeisekarte(String name) {
      Speisekarte speisekarte = new Speisekarte(name);
      speisekarten.add(speisekarte);
      logger.log(Level.INFO,"Speisekarte erstellt {0}",new Object[]{speisekarten.size()});
  }
  public Set<Speisekarte> getSpeisekarten() {
    return speisekarten;
  }
}
