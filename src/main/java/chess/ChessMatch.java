package chess;

import boardGame.Board;
import boardGame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch () {
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }


    private void initialSetup () {
        placeNewPiece('b', 6, new Rook(board, Color.WHITE));
        placeNewPiece('e', 8, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
    }

    public static class ChessPosition {

        private char column;
        private int row;

        public ChessPosition(char column, int row) {
            if (column < 'a' || column > 'h' || row < 1 || row > 8) {
                throw new ChessException("Error instanting ChessPosition. valid values are form a1 to h8");
            }
            this.column = column;
            this.row = row;
        }

        public char getColumn() {
            return column;
        }

        public int getRow() {
            return row;
        }
        protected Position toPosition() {
            return new Position(8 - row, column - 'a');
        }

        protected static ChessPosition fromPosition(Position position) {
            return new ChessPosition((char) ('a' - position.getColumns()),8 - position.getRow());
        }

        @Override
        public String toString () {
            return "" + column + row;
        }
    }
}
