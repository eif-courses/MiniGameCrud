package eif.viko.lt.minigamecrud;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

  Player player = new Player("Batman", "");
  Player monk = new Player("Monk", "");
  Bank target = new Bank("SEB", "");
  Game game = new Game(target, player);

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
    if(profileImage.getImage().getUrl().contains("char2")){
      increaseDext(monk);
    }else{
      increaseDext(player);
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

      profileImage.setImage(new Image("char2.jpg"));
      monk.setDextertity(20);
      dextertity.setText(String.valueOf(monk.getDextertity()));
      

  }
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    profileImage.setImage(new Image("char.jpg"));
    dextertity.setText(String.valueOf(player.getDextertity()));

  }

  private void increaseDext(Player player){
    player.setDextertity(player.getDextertity() + 1);
    dextertity.setText(String.valueOf(player.getDextertity()));
  }


}
