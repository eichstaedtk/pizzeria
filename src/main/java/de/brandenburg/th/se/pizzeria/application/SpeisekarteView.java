package de.brandenburg.th.se.pizzeria.application;

import de.brandenburg.th.se.pizzeria.domain.Pizzeria;
import de.brandenburg.th.se.pizzeria.domain.PizzeriaBoundary;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

  private DefaultTableModel speisekartenModel = new DefaultTableModel();
  private JTable speisekarten;

  private PizzeriaBoundary pizzeriaBoundary = new Pizzeria();

  public SpeisekarteView() {
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
    labelSpeisekartenResult = new JLabel("");
    buttonSpeisekarteerstellen.setActionCommand(SPEISEKARTE_ERSTELLEN_COMMAND);
    buttonSpeisekarteerstellen.addActionListener(action -> speisekarteErstellenHandler(action));
    add(buttonSpeisekarteerstellen);
    add(labelSpeisekartenResult);
  }

  private void addSpeisekartenTabelle() {
    speisekartenModel.addColumn("ID");
    speisekartenModel.addColumn("Name");
    speisekartenModel.addColumn("ErstellDatum");
    speisekarten = new JTable(speisekartenModel);
    speisekarten.setVisible(true);
    speisekarten.setBounds(0,0,500,300);
    JScrollPane jScrollPane = new JScrollPane(speisekarten);
    add(jScrollPane);
  }

  private void speisekarteErstellenHandler(ActionEvent action) {
    logger.log(Level.INFO,"Get Action Button Event {0}",new Object[]{action});
    if(action.getActionCommand().equals(SPEISEKARTE_ERSTELLEN_COMMAND) && !textFieldSpeisekartenName.getText().isBlank()) {
      pizzeriaBoundary.erstelleSpeisekarte(textFieldSpeisekartenName.getText());
      labelSpeisekartenResult.setText("Speisekarte erfolgreich erstellt");
      speisekartenModel.setRowCount(0);
      pizzeriaBoundary.getSpeisekarten().forEach(sk ->
              speisekartenModel.insertRow(speisekartenModel.getRowCount(),new String[]{sk.getId(), sk.getName(),
                      DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss").format(sk.getErstellDatum())}));
      speisekarten.repaint();
    } else {
      labelSpeisekartenResult.setText("Speisekarte nicht erfolgreich erstellt");
    }
    textFieldSpeisekartenName.setText("");
    updateUI();
  }
}
