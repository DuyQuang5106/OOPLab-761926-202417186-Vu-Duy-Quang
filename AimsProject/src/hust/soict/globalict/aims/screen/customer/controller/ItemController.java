package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ItemController {
	private final Media media;
	private final Cart cart;

	@FXML
	private Label lblTitle;

	@FXML
	private Label lblCost;

	@FXML
	private Button btnAddToCart;

	@FXML
	private Button btnPlay;

	public ItemController(Media media, Cart cart) {
		this.media = media;
		this.cart = cart;
	}

	@FXML
	private void initialize() {
		setData(media);
	}

	public void setData(Media media) {
		lblTitle.setText(media.getTitle());
		lblCost.setText(media.getCost() + " $");

		boolean playable = media instanceof Playable;
		btnPlay.setVisible(playable);
		btnPlay.setManaged(playable);
	}

	@FXML
	private void btnAddToCartClicked(ActionEvent event) {
		int before = cart.getItemsOrdered().size();
		cart.addMedia(media);

		if (cart.getItemsOrdered().size() > before) {
			showAlert(Alert.AlertType.INFORMATION, "Cart", media.getTitle() + " added to cart.");
		} else {
			showAlert(Alert.AlertType.WARNING, "Cart", media.getTitle() + " is already in the cart.");
		}
	}

	@FXML
	private void btnPlayClicked(ActionEvent event) {
		try {
			((Playable) media).play();
			showAlert(Alert.AlertType.INFORMATION, "Play", "Playing: " + media.getTitle());
		} catch (PlayerException exception) {
			showAlert(Alert.AlertType.ERROR, "Play error", exception.getMessage());
		}
	}

	private void showAlert(Alert.AlertType type, String title, String content) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
		alert.showAndWait();
	}
}
