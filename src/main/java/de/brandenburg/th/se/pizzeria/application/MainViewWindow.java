package de.brandenburg.th.se.pizzeria.application;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 * Created by konrad.eichstaedt@gmx.de on 23.12.23.
 */
public class MainViewWindow extends JFrame{

  public static final String PIZZERIA_SOFTWARE_TITLE = "Pizzeria Software Version 0.1";

  public void openWindow(int width,int height) {
    setSize(width, height);
    setTitle(PIZZERIA_SOFTWARE_TITLE);
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        System.exit(0);
      }
    });
    setLayout(new GridLayout(0,3));
    addSpeisekarte();
    setVisible(true);
  }

  private void addSpeisekarte() {
    SpeisekarteView speisekarteView = new SpeisekarteView();
    add(speisekarteView);
  }
  }
