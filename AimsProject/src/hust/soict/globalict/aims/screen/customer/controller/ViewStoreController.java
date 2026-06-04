package hust.soict.globalict.aims.screen.customer.controller;

import java.io.IOException;
import java.util.ArrayList;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ViewStoreController {
	private final Store store;
	private final Cart cart;

	@FXML
	private GridPane gridPane;

	public ViewStoreController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}

	@FXML
	private void initialize() {
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		int column = 0;
		int row = 0;

		for (Media media : mediaInStore) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/globalict/aims/screen/customer/view/Item.fxml"));
				loader.setControllerFactory(controllerClass -> new ItemController(media, cart));
				AnchorPane item = loader.load();
				gridPane.add(item, column, row);
				GridPane.setMargin(item, new Insets(10));

				column++;
				if (column == 3) {
					column = 0;
					row++;
				}
			} catch (IOException exception) {
				throw new RuntimeException("Cannot load Item.fxml", exception);
			}
		}
	}

	@FXML
	private void btnViewCartPressed(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/globalict/aims/screen/customer/view/Cart.fxml"));
		loader.setControllerFactory(controllerClass -> new CartController(store, cart));
		Parent root = loader.load();

		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("AIMS Cart");
		stage.setScene(new Scene(root));
		stage.show();
	}
}
