package eif.viko.lt.minigamecrud;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public abstract class Actor {
  private String name;
  private String avatarURL = "";

  private int dextertity = 1;

  private int endurance = 1;

  private int faith = 1;

  private int intelligence = 1;

  private int strength = 1;

  private int vitality = 1;

  private int hp = 100;

  public Actor(String name, String avatarURL) {
    this.name = name;
    this.avatarURL = avatarURL;
    hp = vitality * 3;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAvatarURL() {
    return avatarURL;
  }

  public void setAvatarURL(String avatarURL) {
    this.avatarURL = avatarURL;
  }

  public int getDextertity() {
    return dextertity;
  }

  public void setDextertity(int dextertity) {
    this.dextertity = dextertity;
  }

  public int getEndurance() {
    return endurance;
  }

  public void setEndurance(int endurance) {
    this.endurance = endurance;
  }

  public int getFaith() {
    return faith;
  }

  public void setFaith(int faith) {
    this.faith = faith;
  }

  public int getIntelligence() {
    return intelligence;
  }

  public void setIntelligence(int intelligence) {
    this.intelligence = intelligence;
  }

  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public int getVitality() {
    return vitality;
  }

  public void setVitality(int vitality) {
    this.vitality = vitality;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }
}
