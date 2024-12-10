package org.example.command;

public class PixelGrid {
    private final int[][] grid;
    private int cursorRow;
    private int cursorCol;

    public PixelGrid() {
        grid = new int[8][8];
        cursorRow = 0;
        cursorCol = 0;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void togglePixel() {
        grid[cursorRow][cursorCol] = (grid[cursorRow][cursorCol] == 0) ? 1 : 0;
    }

    public void moveCursor(int deltaRow, int deltaCol) {
        cursorRow = Math.max(0, Math.min(7, cursorRow + deltaRow));
        cursorCol = Math.max(0, Math.min(7, cursorCol + deltaCol));
    }

    public int getCursorRow() {
        return cursorRow;
    }

    public int getCursorCol() {
        return cursorCol;
    }
}

