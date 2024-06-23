package com.wordle.runner;

import java.util.Arrays;
import java.util.Random;
import java.time.LocalDate;


public class WordPicker {

  private static final String[] wordsArray = {
      "book", "fish", "tree", "milk", "cake", "home", "love", "hope", "star", "bird",
      "door", "frog", "gift", "hand", "lamp", "moon", "rain", "snow", "song", "wind",
      "bear", "boat", "fire", "girl", "hill", "king", "lion", "mask", "nest", "park",
      "rock", "ship", "tail", "wolf", "bell", "cake", "dark", "duck", "frog", "gold",
      "hair", "jump", "kite", "leaf", "milk", "note", "pear", "quiz", "ring", "sock",
      "tide", "unit", "vest", "wave", "yarn", "zone", "band", "coin", "deer", "echo",
      "fair", "goat", "hint", "iron", "joke", "kick", "luck", "mage", "nest", "open",
      "palm", "quiz", "rope", "soup", "tent", "urge", "vase", "wage", "yarn", "zinc",
      "arch", "bake", "cafe", "dove", "echo", "fame", "gaze", "hike", "idea", "jazz"
  };

  private static String dailyWord;
  private static LocalDate lastPickedDate;

  public String[] getWordsArray() {
    return wordsArray;
  }

  public void printWordsArray() {
    System.out.println(Arrays.toString(wordsArray));
  }

  public static String getRandomWord() {

    LocalDate today = LocalDate.now();

    // 자정이 지나면 새로운 단어를 선택
    if (dailyWord == null || lastPickedDate == null || !lastPickedDate.equals(today)) {
      Random random = new Random();
      int randomNumber = random.nextInt(wordsArray.length); // 배열 크기를 사용하여 안전하게 접근
      dailyWord = wordsArray[randomNumber];
      lastPickedDate = today;


    }
    return dailyWord;
  }
}
