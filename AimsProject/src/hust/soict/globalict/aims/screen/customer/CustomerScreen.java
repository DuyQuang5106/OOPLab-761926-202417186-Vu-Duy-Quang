package hust.soict.globalict.aims.screen.customer;

import java.io.IOException;
import java.util.ArrayList;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CustomerScreen extends Application {
	private static Store store;
	private static Cart cart;

	public static void main(String[] args) {
		store = createSampleStore();
		cart = new Cart();
		launch(args);
	}

	public static void launch(Store initialStore, Cart initialCart) {
		store = initialStore;
		cart = initialCart;
		Application.launch(CustomerScreen.class);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		if (store == null) {
			store = createSampleStore();
		}
		if (cart == null) {
			cart = new Cart();
		}

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/globalict/aims/screen/customer/view/Store.fxml"));
		loader.setControllerFactory(controllerClass -> new ViewStoreController(store, cart));
		Parent root = loader.load();

		primaryStage.setTitle("AIMS Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	public static Store createSampleStore() {
		Store sampleStore = new Store();
		sampleStore.addMedia(new DigitalVideoDisc("American Psycho", "Psychological Thriller", "Mary Harron", 102, 19.99f));
		sampleStore.addMedia(new DigitalVideoDisc("Fight Club", "Psychological Drama", "David Fincher", 139, 24.99f));
		sampleStore.addMedia(new DigitalVideoDisc("Se7en", "Crime Thriller", "David Fincher", 127, 22.50f));
		sampleStore.addMedia(new DigitalVideoDisc("Zodiac", "Mystery Thriller", "David Fincher", 157, 25.00f));
		sampleStore.addMedia(new DigitalVideoDisc("Gone Girl", "Psychological Thriller", "David Fincher", 149, 21.99f));
		sampleStore.addMedia(new CompactDisc("Fight Club Soundtrack", "Soundtrack", "David Fincher", 60, 14.99f, "Dust Brothers"));
		sampleStore.addMedia(new CompactDisc("American Psycho Soundtrack", "Soundtrack", "Mary Harron", 55, 13.99f, "Various Artists"));
		sampleStore.addMedia(new Book("Fight Club", "Psychological Fiction", 16.99f, new ArrayList<String>() {{
			add("Chuck Palahniuk");
		}}));
		sampleStore.addMedia(new Book("Gone Girl", "Mystery Thriller", 17.50f, new ArrayList<String>() {{
			add("Gillian Flynn");
		}}));
		return sampleStore;
	}
}
