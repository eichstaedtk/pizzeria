package de.brandenburg.th.se.pizzeria.application;

import de.brandenburg.th.se.pizzeria.domain.Pizzeria;
import de.brandenburg.th.se.pizzeria.domain.PizzeriaBoundary;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
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

  private PizzeriaBoundary pizzeriaBoundary = new Pizzeria();

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
    buttonSpeisekarteerstellen.setActionCommand(SPEISEKARTE_ERSTELLEN_COMMAND);
    buttonSpeisekarteerstellen.addActionListener(action -> {
      speisekarteErstellenHandler(action);
    });
    add(buttonSpeisekarteerstellen);
  }

  private void speisekarteErstellenHandler(ActionEvent action) {
    logger.log(Level.INFO,"Get Action Button Event {0}",new Object[]{action});
    if(action.getActionCommand().equals(SPEISEKARTE_ERSTELLEN_COMMAND) && !textFieldSpeisekartenName.getText().isBlank()) {
      pizzeriaBoundary.erstelleSpeisekarte(textFieldSpeisekartenName.getText());
      labelSpeisekartenResult = new JLabel("Speisekarte erfolgreich erstellt");
    } else {
      labelSpeisekartenResult = new JLabel("Speisekarte nicht erfolgreich erstellt");
    }
    textFieldSpeisekartenName.setText("");
    add(labelSpeisekartenResult);
    updateUI();
  }
}
