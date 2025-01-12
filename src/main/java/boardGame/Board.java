package boardGame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board (int rows, int columns) {

        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }

        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public Piece piece(int row, int column) {
        if (!positionExist(row, column)) {
            throw new BoardException("Postion not on the board");
        }
        return pieces[row][column];
    }

    public Piece piece (Position position) {
        if (!positionExist(position)) {
            throw new BoardException("Postion not on the board");
        }
        return pieces[position.getRow()][position.getColumns()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsApiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }

        pieces[position.getRow()][position.getColumns()] = piece;
        piece.position = position;
    }

    private boolean positionExist(int rows, int columns) {
        return rows >= 0 && rows < this.rows && columns >= 0 && columns < this.columns;
    }

    public boolean positionExist(Position position) {
        return positionExist(position.getRow(), position.getColumns());
    }

    public  boolean thereIsApiece (Position position) {
        if (!positionExist(position)) {
            throw new BoardException("position not on the board");
        }
        return piece(position) != null;
    }

    public Piece removePiece (Position position) {
        if (!positionExist(position)) {
            throw new BoardException("Position not on the board");
        }
        if (piece(position) == null) {
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumns()] = null;
        return aux;
    }
}
