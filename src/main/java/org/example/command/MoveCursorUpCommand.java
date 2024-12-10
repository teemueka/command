package org.example.command;

public class MoveCursorUpCommand implements Command {
    private final PixelGrid grid;

    public MoveCursorUpCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveCursor(-1, 0);
    }
}
