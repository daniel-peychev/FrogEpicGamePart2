package pieces;

import java.awt.*;

public class Leader extends Piece {
    public Leader(Team belongsToTeam, int row, int col){
        super(belongsToTeam, row, col);
    }

    @Override
    public void render(Graphics gr) {
        int x;
        int y;
        x = marginLeft + cellSize * col + cellSize / 4;
        y = marginTop + cellSize * row + cellSize / 4;
        if (belongsToTeam == Team.YELLOW){
            //x = marginLeft + cellSize * row + cellSize / 4;
            //y = marginTop + cellSize * col + cellSize / 4;
            gr.setColor(Color.yellow);

        } else {
            //x = marginLeft + cellSize / 4;
            //y = marginTop + cellSize * 4 + cellSize / 4;
            gr.setColor(Color.GREEN);

        }
        gr.fillRect(
                x,
                y,
                cellSize / 2,
                cellSize / 2
        );
    }
}
