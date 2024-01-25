package tic.tac.toe;

import java.awt.Dimension;
import java.awt.List;
import java.util.ArrayList;

public class GameCore {

    private int counter = 0;

    private Player player_1;
    private Player player_2;
    private static GameCore instance;
    private boolean GameOver = false;
    private Dimension AImove = new Dimension();

    private State win = State.empty;
    private State[][] board = new State[3][3];

    ArrayList<Observer> observers = new ArrayList<>();

    public State[][] getBoard() {
        return board;
    }

    private GameCore(Player player_11, Player player_22) {
        // set who starts and diff and playervs player or AI vs player and AI playing mode
        player_1 = player_11;
        player_2 = player_22;
        player_1.setChar(State.O);
        player_2.setChar(State.X);

        player_1.setTurn(true);
        player_2.setTurn(false);

        //def easy
        player_1.setMode(player_1.getChar(), Difficulty.hard);
        //agg
        // player_1.setMode(player_1.getChar());
        BoardInitialize();
        AIstarts();
    }

    public static GameCore getInstance(Player player_11, Player player_22) {
        if (instance == null) {
            instance = new GameCore(player_11, player_22);
        }
        return instance;

    }

    public void attachObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(win);
        }
    }

    private void BoardInitialize() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = State.empty;
            }
        }
    }

    public State[][] AIstarts() {
        if (player_1.isAI() && counter == 0) {

            AImove = player_1.AImove(board);
            if (AImove.height != -1) {
                board[AImove.height][AImove.width] = player_1.getChar();

                player_1.setTurn(false);
                player_2.setTurn(true);

                counter++;
            }
        }

        return board;
    }

    public void Click(int row, int col) {

        //System.out.print(player_2.isTurn());
        if (!GameOver) {
            if (player_1.isTurn()) {
                if (!player_1.isAI()) {
                    if (board[row][col] == State.empty) {
                        board[row][col] = player_1.getChar();

                        player_1.setTurn(false);
                        player_2.setTurn(true);

                        counter++;

                        win = player_1.CheckForWin(board);

                        if (player_2.isAI() && win == State.empty) {
                            AImove = player_2.AImove(board);
                            System.out.println(AImove);

                            if (AImove.height != -1) {
                                board[AImove.height][AImove.width] = player_2.getChar();

                                player_1.setTurn(true);
                                player_2.setTurn(false);

                                win = player_2.CheckForWin(board);
                                counter++;
                            }
                        }
                    }
                }

            } else if (player_2.isTurn()) {
                if (!player_2.isAI()) {
                    if (board[row][col] == State.empty) {
                        board[row][col] = player_2.getChar();

                        player_1.setTurn(true);
                        player_2.setTurn(false);

                        counter++;

                        win = player_2.CheckForWin(board);

                        if (player_1.isAI() && win == State.empty) {
                            AImove = player_1.AImove(board);
                            System.out.println(AImove);

                            if (AImove.height != -1) {
                                board[AImove.height][AImove.width] = player_1.getChar();

                                player_1.setTurn(false);
                                player_2.setTurn(true);

                                win = player_1.CheckForWin(board);
                                counter++;
                            }
                        }
                    }
                }

            }

            if (win != State.empty) {
                System.out.println(win + " won ");
                GameOver = true;
            }

            if (counter == 9 && win == State.empty) {
                System.out.println("Draw");
                GameOver = true;
            }
        }
        notifyObservers();
    }
}
