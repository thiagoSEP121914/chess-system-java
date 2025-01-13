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

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChessMatch {
    private int turn;
    private Color currentPlayer;
    private Board board = new Board(8, 8);

    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();

    public ChessMatch() {
        board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.WHITE;
        this.initialSetup();
    }


    public int getTurn () {
        return turn;
    }

    public Color getCurrentPlayer () {
        return currentPlayer;
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

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);

        return board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        nextTurn();
        return (ChessPiece)capturedPiece;
    }
    private Piece makeMove (Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);

        if (capturedPiece != null) {
            piecesOnTheBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }
        return capturedPiece;
    }
    private void validateSourcePosition(Position position) {
        if (!board.thereIsApiece(position)) {
            throw new ChessException("There is no piece on source position");
        }

        if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
            throw new ChessException("|The cosen piece is not yours");
        }


        if (!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessException("There is no possible moves for chosen pieces");
        }
    }
    private void  validateTargetPosition(Position source, Position target) {
        if (!board.piece(source).possibleMove(target)) {
            throw new ChessException("The chosen piece can´t move to target");
        }
    }

    private void  nextTurn () {
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK: Color.WHITE;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        this.board.placePiece(piece, (new ChessPosition(column, row)).toPosition());
        piecesOnTheBoard.add(piece);
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
