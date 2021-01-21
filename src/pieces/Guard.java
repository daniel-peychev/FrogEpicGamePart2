package pieces;

import java.awt.*;

public class Guard extends Piece {
    int number;
    final int innerRadius = 30;
    final int outerRadius = 40;
    public Guard(Team belongsToTeam, int number, int row, int col){
        super(belongsToTeam, row, col);
        this.number = number;
    }

    @Override
    public void render(Graphics gr) {
        //int row;
        //int col = number;
        Color outerColor;
        Color innerColor;
        if (belongsToTeam == Team.YELLOW) {
            //row = 0;
            outerColor = Color.green;
            innerColor = Color.yellow;

        } else {
            //row = 4;
            //col++;
            outerColor = Color.yellow;
            innerColor = Color.green;
        }

        int x = marginLeft + col * cellSize + cellSize / 2 - outerRadius/2;
        int y = marginTop + row * cellSize + cellSize / 2 - outerRadius/2;
        gr.setColor(outerColor);
        gr.fillOval(x, y, outerRadius, outerRadius);
        gr.setColor(innerColor);
        x = marginLeft + col * cellSize + cellSize / 2 - innerRadius/2;
        y = marginTop + row * cellSize + cellSize / 2 - innerRadius/2;
        gr.fillOval(x, y, innerRadius, innerRadius);

    }
}
