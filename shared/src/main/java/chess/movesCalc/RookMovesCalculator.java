package chess.movesCalc;

import chess.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RookMovesCalculator implements PieceMovesCalculator{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        Collection<ChessMove> moves = new ArrayList<>();
        int [][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

        for(int[] direction : directions){
            int row = position.getRow();
            int col = position.getColumn();
            ChessGame.TeamColor myColor = board.getPiece(position).getTeamColor();

            while(true){
                row += direction[0];
                col += direction[1];

                if (row < 1 || row >= 9 || col < 1 || col >= 9) {
                    break;
                }

                ChessPosition newPosition = new ChessPosition(row, col);
                ChessPiece newPiece = board.getPiece(newPosition);

                if(newPiece == null){
                    moves.add(new ChessMove(position, newPosition, null));
                } else if (newPiece.getTeamColor() != myColor) {
                    moves.add(new ChessMove(position, newPosition, null));
                    break;
                }
                else{
                    break;
                }
            }
        }


        return moves;
    }
}
