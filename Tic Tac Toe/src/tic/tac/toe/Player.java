package tic.tac.toe;

import java.awt.Dimension;

public abstract class Player {

    protected Dimension move = new Dimension();

    protected Dimension up = new Dimension();
    protected Dimension down = new Dimension();
    protected Dimension right = new Dimension();
    protected Dimension left = new Dimension();

    protected boolean turn;
    protected boolean AI = true;

    protected State mode;
    protected State Char;

    private Difficulty difficulty;

    int min = 0;
    int max = 2;

    int randomHeight = min + (int) (Math.random() * ((max - min) + 1));
    int randomWidth = min + (int) (Math.random() * ((max - min) + 1));

    public State getChar() {
        return Char;
    }

    public boolean isTurn() {
        return turn;
    }

    public boolean isAI() {
        return true;
    }

    public void setChar(State Char) {
        this.Char = Char;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void setMode(State mode, Difficulty difficulty) {
        this.difficulty = difficulty;

        if (mode == this.Char) {
            this.mode = this.Char;
        } else {
            this.mode = mode;
        }
    }
    
    

    public State CheckForWin(State[][] board) {

        //Diagonal Check
        if (board[1][1] != State.empty) {
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                return this.Char;
            } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                return this.Char;
            }
        }

        // Rows and Cols check
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != State.empty) {
                if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                    return this.Char;
                }
            }

            if (board[0][i] != State.empty) {
                if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                    return this.Char;
                }
            }
        }

        return State.empty;
    }
    public abstract Dimension AImove(State[][] board);

}
