package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn  extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            p.setValues(position.getRow() - 1, position.getColumns());
            if (getBoard().positionExist(p) && !getBoard().thereIsApiece(p)) {
                mat[p.getRow()][p.getColumns()] = true;
            }

            p.setValues(position.getRow() - 2, position.getColumns());
            Position p2 = new Position(position.getRow() - 1, position.getColumns());
            if (getBoard().positionExist(p) && !getBoard().thereIsApiece(p) && getBoard().positionExist(p2) && !getBoard().thereIsApiece(p2) && getMoveCount() == 0) {
                mat[p.getRow()][p.getColumns()] = true;
            }

            p.setValues(position.getRow() - 1, position.getColumns() - 1);
            if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumns()] = true;
            }

            p.setValues(position.getRow() - 1, position.getColumns() + 1);
            if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumns()] = true;
            }
        } else {
            p.setValues(position.getRow()  + 1, position.getColumns());
            if (getBoard().positionExist(p) && !getBoard().thereIsApiece(p)) {
                mat[p.getRow()][p.getColumns()] = true;
            }

            p.setValues(position.getRow() + 2, position.getColumns());
            Position p2 = new Position(position.getRow() + 1, position.getColumns());
            if (getBoard().positionExist(p) && !getBoard().thereIsApiece(p) && getBoard().positionExist(p2) && !getBoard().thereIsApiece(p2) && getMoveCount() == 0) {
                mat[p.getRow()][p.getColumns()] = true;
            }

            p.setValues(position.getRow() + 1, position.getColumns() - 1);
            if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumns()] = true;
            }

            p.setValues(position.getRow() + 1, position.getColumns() + 1);
            if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumns()] = true;
            }
        }
        return mat;
    }

    @Override
    public String toString () {
        return "♙";
    }

}
