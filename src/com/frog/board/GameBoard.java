package com.frog.board;

import pieces.Guard;
import pieces.Leader;
import pieces.Piece;
import pieces.Team;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameBoard extends JFrame {
    ArrayList<Piece> pieces = new ArrayList<Piece>();

    final int cellSize = 100;

    public GameBoard() {
        this.setSize(600, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Graphics gr = this.getGraphics();
    }

    @Override
    public void paint(Graphics gr) {
        super.paint(gr);

        // Print board
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                GameCell cell = new GameCell(row, col, cellSize, gr);
                cell.render(gr);
            }
        }

        // Print Pieces
        Leader leaderYellow = new Leader(Team.YELLOW, 0, 4);
        pieces.add(leaderYellow);
        leaderYellow.render(gr);
        Leader leaderGreen = new Leader(Team.GREEN, 4, 0);
        pieces.add(leaderGreen);
        leaderGreen.render(gr);

        for (int i = 0; i < 4; i++) {
            Guard guardYellow = new Guard(Team.YELLOW, i, 0, i);
            pieces.add(guardYellow);
            guardYellow.render(gr);
            Guard guardGreen = new Guard(Team.GREEN, i, 4, i + 1);
            pieces.add(guardGreen);
            guardGreen.render(gr);
        }

        // Print center
        int x = 50 + 2 * 100 + 50 - 25;
        int y = x;
        gr.setColor(Color.gray);
        gr.fillOval(x, y, 50, 50);
    }

    public Piece getPiece(int row, int col) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getRow() == row && pieces.get(i).getCol() == col) {
                return pieces.get(i);
            }
        }
        return null;
    }

    public void Move(int fromRow, int fromCol, int toRow, int toCol, Direction dir) {
        Piece p = getPiece(fromRow, fromCol);

        int row = fromRow;

        int col = fromCol;

        // calculate nex coordinates


        // Move Piece
        int[] next = getNext(fromRow, fromCol, dir);
        p.setRow(next[0]);
        p.setCol(next[1]);
    }

    private int[] getNext(int row, int col, Direction dir) {
        int[] coordinates = new int[2];
        if (dir == Direction.UP || dir == Direction.UP_LEFT || dir == Direction.UP_RIGHT)
            coordinates[0] = row - 1;
        else if (dir == Direction.DOWN || dir == Direction.DOWN_LEFT || dir == Direction.RIGHT_DOWN) {
            coordinates[0] = row + 1;
        }


        if (dir == Direction.RIGHT || dir == Direction.RIGHT_DOWN || dir == Direction.UP_RIGHT) {
            coordinates[1] = col + 1;
        } else if (dir == Direction.LEFT || dir == Direction.DOWN_LEFT || dir == Direction.UP_LEFT) {
            coordinates[1] = col - 1;
        }
        return coordinates;
    }

}
