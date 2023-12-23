package de.brandenburg.th.se.pizzeria.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by konrad.eichstaedt@gmx.de on 23.12.23.
 */
public class Speisekarte {

  private final String id;
  private final String name;

  private List<Gericht> gerichte = new ArrayList<>();
  public Speisekarte(String name) {
    this.id = UUID.nameUUIDFromBytes(name.getBytes()).toString();
    this.name = name;
  }

  public Speisekarte() {
    this("Standard");
  }

  public String getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void addPizza(String name) {
     this.gerichte.add(new Pizza(name));
  }

  public List<Gericht> getGerichte() {
    return gerichte;
  }
}
