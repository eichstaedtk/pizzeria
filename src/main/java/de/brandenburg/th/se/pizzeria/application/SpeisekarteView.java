package de.brandenburg.th.se.pizzeria.application;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Created by konrad.eichstaedt@gmx.de on 23.12.23.
 */
public class SpeisekarteView extends JPanel {
  public SpeisekarteView() {
    addLabel();
    setVisible(true);
  }

  private void addLabel(){
    JLabel label = new JLabel("Geben Sie den Namen an:");
    add(label);
  }
}
