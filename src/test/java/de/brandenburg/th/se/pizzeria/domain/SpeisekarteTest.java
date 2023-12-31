package de.brandenburg.th.se.pizzeria.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import de.brandenburg.th.se.pizzeria.domain.Pizza.Groesse;
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

    String pizzaSalami = "PizzaSalami";

    speisekarte.addPizza(pizzaSalami, Groesse.MITTEL, 12.95);

    assertNotNull(speisekarte.getGerichte());

    assertFalse(speisekarte.getGerichte().isEmpty());

    Pizza pizza = (Pizza) speisekarte.getGerichte().get(0);

    assertEquals(pizzaSalami, pizza.getName());

    assertEquals(Groesse.MITTEL, pizza.getGroesse());

    assertEquals(12.95,pizza.getPreis());
  }
}
