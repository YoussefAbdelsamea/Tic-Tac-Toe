/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tic.tac.toe;

import java.awt.Dimension;

/**
 *
 * @author Lenovo
 */
public class Medium extends Player {

    @Override
    public Dimension AImove(State[][] board) {
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
