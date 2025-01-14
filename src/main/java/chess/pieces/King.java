package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    private boolean canMove(Position position) {
        ChessPiece piece  = (ChessPiece)getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //above
        p.setValues(position.getRow() - 1, position.getColumns());
        if (getBoard().positionExist(p) && canMove(p)) {
            mat[p.getRow()][p.getColumns()] = true;
        }

        //below
        p.setValues(position.getRow() + 1, position.getColumns());
        if (getBoard().positionExist(p) && canMove(p)) {
            mat[p.getRow()][p.getColumns()] = true;
        }

        //left
        p.setValues(position.getRow(), position.getColumns() - 1);
        if (getBoard().positionExist(p) && canMove(p)) {
            mat[p.getRow()][p.getColumns()] = true;
        }

        //Right
        p.setValues(position.getRow(), position.getColumns() + 1);
        if (getBoard().positionExist(p) && canMove(p)) {
            mat[p.getRow()][p.getColumns()] = true;
        }

        //northWest
        p.setValues(position.getRow() - 1, position.getColumns() - 1);
        if (getBoard().positionExist(p) && canMove(p)) {
            mat[p.getRow()][p.getColumns()] = true;
        }


        //northEast
        p.setValues(position.getRow() - 1, position.getColumns() + 1);
        if (getBoard().positionExist(p) && canMove(p)) {
            mat[p.getRow()][p.getColumns()] = true;
        }

        //southWest
        p.setValues(position.getRow() + 1, position.getColumns() - 1);
        if (getBoard().positionExist(p) && canMove(p)) {
            mat[p.getRow()][p.getColumns()] = true;
        }

        //southEast
        p.setValues(position.getRow() + 1, position.getColumns() + 1);
        if (getBoard().positionExist(p) && canMove(p)) {
            mat[p.getRow()][p.getColumns()] = true;
        }
        return mat;
    }

    @Override
    public String toString() {
        return "♔";
    }


}
