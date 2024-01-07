package de.brandenburg.th.se.pizzeria.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by konrad.eichstaedt@gmx.de on 23.12.23.
 */
public class Pizza extends Gericht{
  public enum Groesse {KLEIN,MITTEL,GROSS}
  private Groesse groesse;
  private Set<Zutat> zutaten = new HashSet<>();
  public Pizza(String name, Groesse groesse, double preis) {
    this.id = UUID.nameUUIDFromBytes(name.getBytes()).toString();
    this.name = name;
    this.groesse = groesse;
    this.preis = preis;
  }

  public void zutatHinzufuegen(String name, double preis) {
    this.zutaten.add(new Zutat(name,preis));
  }

  public Groesse getGroesse() {
    return this.groesse;
  }

  public double getPreis(){
    return this.preis + zutaten.stream().map(Zutat::preis).reduce(Double::sum).orElse(0.0);
  }

}
