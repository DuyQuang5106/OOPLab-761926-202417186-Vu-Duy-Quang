package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	@FXML
	private Pane drawingAreaPane;

	@FXML
	private RadioButton eraserRadioButton;

	@FXML
	private void drawingAreaMouseDragged(MouseEvent event) {
		boolean erasing = eraserRadioButton != null && eraserRadioButton.isSelected();
		double radius = erasing ? 12.0 : 4.0;
		Circle circle = new Circle(event.getX(), event.getY(), radius);
		circle.setFill(erasing ? Color.WHITE : Color.BLACK);
		drawingAreaPane.getChildren().add(circle);
	}

	@FXML
	private void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}
}
