package de.brandenburg.th.se.pizzeria.domain;

import java.util.UUID;

/**
 * Created by konrad.eichstaedt@gmx.de on 23.12.23.
 */
public class Pizza extends Gericht{

  public Pizza(String name) {
    this.id = UUID.nameUUIDFromBytes(name.getBytes()).toString();
    this.name = name;
  }
}
