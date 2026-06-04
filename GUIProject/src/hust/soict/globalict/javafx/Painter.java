package hust.soict.globalict.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Painter.fxml"));
		primaryStage.setTitle("Painter");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
}
