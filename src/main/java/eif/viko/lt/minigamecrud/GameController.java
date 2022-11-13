package eif.viko.lt.minigamecrud;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;


// Work with properties file
// https://tutoref.com/how-to-read-and-write-properties-file/
// https://mkyong.com/java/java-properties-file-examples/
public class GameController implements Initializable {

  final private static String PROPERTIES_FILE_PATH_MONK = "monk.properties";
  final private static String PROPERTIES_FILE_PATH_WARIOR = "warior.properties";

  private final List<String> characterProperties = List.of(PROPERTIES_FILE_PATH_MONK, PROPERTIES_FILE_PATH_WARIOR);


  Properties properties = new Properties();
  @FXML
  private ComboBox<Player> chnageHeroComboBox;
  Bank target = new Bank("SEB", "");

  Player selectCharacter;
  String path;
  @FXML
  private ImageView profileImage;
  @FXML
  private Label dextertity;

  @FXML
  private Label endurance;

  @FXML
  private Label faith;

  @FXML
  private Label intelligence;

  @FXML
  private Label strength;

  @FXML
  private Label vitality;

  @FXML
  void increaseDextertity(ActionEvent event) {
    selectCharacter.setDextertity(selectCharacter.getDextertity() + 1);
    dextertity.setText(String.valueOf(selectCharacter.getDextertity()));
    try (OutputStream output = new FileOutputStream(selectCharacter.getName() + ".properties")) {

      // set the properties value
      properties.setProperty("dextertity", String.valueOf(selectCharacter.getDextertity()));
      properties.store(output, null);

    } catch (IOException io) {
      io.printStackTrace();
    }

  }

  @FXML
  void increaseEndurance(ActionEvent event) {

  }

  @FXML
  void increaseFaith(ActionEvent event) {

  }

  @FXML
  void increaseIntelligence(ActionEvent event) {

  }

  @FXML
  void increaseStrength(ActionEvent event) {

  }

  @FXML
  void increaseVitality(ActionEvent event) {

  }

  @FXML
  void changeClass(ActionEvent event) {
    selectCharacter = chnageHeroComboBox.getSelectionModel().getSelectedItem();
    profileImage.setImage(new Image(selectCharacter.getName() + ".jpg"));

    try (InputStream inputStream = new FileInputStream(selectCharacter.getName() + ".properties")) {

      properties.load(inputStream);
      String dex = properties.getProperty("dextertity");

      if (selectCharacter.getName().contains("warior")) {
        profileImage.setImage(new Image("warior.jpg"));
      } else {
        profileImage.setImage(new Image("monk.jpg"));
      }
      dextertity.setText(dex);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    Player warior = new Player("warior", "");
    Player monk = new Player("monk", "");

    for (String ch : characterProperties) {

      try (InputStream inputStream = new FileInputStream(ch)) {
        properties.load(inputStream);
        String dex = properties.getProperty("dextertity");

        if (ch.contains("warior")) {
          warior.setDextertity(Integer.parseInt(dex));
        } else {
          monk.setDextertity(Integer.parseInt(dex));
        }

      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    chnageHeroComboBox.setValue(warior);
    selectCharacter = chnageHeroComboBox.getSelectionModel().getSelectedItem();
    chnageHeroComboBox.getItems().add(warior);
    chnageHeroComboBox.getItems().add(monk);

    // WARIOR PAGRINDINIS HEROJUS

    try (InputStream inputStream = new FileInputStream(PROPERTIES_FILE_PATH_WARIOR)) {
      properties.load(inputStream);
      String dex = properties.getProperty("dextertity");
      profileImage.setImage(new Image("warior.jpg"));
      dextertity.setText(dex);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
