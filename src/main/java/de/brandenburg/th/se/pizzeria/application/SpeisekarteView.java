package de.brandenburg.th.se.pizzeria.application;

import de.brandenburg.th.se.pizzeria.domain.Pizzeria;
import de.brandenburg.th.se.pizzeria.domain.PizzeriaBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by konrad.eichstaedt@gmx.de on 23.12.23.
 */
public class SpeisekarteView extends JPanel {

  public static final String SPEISEKARTE_ERSTELLEN_COMMAND = "SpeisekarteErstellen";
  private Logger logger = Logger.getLogger(SpeisekarteView.class.getName());
  private JLabel labelSpeisekartenName;

  private JLabel labelSpeisekartenResult;

  private JTextField textFieldSpeisekartenName;

  private JButton buttonSpeisekarteerstellen;

  private GridLayout gridLayout = new GridLayout(0,3);

  private String[][] speisekartenTabelData = new String[][]{};

  private JTable speisekarten;

  private PizzeriaBoundary pizzeriaBoundary = new Pizzeria();

  public SpeisekarteView() {
    //setLayout(gridLayout);
    addLabelSpeisekartenname();
    addTextFieldSpeisekartenname();
    addButtonSpeisekarteerstellen();
    addSpeisekartenTabelle();
    setVisible(true);
  }

  private void addLabelSpeisekartenname(){
    labelSpeisekartenName = new JLabel("Geben Sie eine Namen für die Speisekarte an:");
    add(labelSpeisekartenName);
  }

  private void addTextFieldSpeisekartenname() {
    textFieldSpeisekartenName = new JTextField(20);
    add(textFieldSpeisekartenName);
  }

  private void addButtonSpeisekarteerstellen() {
    buttonSpeisekarteerstellen = new JButton("Speisekarte erstellen");
    buttonSpeisekarteerstellen.setActionCommand(SPEISEKARTE_ERSTELLEN_COMMAND);
    buttonSpeisekarteerstellen.addActionListener(action -> speisekarteErstellenHandler(action));
    add(buttonSpeisekarteerstellen);
  }

  private void addSpeisekartenTabelle() {
    String[] columnNames = { "ID", "Name", "Erstelldatum" };
    speisekarten = new JTable(speisekartenTabelData,columnNames);
    speisekarten.setVisible(true);
    add(speisekarten);
  }

  private void speisekarteErstellenHandler(ActionEvent action) {
    logger.log(Level.INFO,"Get Action Button Event {0}",new Object[]{action});
    if(action.getActionCommand().equals(SPEISEKARTE_ERSTELLEN_COMMAND) && !textFieldSpeisekartenName.getText().isBlank()) {
      pizzeriaBoundary.erstelleSpeisekarte(textFieldSpeisekartenName.getText());
      labelSpeisekartenResult = new JLabel("Speisekarte erfolgreich erstellt");
      speisekartenTabelData = pizzeriaBoundary.getSpeisekarten().stream().map(sk -> new String[]{sk.getId(),sk.getName(),
              DateTimeFormatter.ISO_DATE_TIME.format(sk.getErstellDatum())}).toArray(String[][]::new);
      speisekarten.repaint();
    } else {
      labelSpeisekartenResult = new JLabel("Speisekarte nicht erfolgreich erstellt");
    }
    textFieldSpeisekartenName.setText("");
    add(labelSpeisekartenResult);
    logger.log(Level.INFO,"Speisekarten number of {0}", speisekartenTabelData.length);
    updateUI();
  }
}
