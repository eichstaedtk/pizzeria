package de.brandenburg.th.se.pizzeria.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by konrad.eichstaedt@gmx.de on 07.01.24.
 */
public class PizzaTest {

    @Test
    void testCreatePizza() {
        Pizza salami = new Pizza("PizzaSalami", Pizza.Groesse.KLEIN,12.0);
        salami.zutatHinzufuegen("Salami",2);
        salami.zutatHinzufuegen("Käse",1.55);

        assertNotNull(salami);
        assertNotNull(salami.getId());
        assertEquals(15.55,salami.getPreis());
        assertEquals(Pizza.Groesse.KLEIN,salami.getGroesse());
    }
}
