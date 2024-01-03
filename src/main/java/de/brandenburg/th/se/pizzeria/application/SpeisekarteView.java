package de.brandenburg.th.se.pizzeria.application;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Created by konrad.eichstaedt@gmx.de on 23.12.23.
 */
public class SpeisekarteView extends JPanel {

  private JLabel labelSpeisekartenName;

  private JTextField textFieldSpeisekartenName;

  private JButton buttonSpeisekarteerstellen;

  public SpeisekarteView() {
    addLabel();
    addTextFieldSpeisekartenname();
    addButtonSpeisekarteerstellen();
    setVisible(true);
  }

  private void addLabel(){
    labelSpeisekartenName = new JLabel("Geben Sie eine Namen für die Speisekarte an:");
    add(labelSpeisekartenName);
  }

  private void addTextFieldSpeisekartenname() {
    textFieldSpeisekartenName = new JTextField(20);
    add(textFieldSpeisekartenName);
  }

  private void addButtonSpeisekarteerstellen() {
    buttonSpeisekarteerstellen = new JButton("Speisekarte erstellen");
    buttonSpeisekarteerstellen.addActionListener(action -> {

    });
    add(buttonSpeisekarteerstellen);
  }
}
