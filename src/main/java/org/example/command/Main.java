package org.example.command;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int CELL_SIZE = 40;
    private PixelGrid grid;

    @Override
    public void start(Stage stage) {
        grid = new PixelGrid();
        GridPane gridPane = new GridPane();

        Rectangle[][] cells = new Rectangle[8][8];

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Rectangle rect = new Rectangle(CELL_SIZE, CELL_SIZE, Color.LIGHTGRAY);
                gridPane.add(rect, col, row);
                cells[row][col] = rect;
            }
        }

        Scene scene = new Scene(gridPane, 8 * CELL_SIZE, 8 * CELL_SIZE);
        updateGridUI(cells);

        scene.setOnKeyPressed(event -> {
            Command command = null;
            if (event.getCode() == KeyCode.UP) {
                command = new MoveCursorUpCommand(grid);
            } else if (event.getCode() == KeyCode.DOWN) {
                command = new MoveCursorDownCommand(grid);
            } else if (event.getCode() == KeyCode.LEFT) {
                command = new MoveCursorLeftCommand(grid);
            } else if (event.getCode() == KeyCode.RIGHT) {
                command = new MoveCursorRightCommand(grid);
            } else if (event.getCode() == KeyCode.SPACE) {
                command = new TogglePixelCommand(grid);
            } else if (event.getCode() == KeyCode.ENTER) {
                new GenerateCodeCommand(grid).execute();
            }

            if (command != null) {
                command.execute();
                updateGridUI(cells);
            }
        });

        stage.setScene(scene);
        stage.setTitle("Pixel Art Editor");
        stage.show();
    }

    private void updateGridUI(Rectangle[][] cells) {
        int[][] currentGrid = grid.getGrid();
        int cursorRow = grid.getCursorRow();
        int cursorCol = grid.getCursorCol();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (row == cursorRow && col == cursorCol) {
                    cells[row][col].setStroke(Color.RED);
                    cells[row][col].setStrokeWidth(2);
                } else {
                    cells[row][col].setStrokeWidth(0);
                }
                cells[row][col].setFill(currentGrid[row][col] == 1 ? Color.BLACK : Color.LIGHTGRAY);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("SPACE to toggle pixels");
        System.out.println("ENTER to generate code");
        launch();
    }
}
