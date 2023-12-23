package de.brandenburg.th.se.pizzeria.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by konrad.eichstaedt@gmx.de on 22.12.23.
 */
public class Pizzeria {
  private Set<Speisekarte> speisekarten = new HashSet<>();
  public void erstelleSpeisekarte(String name) {
      Speisekarte speisekarte = new Speisekarte(name);
      speisekarten.add(speisekarte);
  }
  public Set<Speisekarte> getSpeisekarten() {
    return speisekarten;
  }
}
