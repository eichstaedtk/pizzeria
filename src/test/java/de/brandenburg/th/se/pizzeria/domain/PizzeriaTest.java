package de.brandenburg.th.se.pizzeria.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by konrad.eichstaedt@gmx.de on 22.12.23.
 */
public class PizzeriaTest {

  @Test
  void testPizzeriaStart() {

    Pizzeria pizzeria = new Pizzeria();

    Assertions.assertNotNull(pizzeria);

  }
}
