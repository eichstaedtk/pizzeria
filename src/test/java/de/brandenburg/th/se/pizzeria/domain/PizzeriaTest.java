package de.brandenburg.th.se.pizzeria.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import de.brandenburg.th.se.pizzeria.application.MainViewWindow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Created by konrad.eichstaedt@gmx.de on 22.12.23.
 */
public class PizzeriaTest {

  @Test
  void testPizzeriaStart() {

    Pizzeria pizzeria = new Pizzeria();

    assertNotNull(pizzeria);
  }

  @Test
  void speisekarteErstellen() {
    Pizzeria pizzeria = new Pizzeria();
    pizzeria.erstelleSpeisekarte("Winterkarte 2023");

    assertNotNull(pizzeria.getSpeisekarten());
  }
}
