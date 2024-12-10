package org.example.command;

public class GenerateCodeCommand implements Command {
    private final PixelGrid grid;

    public GenerateCodeCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        int[][] currentGrid = grid.getGrid();
        System.out.println("int[][] pixelArt = {");
        for (int[] row : currentGrid) {
            System.out.print("    {");
            for (int cell : row) {
                System.out.print(cell + ", ");
            }
            System.out.println("},");
        }
        System.out.println("};");
    }
}
