package de.brandenburg.th.se.pizzeria.domain;

/**
 * Created by konrad.eichstaedt@gmx.de on 23.12.23.
 */
public abstract class Gericht {
  String id;
  String name;
  double preis;

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getPreis() {
    return preis;
  }
}
