package nz.ac.auckland.se281;

public interface Strategy {
    void chooseFingers();
    void chooseSum();
    void play();
    int getFingers();
    int getSum();
}
