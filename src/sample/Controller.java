package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import simplexNoise.OpenSimplexNoise;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

public class Controller {

    public Label coeff1Label;
    public Label coeff2Label;
    public Label coeff3Label;
    public Label coeff4Label;
    public Label coeff5Label;
    public Label coeff6Label;
    public Label coeff7Label;
    public Label coeff8Label;
    public Label coeff9Label;
    public Label coeff10Label;
    public Label coeff11Label;
    public Label coeff12Label;
    public Slider sliderCoeff1;
    public Slider sliderCoeff2;
    public Slider sliderCoeff3;
    public Slider sliderCoeff4;
    public Slider sliderCoeff5;
    public Slider sliderCoeff6;
    public Slider sliderCoeff7;
    public Slider sliderCoeff8;
    public Slider sliderCoeff9;
    public Slider sliderCoeff10;
    public Slider sliderCoeff11;
    public Slider sliderCoeff12;
    public ProgressBar progressBar;
    public MenuItem saveFile;
    @FXML
    private TextField seedInputField;
    @FXML
    private TextField xCoeffInputField;
    @FXML
    private TextField yCoeffInputField;
    @FXML
    private TextField degreeInputField;
    @FXML
    private TextField heightInputField;
    @FXML
    private TextField widthInputField;
    @FXML
    private Canvas canvas;
    private OpenSimplexNoise noise;

    public static final double DEFAULT_E_COEFF1 = 1;
    public static final double DEFAULT_E_COEFF2 = 0.5;
    public static final double DEFAULT_E_COEFF3 = 0.25;
    public static final double DEFAULT_E_COEFF4 = 0.13;
    public static final double DEFAULT_E_COEFF5 = 0.06;
    public static final double DEFAULT_E_COEFF6 = 0.03;

    public static final double DEFAULT_M_COEFF1 = 1;
    public static final double DEFAULT_M_COEFF2 = 0.75;
    public static final double DEFAULT_M_COEFF3 = 0.33;
    public static final double DEFAULT_M_COEFF4 = 0.33;
    public static final double DEFAULT_M_COEFF5 = 0.33;
    public static final double DEFAULT_M_COEFF6 = 0.25;

    private double e1Coeff = DEFAULT_E_COEFF1;
    private double e2Coeff = DEFAULT_E_COEFF2;
    private double e3Coeff = DEFAULT_E_COEFF3;
    private double e4Coeff = DEFAULT_E_COEFF4;
    private double e5Coeff = DEFAULT_E_COEFF5;
    private double e6Coeff = DEFAULT_E_COEFF6;

    private double m1Coeff = DEFAULT_M_COEFF1;
    private double m2Coeff = DEFAULT_M_COEFF2;
    private double m3Coeff = DEFAULT_M_COEFF3;
    private double m4Coeff = DEFAULT_M_COEFF4;
    private double m5Coeff = DEFAULT_M_COEFF5;
    private double m6Coeff = DEFAULT_M_COEFF6;

    private int[][] tokens;
    private double[][] values;

    @FXML
    private void initialize() {
        initSlidersListeners();

        coeff1Label.setText(String.valueOf(DEFAULT_E_COEFF1));
        coeff2Label.setText(String.valueOf(DEFAULT_E_COEFF2));
        coeff3Label.setText(String.valueOf(DEFAULT_E_COEFF3));
        coeff4Label.setText(String.valueOf(DEFAULT_E_COEFF4));
        coeff5Label.setText(String.valueOf(DEFAULT_E_COEFF5));
        coeff6Label.setText(String.valueOf(DEFAULT_E_COEFF6));
        coeff7Label.setText(String.valueOf(DEFAULT_M_COEFF1));
        coeff8Label.setText(String.valueOf(DEFAULT_M_COEFF2));
        coeff9Label.setText(String.valueOf(DEFAULT_M_COEFF3));
        coeff10Label.setText(String.valueOf(DEFAULT_M_COEFF4));
        coeff11Label.setText(String.valueOf(DEFAULT_M_COEFF5));
        coeff12Label.setText(String.valueOf(DEFAULT_M_COEFF6));
    }

    private void initSlidersListeners() {
        sliderCoeff1.valueProperty().addListener((observable, oldValue, newValue) -> {
            coeff1Label.setText(new DecimalFormat("#.##").format(newValue.doubleValue()));
            e1Coeff = newValue.doubleValue();
            Platform.runLater(this::updateImage);
        });
        sliderCoeff2.valueProperty().addListener((observable, oldValue, newValue) -> {
            coeff2Label.setText(new DecimalFormat("#.##").format(newValue.doubleValue()));
            e2Coeff = newValue.doubleValue();
            Platform.runLater(this::updateImage);
        });
        sliderCoeff3.valueProperty().addListener((observable, oldValue, newValue) -> {
            coeff3Label.setText(new DecimalFormat("#.##").format(newValue.doubleValue()));
            e3Coeff = newValue.doubleValue();
            Platform.runLater(this::updateImage);
        });
        sliderCoeff4.valueProperty().addListener((observable, oldValue, newValue) -> {
            coeff4Label.setText(new DecimalFormat("#.##").format(newValue.doubleValue()));
            e4Coeff = newValue.doubleValue();
            Platform.runLater(this::updateImage);
        });
        sliderCoeff5.valueProperty().addListener((observable, oldValue, newValue) -> {
            coeff5Label.setText(new DecimalFormat("#.##").format(newValue.doubleValue()));
            e5Coeff = newValue.doubleValue();
            Platform.runLater(this::updateImage);
        });
        sliderCoeff6.valueProperty().addListener((observable, oldValue, newValue) -> {
            coeff6Label.setText(new DecimalFormat("#.##").format(newValue.doubleValue()));
            e6Coeff = newValue.doubleValue();
            Platform.runLater(this::updateImage);
        });
        sliderCoeff7.valueProperty().addListener((observable, oldValue, newValue) -> {
            coeff7Label.setText(new DecimalFormat("#.##").format(newValue.doubleValue()));
            m1Coeff = newValue.doubleValue();
            Platform.runLater(this::updateImage);
        });
        sliderCoeff8.valueProperty().addListener((observable, oldValue, newValue) -> {
            coeff8Label.setText(new DecimalFormat("#.##").format(newValue.doubleValue()));
            m2Coeff = newValue.doubleValue();
            Platform.runLater(this::updateImage);
        });
        sliderCoeff9.valueProperty().addListener((observable, oldValue, newValue) -> {
            coeff9Label.setText(new DecimalFormat("#.##").format(newValue.doubleValue()));
            m3Coeff = newValue.doubleValue();
            Platform.runLater(this::updateImage);
        });
        sliderCoeff10.valueProperty().addListener((observable, oldValue, newValue) -> {
            coeff10Label.setText(new DecimalFormat("#.##").format(newValue.doubleValue()));
            m4Coeff = newValue.doubleValue();
            Platform.runLater(this::updateImage);
        });
        sliderCoeff11.valueProperty().addListener((observable, oldValue, newValue) -> {
            coeff11Label.setText(new DecimalFormat("#.##").format(newValue.doubleValue()));
            m5Coeff = newValue.doubleValue();
            Platform.runLater(this::updateImage);
        });
        sliderCoeff12.valueProperty().addListener((observable, oldValue, newValue) -> {
            coeff12Label.setText(new DecimalFormat("#.##").format(newValue.doubleValue()));
            m6Coeff = newValue.doubleValue();
            Platform.runLater(this::updateImage);
        });
    }

    private void updateImage() {
        if (!seedInputField.getText().isEmpty()) {
            int seed = Integer.parseInt(seedInputField.getText());
            noise = new OpenSimplexNoise(seed);
        } else {
            noise = new OpenSimplexNoise();
        }

        double xCoeff = 128d;
        if (!xCoeffInputField.getText().isEmpty()) {
            xCoeff = Double.parseDouble(xCoeffInputField.getText());
        }

        double yCoeff = 128d;
        if (!yCoeffInputField.getText().isEmpty()) {
            yCoeff = Double.parseDouble(yCoeffInputField.getText());
        }

        int frequency = 1;
        if (!degreeInputField.getText().isEmpty()) {
            frequency = Integer.parseInt(degreeInputField.getText());
        }

        double height = 500;
        if (!heightInputField.getText().isEmpty()) {
            height = Integer.parseInt(heightInputField.getText());
        }

        double width = 500;
        if (!widthInputField.getText().isEmpty()) {
            width = Integer.parseInt(widthInputField.getText());
        }

        canvas.setHeight(height);
        canvas.setWidth(width);

        drawMap(xCoeff, yCoeff);
        drawTrees(values, frequency);
        drawRocks(values);
    }

    private void drawMap(double xCoeff, double yCoeff) {
        tokens = new int[(int)canvas.getHeight()][(int)canvas.getWidth()];
        values = new double[(int)canvas.getHeight()][(int)canvas.getWidth()];
        for (int y = 0; y < canvas.getHeight(); y++) {
            for (int x = 0; x < canvas.getWidth(); x++) {
                double nx = x / xCoeff;
                double ny = y / yCoeff;
                double land = e1Coeff * noise.eval(nx, ny) +
                        e2Coeff * noise.eval(2 * nx, 2 * ny) +
                        e3Coeff * noise.eval(4 * nx, 4 * ny) +
                        e4Coeff * noise.eval(8 * nx, 8 * ny) +
                        e5Coeff * noise.eval(16 * nx, 16 * ny) +
                        e6Coeff * noise.eval(32 * nx, 32 * ny);
                double climate = m1Coeff * noise.eval(nx, ny) +
                        m2Coeff * noise.eval(2 * nx, 2 * ny) +
                        m3Coeff * noise.eval(4 * nx, 4 * ny) +
                        m4Coeff * noise.eval(8 * nx, 8 * ny) +
                        m5Coeff * noise.eval(16 * nx, 16 * ny) +
                        m6Coeff * noise.eval(32 * nx, 32 * ny);
                values[y][x] = land;
                if (land > 0) {
                    if (land < 0.3) {
                        if (climate < 0) {
                            canvas.getGraphicsContext2D().getPixelWriter().setColor(x, y, Color.SADDLEBROWN);
                            tokens[x][y] = Tile.DIRT.getValue();
                        } else {
                            canvas.getGraphicsContext2D().getPixelWriter().setColor(x, y, Color.FORESTGREEN);
                            tokens[x][y] = Tile.GRASS.getValue();
                            //canvas.getGraphicsContext2D().getPixelWriter().setColor(x, y, Color.YELLOWGREEN);
                        }
                    } else {
                        canvas.getGraphicsContext2D().getPixelWriter().setColor(x, y, Color.FORESTGREEN);
                        tokens[x][y] = Tile.GRASS.getValue();
//                        if (climate > 0.5) {
//                            canvas.getGraphicsContext2D().getPixelWriter().setColor(x, y, Color.DARKGREEN);
//                        } else {
//                            canvas.getGraphicsContext2D().getPixelWriter().setColor(x, y, Color.FORESTGREEN);
//                        }
                    }
                }
                else if (land <= 0) {
                    canvas.getGraphicsContext2D().getPixelWriter().setColor(x, y, Color.DARKBLUE);
                    tokens[x][y] = Tile.OCEAN.getValue();
//                    if (land > -0.2) {
//                        canvas.getGraphicsContext2D().getPixelWriter().setColor(x, y, Color.MEDIUMBLUE);
//                    }
                    if (land > -0.1) {
                        canvas.getGraphicsContext2D().getPixelWriter().setColor(x, y, Color.YELLOW);
                        tokens[x][y] = Tile.SAND.getValue();
                    }
                }
            }
        }
    }

    private void drawTrees(double[][] value, int frequency) {
        for (int yc = frequency; yc < value.length - frequency; yc++) {
            for (int xc = frequency; xc < value[yc].length - frequency; xc++) {
                double max = 0;

                for (int yn = yc - frequency; yn <= yc + frequency; yn++) {
                    for (int xn = xc - frequency; xn <= xc + frequency; xn++) {
                        double e = value[yn][xn];
                        if (e > max) { max = e; }
                    }
                }
                if (value[yc][xc] == max) {
                    canvas.getGraphicsContext2D().setFill(Color.DARKGREEN);
                    canvas.getGraphicsContext2D().fillOval(xc, yc, 3, 3);
                    tokens[xc][yc] = 4;
                }
            }
        }
    }

    private void drawRocks(double[][] value) {
        Random random = new Random();
        for (int i = 0; i < 500; i++) {
            int x = random.nextInt(value.length);
            int y = random.nextInt(value.length);
            if (value[y][x] > 0) {
                canvas.getGraphicsContext2D().setFill(Color.GRAY);
                canvas.getGraphicsContext2D().fillOval(x, y, 3, 3);
                tokens[x][y] = 5;
            }
        }
    }
//E:\Development\Survival-in-Flatland\res\Worlds
    private void smoothTiles(int[][] tokens) {
        for (int y = 0; y < tokens.length - 1; y++) {
            for (int x = 0; x < tokens[y].length - 1; x++) {
                if (tokens[y][x] == Tile.GRASS.getValue()) {
                    if (tokens[y][x + 1] == Tile.DIRT.getValue()) {
                        if (tokens[y + 1][x] == Tile.DIRT.getValue()) {
                            tokens[y][x] = Tile.DIRT_GRASS_TL.getValue();
                        } else if(y - 1 >= 0 && tokens[y - 1][x] == Tile.DIRT.getValue()) {
                            tokens[y][x] = Tile.DIRT_GRASS_BL.getValue();
                        } else {
                            tokens[y][x] = Tile.GRASS_DIRT_R.getValue();
                        }
                    } else if (x - 1 >= 0 && tokens[y][x - 1] == Tile.DIRT.getValue()) {
                        if (tokens[y + 1][x] == Tile.DIRT.getValue()) {
                            tokens[y][x] = Tile.DIRT_GRASS_TR.getValue();
                        } else if(y - 1 >= 0 && tokens[y - 1][x] == Tile.DIRT.getValue()) {
                            tokens[y][x] = Tile.DIRT_GRASS_BR.getValue();
                        } else {
                            tokens[y][x] = Tile.GRASS_DIRT_L.getValue();
                        }
                    } else if (y - 1 >= 0 && tokens[y - 1][x] == Tile.DIRT.getValue()) {
                        tokens[y][x] = Tile.GRASS_DIRT_T.getValue();
                    } else if (tokens[y + 1][x] == Tile.DIRT.getValue()) {
                        tokens[y][x] = Tile.GRASS_DIRT_B.getValue();
                    } else if (tokens[y + 1][x + 1] == Tile.DIRT.getValue()) {
                        tokens[y][x] = Tile.GRASS_DIRT_BR.getValue();
                    } else if (y - 1 >= 0 && tokens[y - 1][x + 1] == Tile.DIRT.getValue()) {
                        tokens[y][x] = Tile.GRASS_DIRT_TR.getValue();
                    } else if (x - 1 >= 0 && tokens[y + 1][x - 1] == Tile.DIRT.getValue()) {
                        tokens[y][x] = Tile.GRASS_DIRT_BL.getValue();
                    } else if (y - 1 >= 0 && x - 1 >= 0 && tokens[y - 1][x - 1] == Tile.DIRT.getValue()) {
                        tokens[y][x] = Tile.GRASS_DIRT_TL.getValue();
                    }
                } else if (tokens[y][x] == Tile.SAND.getValue()) {
                    if (tokens[y][x + 1] == Tile.GRASS.getValue()) {
                        if (tokens[y + 1][x] == Tile.GRASS.getValue()) {
                            tokens[y][x] = Tile.GRASS_SAND_TL.getValue();
                        } else if(y - 1 >= 0 && tokens[y - 1][x] == Tile.GRASS.getValue()) {
                            tokens[y][x] = Tile.GRASS_SAND_BL.getValue();
                        } else {
                            tokens[y][x] = Tile.SAND_GRASS_R.getValue();
                        }
                    } else if (x - 1 >= 0 && tokens[y][x - 1] == Tile.GRASS.getValue()) {
                        if (tokens[y + 1][x] == Tile.GRASS.getValue()) {
                            tokens[y][x] = Tile.GRASS_SAND_TR.getValue();
                        } else if(y - 1 >= 0 && tokens[y - 1][x] == Tile.GRASS.getValue()) {
                            tokens[y][x] = Tile.GRASS_SAND_BR.getValue();
                        } else {
                            tokens[y][x] = Tile.SAND_GRASS_L.getValue();
                        }
                    } else if (y - 1 >= 0 && tokens[y - 1][x] == Tile.GRASS.getValue()) {
                        tokens[y][x] = Tile.SAND_GRASS_T.getValue();
                    } else if (tokens[y + 1][x] == Tile.GRASS.getValue()) {
                        tokens[y][x] = Tile.SAND_GRASS_B.getValue();
                    } else if (tokens[y + 1][x + 1] == Tile.GRASS.getValue()) {
                        tokens[y][x] = Tile.SAND_GRASS_BR.getValue();
                    } else if (y - 1 >= 0 && tokens[y - 1][x + 1] == Tile.GRASS.getValue()) {
                        tokens[y][x] = Tile.SAND_GRASS_TR.getValue();
                    } else if (x - 1 >= 0 && tokens[y + 1][x - 1] == Tile.GRASS.getValue()) {
                        tokens[y][x] = Tile.SAND_GRASS_BL.getValue();
                    } else if (y - 1 >= 0 && x - 1 >= 0 && tokens[y - 1][x - 1] == Tile.GRASS.getValue()) {
                        tokens[y][x] = Tile.SAND_GRASS_TL.getValue();
                    }
                }
            }
        }
    }

    public void generateMap(ActionEvent actionEvent) {
        Platform.runLater(this::updateImage);
    }

    public void saveAs(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("World files (*.world)", "*.world");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(canvas.getScene().getWindow());
        if (tokens != null) {
            writeFile(tokens, file);
        }
    }

    private void writeFile(int[][] tokens, File file) {
        smoothTiles(tokens);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(tokens.length + " " + tokens.length);
            writer.newLine();
            for (int i = 0; i < tokens.length; i++) {
                for (int j = 0; j < tokens[i].length; j++) {
                    //System.out.print(tokens[j][i] + " ");
                    writer.write(String.valueOf(tokens[i][j]) + " ");
                }
                //System.out.println();
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[][] values = {
                {0,0,0,0,0,0,0,0,1,1,0,0},
                {0,1,1,1,0,0,0,0,1,1,0,0},
                {0,1,1,1,0,0,0,0,1,1,0,0},
                {0,1,1,1,0,0,0,0,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,1,1,1,0,0,0,0,0,0},
                {0,0,1,1,1,1,1,1,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0}
        };

        Controller controller = new Controller();
        controller.writeFile(values, new File("test.world"));

    }
}
