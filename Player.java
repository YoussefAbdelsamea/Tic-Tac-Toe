package tic.tac.toe;

import java.awt.Dimension;

public class Player {

    private Dimension move = new Dimension();

    private Dimension up = new Dimension();
    private Dimension down = new Dimension();
    private Dimension right = new Dimension();
    private Dimension left = new Dimension();

    private boolean turn;
    private boolean AI = false;

    private State mode;
    private State Char;

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
        return AI;
    }

    public void setChar(State Char) {
        this.Char = Char;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void setAI(boolean AI) {
        this.AI = AI;
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

    public Dimension AImove(State[][] board) {
        // I didn't have time to study classic AI and understanding a heuristic for tic tac toe game
        // so i developed conditions to make the move 
        move.height = -1;
        // 2 ally need 1 to win  => win
        // 2 enemy need 1 to win => defend
        if (this.difficulty != Difficulty.easy) {
            if (this.difficulty == Difficulty.hard) {
                //Diagonal
                //main Diagonal
                if (board[0][0] == board[1][1]) {
                    if (board[0][0] != State.empty && board[2][2] == State.empty) {
                        move.height = 2;
                        move.width = 2;

                        if (board[0][0] == this.mode) {
                            return move;
                        }
                    }
                }
                if (board[0][0] == board[2][2]) {
                    if (board[0][0] != State.empty && board[1][1] == State.empty) {
                        move.height = 1;
                        move.width = 1;

                        if (board[0][0] == this.mode) {
                            return move;
                        }
                    }
                }
                if (board[1][1] == board[2][2]) {
                    if (board[1][1] != State.empty && board[0][0] == State.empty) {
                        move.height = 0;
                        move.width = 0;

                        if (board[1][1] == this.mode) {
                            return move;
                        }
                    }
                }
                //secondary Diagonal 
                if (board[2][0] == board[1][1]) {
                    if (board[2][0] != State.empty && board[0][2] == State.empty) {
                        move.height = 0;
                        move.width = 2;

                        if (board[2][0] == this.mode) {
                            return move;
                        }
                    }
                }
                if (board[2][0] == board[0][2]) {
                    if (board[2][0] != State.empty && board[1][1] == State.empty) {
                        move.height = 1;
                        move.width = 1;

                        if (board[2][0] == this.mode) {
                            return move;
                        }
                    }
                }
                if (board[1][1] == board[0][2]) {
                    if (board[1][1] != State.empty && board[2][0] == State.empty) {
                        move.height = 2;
                        move.width = 0;

                        if (board[1][1] == this.mode) {
                            return move;
                        }
                    }
                }
                //Row                
                for (int i = 0; i < 3; i++) {
                    if (board[i][1] == board[i][2]) {
                        if (board[i][1] != State.empty && board[i][0] == State.empty) {
                            move.height = i;
                            move.width = 0;

                            if (board[i][1] == this.mode) {
                                return move;
                            }
                        }
                    }
                    if (board[i][0] == board[i][2]) {
                        if (board[i][0] != State.empty && board[i][1] == State.empty) {
                            move.height = i;
                            move.width = 1;

                            if (board[i][0] == this.mode) {
                                return move;
                            }
                        }
                    }
                    if (board[i][0] == board[i][1]) {
                        if (board[i][1] != State.empty && board[i][2] == State.empty) {
                            move.height = i;
                            move.width = 2;

                            if (board[i][1] == this.mode) {
                                return move;
                            }
                        }
                    }

                    //Col    
                    if (board[1][i] == board[2][i]) {
                        if (board[1][i] != State.empty && board[0][i] == State.empty) {
                            move.height = 0;
                            move.width = i;

                            if (board[1][i] == this.mode) {
                                return move;
                            }
                        }
                    }
                    if (board[0][i] == board[2][i]) {
                        if (board[0][i] != State.empty && board[1][i] == State.empty) {
                            move.height = 1;
                            move.width = i;

                            if (board[0][i] == this.mode) {
                                return move;
                            }
                        }
                    }
                    if (board[0][i] == board[1][i]) {
                        if (board[1][i] != State.empty && board[2][i] == State.empty) {
                            move.height = 2;
                            move.width = i;

                            if (board[1][i] == this.mode) {
                                return move;
                            }
                        }
                    }

                }
            }

            if (move.height != -1) {
                return move;
            }

            // 1 ally need 2 to win
            // 1 enemy need 2 to win
            for (int i = 0; i < 3; i++) {
                //Diagonal
                if (board[1][1] != State.empty) {
                    if (board[0][0] == State.empty) {
                        move.height = 0;
                        move.width = 0;

                        if (board[1][1] == this.mode) {
                            return move;
                        }
                    } else if (board[2][2] == State.empty) {
                        move.height = 2;
                        move.width = 2;

                        if (board[1][1] == this.mode) {
                            return move;
                        }
                    } else if (board[0][2] == State.empty) {
                        move.height = 0;
                        move.width = 2;

                        if (board[1][1] == this.mode) {
                            return move;
                        }
                    } else if (board[2][0] == State.empty) {
                        move.height = 2;
                        move.width = 0;

                        if (board[1][1] == this.mode) {
                            return move;
                        }
                    }
                } else {
                    if (board[0][0] != State.empty) {
                        move.height = 1;
                        move.width = 1;

                        if (board[0][0] == this.mode) {
                            return move;
                        }
                    } else if (board[2][2] != State.empty) {
                        move.height = 1;
                        move.width = 1;

                        if (board[2][2] == this.mode) {
                            return move;
                        }
                    } else if (board[0][2] != State.empty) {
                        move.height = 1;
                        move.width = 1;

                        if (board[0][2] == this.mode) {
                            return move;
                        }
                    } else if (board[2][0] != State.empty) {
                        move.height = 1;
                        move.width = 1;

                        if (board[2][0] == this.mode) {
                            return move;
                        }
                    }
                }
                //Row && Col
                // if the block is not empty check for up down right left blocks
                // so you can get 2 adjacent blocks for this player or to stop other player
                up.height = left.width = i - 1;
                down.height = right.width = i + 1;
                up.width = down.width = right.height = left.height = i;

                if (up.height < 0) {
                    up.height = i + 2;
                } else if (down.height > 2) {
                    down.height = i - 2;
                }

                if (right.width > 2) {
                    right.width = i - 2;
                } else if (left.width < 0) {
                    left.width = i + 2;
                }

                if (board[i][i] != State.empty) {
                    if (board[up.height][up.width] == State.empty) {
                        move.width = up.width;
                        move.height = up.height;

                        if (board[i][i] == this.mode) {
                            System.err.println(move);
                            return move;
                        }
                    } else if (board[down.height][down.width] == State.empty) {
                        move.width = down.width;
                        move.height = down.height;

                        if (board[i][i] == this.mode) {
                            return move;
                        }
                    } else if (board[right.height][right.width] == State.empty) {
                        move.width = right.width;
                        move.height = right.height;

                        if (board[i][i] == this.mode) {
                            return move;
                        }
                    } else if (board[left.height][left.width] == State.empty) {
                        move.width = left.width;
                        move.height = left.height;

                        if (board[i][i] == this.mode) {
                            return move;
                        }
                    }

                } else {
                    if (board[up.height][up.width] != State.empty) {
                        move.width = i;
                        move.height = i;

                        if (board[up.height][up.width] == this.mode) {
                            return move;
                        }
                    } else if (board[down.height][down.width] != State.empty) {
                        move.width = i;
                        move.height = i;

                        if (board[down.height][down.width] == this.mode) {
                            return move;
                        }
                    } else if (board[right.height][right.width] != State.empty) {
                        move.width = i;
                        move.height = i;

                        if (board[right.height][right.width] == this.mode) {
                            return move;
                        }
                    } else if (board[left.height][left.width] != State.empty) {
                        move.width = i;
                        move.height = i;

                        if (board[left.height][left.width] == this.mode) {
                            return move;
                        }
                    }
                }
            }

            if (move.height != -1) {
                return move;
            }
        }

        //Random
        while (true) {
            if (board[randomHeight][randomWidth] == State.empty) {
                move.height = randomHeight;
                move.width = randomWidth;

                return move;
            } else {
                randomHeight = min + (int) (Math.random() * ((max - min) + 1));
                randomWidth = min + (int) (Math.random() * ((max - min) + 1));
            }
        }
    }
}
