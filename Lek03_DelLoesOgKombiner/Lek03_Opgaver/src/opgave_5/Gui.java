package opgave_5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
    @Override
    public void start(Stage stage) {
        GridPane pane = new GridPane();

        Scene scene = new Scene(pane);
        stage.setWidth(350);
        stage.setHeight(400);
        stage.setTitle("Sierpinski trekant");
        stage.setScene(scene);

        initContent(pane);
        stage.show();
    }

    private final TextField tf = new TextField("0");
    private int triangleCounter = 0;
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblOrder = new Label("Orden:");
        pane.add(lblOrder, 0, 0);

        tf.setPrefWidth(30);
        pane.add(tf, 1, 0);

        Button btnGenerate = new Button("Generér");
        pane.add(btnGenerate, 2, 0);

        Canvas canvas = new Canvas(300, 300);
        pane.add(canvas, 0, 1, 4, 1);

        btnGenerate.setOnAction(event -> generateTrianglesAction(canvas));
    }

    private void generateTrianglesAction(Canvas canvas) {
        triangleCounter = 0;

        int order = 0;
        try {
            order = Integer.parseInt(tf.getText().trim());
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Orden skal være et heltal").showAndWait();
            return;
        }
        if (order < 0) {
            new Alert(Alert.AlertType.ERROR, "Orden skal være et heltal der er større end eller lig med 0").showAndWait();
            return;
        }
        // remove all strokelines
        canvas.getGraphicsContext2D().clearRect(0, 0, 300, 300);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        // begynd rekursion
        drawTriangles(order, gc, 0, 300, 300, 300, 150, 0);

        // tegn den store trekant
        drawTriangle(gc, 0, 300, 300, 300, 150, 0);

        // triangle counter
        System.out.println("Antal trekanter: " + triangleCounter);
    }

    // ------------------------------------------------------------------------

    private void drawTriangles(int order, GraphicsContext gc, double x1, double y1, double x2, double y2, double x3, double y3) {
        if (order > 0)  {
            // mellempunkter for koordinater (grundlinje(r) halveres)
            double x1_2 = (x1 + x2) / 2.0; double y1_2 = (y1 + y2) / 2.0; // mellempunkt for x1 og x2 hedder nu x1_2 og y1_2 osv.
            double x2_3 = (x2 + x3) / 2.0; double y2_3 = (y2 + y3) / 2.0;
            double x3_1 = (x3 + x1) / 2.0; double y3_1 = (y3 + y1) / 2.0;

            // Tegn tre trekanter
            drawTriangle(gc, x1, y1, x1_2, y1_2, x3_1, y3_1);
            drawTriangle(gc, x1_2, y1_2, x2, y2, x2_3, y2_3);
            drawTriangle(gc, x3_1, y3_1, x2_3, y2_3, x3, y3);

            // rekursive kald, der laver 3 trekanter mere. Dette bliver ved indtil order = 0, hvor den store trekant så tegnes.
            drawTriangles(order - 1, gc, x1, y1, x1_2, y1_2, x3_1, y3_1);
            drawTriangles(order - 1, gc, x1_2, y1_2, x2, y2, x2_3, y2_3);
            drawTriangles(order - 1, gc, x3_1, y3_1, x2_3, y2_3, x3, y3);
        }
    }

    private void drawTriangle(GraphicsContext gc, double x1, double y1, double x2, double y2, double x3, double y3) {
        gc.strokeLine(x1, y1, x2, y2);
        gc.strokeLine(x2, y2, x3, y3);
        gc.strokeLine(x3, y3, x1, y1);

        triangleCounter++;
    }

}
