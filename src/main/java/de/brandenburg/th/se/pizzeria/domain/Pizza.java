package de.brandenburg.th.se.pizzeria.domain;

import java.util.UUID;

/**
 * Created by konrad.eichstaedt@gmx.de on 23.12.23.
 */
public class Pizza extends Gericht{
  public enum Groesse {KLEIN,MITTEL,GROSS}
  private Groesse groesse;
  public Pizza(String name, Groesse groesse, double preis) {
    this.id = UUID.nameUUIDFromBytes(name.getBytes()).toString();
    this.name = name;
    this.groesse = groesse;
    this.preis = preis;
  }

  public Groesse getGroesse() {
    return this.groesse;
  }

}
