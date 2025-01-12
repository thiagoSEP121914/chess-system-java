package chess;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import boardGame.Board;
import boardGame.BoardException;
import boardGame.Piece;
import boardGame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
    private Board board = new Board(8, 8);

    public ChessMatch() {
        this.initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[this.board.getRows()][this.board.getColumns()];

        for (int i = 0; i < this.board.getRows(); ++i) {
            for (int j = 0; j < this.board.getColumns(); ++j) {
                mat[i][j] = (ChessPiece) this.board.piece(i, j);
            }
        }

        return mat;
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece)capturedPiece;
    }
    private Piece makeMove (Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;
    }
    private void validateSourcePosition(Position position) {
        if (!board.thereIsApiece(position)) {
            throw new ChessException("There is no piece on source position");
        }
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        this.board.placePiece(piece, (new ChessPosition(column, row)).toPosition());
    }

    private void initialSetup() {
        this.placeNewPiece('c', 1, new Rook(this.board, Color.WHITE));
        this.placeNewPiece('c', 2, new Rook(this.board, Color.WHITE));
        this.placeNewPiece('d', 2, new Rook(this.board, Color.WHITE));
        this.placeNewPiece('e', 2, new Rook(this.board, Color.WHITE));
        this.placeNewPiece('e', 1, new Rook(this.board, Color.WHITE));
        this.placeNewPiece('d', 1, new King(this.board, Color.WHITE));
        this.placeNewPiece('c', 7, new Rook(this.board, Color.BLACK));
        this.placeNewPiece('c', 8, new Rook(this.board, Color.BLACK));
        this.placeNewPiece('d', 7, new Rook(this.board, Color.BLACK));
        this.placeNewPiece('e', 7, new Rook(this.board, Color.BLACK));
        this.placeNewPiece('e', 8, new Rook(this.board, Color.BLACK));
        this.placeNewPiece('d', 8, new King(this.board, Color.BLACK));
    }
}
