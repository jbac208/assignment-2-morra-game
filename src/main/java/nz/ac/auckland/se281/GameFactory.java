package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import java.util.ArrayList;

public class GameFactory {

  public static StratRunner createGame(
      Difficulty difficulty, int roundCount, ArrayList<Integer> playerFingersArrayList) {

    switch (difficulty) {
      case EASY:
        return new EasyStratRunner();

      case MEDIUM:
        return new MediumStratRunner(roundCount, playerFingersArrayList);

      case HARD:
        // todo
        return null;

      case MASTER:
        // todo
        return null;
    }
    return null;
  }
}
