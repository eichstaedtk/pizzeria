package de.brandenburg.th.se.pizzeria.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by konrad.eichstaedt@gmx.de on 23.12.23.
 */
public class SpeisekarteTest {

  @Test
  void createSpeisekarte() {
    Speisekarte speisekarte = new Speisekarte();

    assertNotNull(speisekarte);
    assertNotNull(speisekarte.getId());
    assertNotNull(speisekarte.getName());
  }

  @Test
  void testAddGericht() {
    Speisekarte speisekarte = new Speisekarte();

    speisekarte.addGericht("PizzaSalami");

    assertNotNull(speisekarte.getGerichte());

    assertFalse(speisekarte.getGerichte().isEmpty());
  }
}
