package nz.ac.auckland.se281;

public class Game {
    private Strategy strategy;
    
    public Game(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void play() {
        strategy.play();
    }
}
