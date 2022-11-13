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
public class GameController implements Initializable {

  final private static String PROPERTIES_FILE_PATH_MONK = "monk.properties";
  final private static String PROPERTIES_FILE_PATH_WARIOR = "warior.properties";

  private List<String> characterProperties = List.of(PROPERTIES_FILE_PATH_MONK, PROPERTIES_FILE_PATH_WARIOR);


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

    if (selectCharacter.getName().contains("monk")) {
      path = PROPERTIES_FILE_PATH_MONK;
    } else {
      path = PROPERTIES_FILE_PATH_WARIOR;
    }
    try (OutputStream outputStream = new FileOutputStream(path)) {

      // set some values
      properties.setProperty("dextertity", String.valueOf(selectCharacter.getDextertity()));
      // store the values
      properties.store(outputStream, null);

    } catch (IOException e) {
      e.printStackTrace();
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

    if (selectCharacter.getName().contains("monk")) {
      path = PROPERTIES_FILE_PATH_MONK;
    } else {
      path = PROPERTIES_FILE_PATH_WARIOR;
    }

    try (InputStream inputStream = new FileInputStream(path)) {
      properties.load(inputStream);
      String dex = properties.getProperty("dextertity");

      if(path.contains("warior")) {
        profileImage.setImage(new Image("warior.jpg"));
      }else{
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
//    warior.setDextertity(10);
//    monk.setDextertity(50);

    for(String ch: characterProperties){

      try (InputStream inputStream = new FileInputStream(ch)) {
        properties.load(inputStream);
        String dex = properties.getProperty("dextertity");

        if(ch.contains("warior")) {
          warior.setDextertity(Integer.parseInt(dex));
        }else{
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

    if (selectCharacter.getName().contains("monk")) {
      path = PROPERTIES_FILE_PATH_MONK;
    } else {
      path = PROPERTIES_FILE_PATH_WARIOR;
    }

    try (InputStream inputStream = new FileInputStream(path)) {
      properties.load(inputStream);
      String dex = properties.getProperty("dextertity");

      if(path.contains("warior")) {
        profileImage.setImage(new Image("warior.jpg"));
      }else{
        profileImage.setImage(new Image("monk.jpg"));
      }
      dextertity.setText(dex);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
