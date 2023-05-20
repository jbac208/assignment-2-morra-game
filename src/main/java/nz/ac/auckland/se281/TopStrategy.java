package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TopStrategy implements Strategy {

  private ArrayList<Integer> playerFingersArrayList;

  public TopStrategy(int roundCount, ArrayList<Integer> playerFingersArrayList) {
    this.playerFingersArrayList = playerFingersArrayList;
  }

  @Override
  public int chooseFingers() {
    return Utils.getRandomNumber(1, 5);
  }

  @Override
  public int chooseSum(int fingers) {
    int mostFreqFingerVal = findMostFreqFingerVal();
    return fingers + mostFreqFingerVal; // Return the sum of AI's fingers and the average
  }

  private int findMostFreqFingerVal() {
    // Create a HashMap to store the frequency of each integer
    Map<Integer, Integer> frequencyMap = new HashMap<>();

    // Iterate over the numbers and count the frequency of each integer
    for (Integer num : playerFingersArrayList) {
      if (frequencyMap.containsKey(num)) {
        frequencyMap.put(num, frequencyMap.get(num) + 1);
      } else {
        frequencyMap.put(num, 1);
      }
    }

    // Find the most common integer
    int mostCommonInteger = 0;
    int maxFrequency = 0;

    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
      if (entry.getValue() > maxFrequency) {
        mostCommonInteger = entry.getKey();
        maxFrequency = entry.getValue();
      }
    }
    return mostCommonInteger;
  }
}
