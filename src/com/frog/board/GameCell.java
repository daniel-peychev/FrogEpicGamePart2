package com.frog.board;

import java.awt.*;

        public class GameCell {
            final int marginTop = 50;
            final int marginLeft = 50;
            private int row;
            private int column;
            private int size;
            Graphics gr;

            public GameCell(int row, int column, int size, Graphics gr){
                this.row = row;
                this.column = column;
                this.size = size;
                this.gr = gr;
                render(gr);
            }

            public void render(Graphics gr){
                // Cell position
                int renderRow = this.row * this.size + marginTop;
                int renderCol = this.column * this.size + marginLeft;

                // Cell color

                if (row == 0 && (column == 0 || column == 4) ||
                        row == 4 && (column == 1 || column == 3)) {
                    gr.setColor(Color.red);
                } else if (row == 0 && (column == 1 || column == 3) ||
                        row == 4 && (column == 0 || column == 4)) {
                    gr.setColor(Color.black);
                } else if ((row == 1 || row == 3) && column != 2) {
                    gr.setColor(Color.gray);
                } else {
                    gr.setColor(Color.white);
                }
                gr.fillRect(renderCol, renderRow, this.size, this.size);
                gr.setColor(Color.darkGray);
                gr.drawRect(renderCol, renderRow, this.size, this.size);
            }
        }
