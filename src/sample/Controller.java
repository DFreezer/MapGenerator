package sample;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import simplexNoise.OpenSimplexNoise;

import java.text.DecimalFormat;

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

    public static final double DEFAULT_E_COEFF1 = 0.75;
    public static final double DEFAULT_E_COEFF2 = 0.50;
    public static final double DEFAULT_E_COEFF3 = 0.25;
    public static final double DEFAULT_E_COEFF4 = 0.00;
    public static final double DEFAULT_E_COEFF5 = 0.06;
    public static final double DEFAULT_E_COEFF6 = 0.00;

    public static final double DEFAULT_M_COEFF1 = 1.00;
    public static final double DEFAULT_M_COEFF2 = 0.75;
    public static final double DEFAULT_M_COEFF3 = 0.86;
    public static final double DEFAULT_M_COEFF4 = 0.33;
    public static final double DEFAULT_M_COEFF5 = 0.33;
    public static final double DEFAULT_M_COEFF6 = 0.50;

    private double e1Coeff = DEFAULT_E_COEFF1;
    private double e2Coeff = DEFAULT_E_COEFF2;
    private double e3Coeff = DEFAULT_E_COEFF3;
    private double e4Coeff = DEFAULT_M_COEFF4;
    private double e5Coeff = DEFAULT_E_COEFF5;
    private double e6Coeff = DEFAULT_E_COEFF6;

    private double m1Coeff = DEFAULT_M_COEFF1;
    private double m2Coeff = DEFAULT_M_COEFF2;
    private double m3Coeff = DEFAULT_M_COEFF3;
    private double m4Coeff = DEFAULT_M_COEFF4;
    private double m5Coeff = DEFAULT_M_COEFF5;
    private double m6Coeff = DEFAULT_M_COEFF6;

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

        double xCoeff = 32d;
        if (!xCoeffInputField.getText().isEmpty()) {
            xCoeff = Double.parseDouble(xCoeffInputField.getText());
        }

        double yCoeff = 32d;
        if (!yCoeffInputField.getText().isEmpty()) {
            yCoeff = Double.parseDouble(yCoeffInputField.getText());
        }

        double degree = 2.92;
        if (!degreeInputField.getText().isEmpty()) {
            degree = Double.parseDouble(degreeInputField.getText());
        }

        canvas.setHeight(500);
        canvas.setWidth(500);

        drawMap(xCoeff, yCoeff, degree);
    }

    private void drawMap(double xCoeff, double yCoeff, double degree) {
        for (int y = 0; y < canvas.getHeight(); y++) {
            for (int x = 0; x < canvas.getWidth(); x++) {
                double nx = x / xCoeff;
                double ny = y / yCoeff;
                double noiseValX = (e1Coeff * noise2d( 1 * nx,  1 * ny)
                        + e2Coeff * noise2d( 2 * nx,  2 * ny)
                        + e3Coeff * noise2d( 4 * nx,  4 * ny)
                        + e4Coeff * noise2d( 8 * nx,  8 * ny)
                        + e5Coeff * noise2d(16 * nx, 16 * ny)
                        + e6Coeff * noise2d(32 * nx, 32 * ny));
                noiseValX /= (e1Coeff+e2Coeff+e3Coeff+e4Coeff+e5Coeff+e6Coeff);
                noiseValX = Math.pow(noiseValX, degree);
                double noiseValY = (m1Coeff * noise2d( 1 * nx,  1 * ny)
                        + m2Coeff * noise2d( 2 * nx,  2 * ny)
                        + m3Coeff * noise2d( 4 * nx,  4 * ny)
                        + m4Coeff * noise2d( 8 * nx,  8 * ny)
                        + m5Coeff * noise2d(16 * nx, 16 * ny)
                        + m6Coeff * noise2d(32 * nx, 32 * ny));
                noiseValY /= (m1Coeff+m2Coeff+m3Coeff+m4Coeff+m5Coeff+m6Coeff);
                Color biome = biome(noiseValX, noiseValY);
                canvas.getGraphicsContext2D().setFill(biome);
                canvas.getGraphicsContext2D().fillRect(x, y, 1, 1);
            }
        }
    }

    private double noise2d(double x, double y) {
        return Math.rint(noise.eval(x, y, 0)) / 2d + 0.5;
    }

    private Color biome(double e, double m) {
        // ocean
        if (e < 0.1) return Color.web("#0254d8");
        // beach
        if (e < 0.12) return Color.web("#c2b280");

        if (e > 0.8) {
            // scorched
            if (m < 0.1) return Color.web("#2d2721");
            // bare
            if (m < 0.2) return Color.web("#56412e");
            // tundra
            if (m < 0.5) return Color.web("#828979");
            // snow
            return Color.web("#E6E8E3");
        }

        if (e > 0.6) {
            // temperate desert
            if (m < 0.33) return Color.web("#9F6652");
            // shrubland
            if (m < 0.66) return Color.web("#8F8839");
            // taiga
            return Color.web("#3A4A2D");
        }

        if (e > 0.3) {
            // temperate desert
            if (m < 0.16) return Color.web("#9F6652");
            // grassland
            if (m < 0.50) return Color.web("#2C6312");
            // temperate deciduous forest
            if (m < 0.83) return Color.web("#DEB236");
            // temperate rain forest
            return Color.web("#1E6E0A");
        }

        // subtropical desert
        if (m < 0.16) return Color.web("#A06C56");
        // grassland
        if (m < 0.33) return Color.web("#2C6312");
        // tropical seasonal forest
        if (m < 0.66) return Color.web("#567A1B");
        // tropical rain forest
        return Color.web("#1E6E0A");
    }

    public void generateMap(ActionEvent actionEvent) {
        Platform.runLater(this::updateImage);
    }
}
