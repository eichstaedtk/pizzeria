package de.brandenburg.th.se.pizzeria.domain;

import java.util.UUID;

/**
 * Created by konrad.eichstaedt@gmx.de on 23.12.23.
 */
public class Speisekarte {

  private String id;
  private String name;
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
}
