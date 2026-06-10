package hust.soict.globalict.test.screen.customer.store;

import java.io.IOException;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.screen.customer.CustomerScreen;
import hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		Store store = CustomerScreen.createSampleStore();
		Cart cart = new Cart();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/globalict/aims/screen/customer/view/Store.fxml"));
		loader.setControllerFactory(controllerClass -> new ViewStoreController(store, cart));
		Parent root = loader.load();

		primaryStage.setTitle("AIMS Store Test");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
}
