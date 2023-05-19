package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class GameFactory {

  public static StratRunner createGame(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyStratRunner();

      case MEDIUM:
        return new MediumStratRunner();

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
