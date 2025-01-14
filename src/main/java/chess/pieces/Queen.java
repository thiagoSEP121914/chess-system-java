package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //above
        p.setValues(position.getRow() - 1, position.getColumns());
        while (getBoard().positionExist(p) && !getBoard().thereIsApiece(p)) {
            mat[p.getRow()][p.getColumns()] = true;
            p.setRow(p.getRow() - 1);
        }
        if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumns()] = true;
        }

        //left
        p.setValues(position.getRow(), position.getColumns() - 1);
        while (getBoard().positionExist(p) && !getBoard().thereIsApiece(p)) {
            mat[p.getRow()][p.getColumns()] = true;
            p.setColumn(p.getColumns() - 1);
        }
        if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumns()] = true;
        }

        //right
        p.setValues(position.getRow(), position.getColumns() + 1);
        while (getBoard().positionExist(p) && !getBoard().thereIsApiece(p)) {
            mat[p.getRow()][p.getColumns()] = true;
            p.setColumn(p.getColumns() + 1);
        }
        if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumns()] = true;
        }


        //below
        p.setValues(position.getRow() + 1, position.getColumns());
        while (getBoard().positionExist(p) && !getBoard().thereIsApiece(p)) {
            mat[p.getRow()][p.getColumns()] = true;
            p.setRow(p.getRow() + 1);
        }
        if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumns()] = true;
        }

        //northWest
        p.setValues(position.getRow() - 1, position.getColumns() - 1);
        while (getBoard().positionExist(p) && !getBoard().thereIsApiece(p)) {
            mat[p.getRow()][p.getColumns()] = true;
            p.setValues(p.getRow() - 1, p.getColumns() - 1);
        }
        if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumns()] = true;
        }

        //northEast
        p.setValues(position.getRow() - 1, position.getColumns() + 1);
        while (getBoard().positionExist(p) && !getBoard().thereIsApiece(p)) {
            mat[p.getRow()][p.getColumns()] = true;
            p.setValues(p.getRow() - 1, p.getColumns() + 1);
        }
        if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumns()] = true;
        }

        //southEast
        p.setValues(position.getRow() + 1 , position.getColumns() + 1);
        while (getBoard().positionExist(p) && !getBoard().thereIsApiece(p)) {
            mat[p.getRow()][p.getColumns()] = true;
            p.setValues(p.getRow() + 1, p.getColumns() + 1);
        }
        if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumns()] = true;
        }

        //southWest
        p.setValues(position.getRow() + 1, position.getColumns() - 1);
        while (getBoard().positionExist(p) && !getBoard().thereIsApiece(p)) {
            mat[p.getRow()][p.getColumns()] = true;
            p.setValues(p.getRow() + 1, p.getColumns() - 1);
        }
        if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumns()] = true;
        }

        return mat;
    }

    @Override
    public String toString () {
        return "♕";
    }
}
