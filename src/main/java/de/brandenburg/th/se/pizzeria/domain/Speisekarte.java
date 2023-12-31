package de.brandenburg.th.se.pizzeria.domain;

import de.brandenburg.th.se.pizzeria.domain.Pizza.Groesse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by konrad.eichstaedt@gmx.de on 23.12.23.
 */
public class Speisekarte {

  private final String id;
  private final String name;
  private final LocalDateTime erstellDatum;

  private List<Gericht> gerichte = new ArrayList<>();
  public Speisekarte(String name) {
    this.id = UUID.nameUUIDFromBytes(name.getBytes()).toString();
    this.erstellDatum = LocalDateTime.now();
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

  public LocalDateTime getErstellDatum() {
    return erstellDatum;
  }

  public void addPizza(String name, Groesse groesse, double preis) {
     this.gerichte.add(new Pizza(name,groesse,preis));
  }

  public List<Gericht> getGerichte() {
    return gerichte;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Speisekarte that = (Speisekarte) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
