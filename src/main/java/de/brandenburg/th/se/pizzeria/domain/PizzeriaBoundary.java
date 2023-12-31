package de.brandenburg.th.se.pizzeria.domain;

import java.util.Set;

/**
 * Created by konrad.eichstaedt@gmx.de on 30.12.23.
 */
public interface PizzeriaBoundary {
  void erstelleSpeisekarte(String name);
  Set<Speisekarte> getSpeisekarten();
}
