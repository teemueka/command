package org.example.command;

public class MoveCursorDownCommand implements Command {
    private final PixelGrid grid;

    public MoveCursorDownCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveCursor(1, 0);
    }
}
