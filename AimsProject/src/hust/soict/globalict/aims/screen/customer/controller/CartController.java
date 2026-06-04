package hust.soict.globalict.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	private final Store store;
	private final Cart cart;
	private FilteredList<Media> filteredMedia;

	@FXML
	private TableView<Media> tblMedia;

	@FXML
	private TableColumn<Media, Integer> colMediaId;

	@FXML
	private TableColumn<Media, String> colMediaTitle;

	@FXML
	private TableColumn<Media, String> colMediaCategory;

	@FXML
	private TableColumn<Media, Float> colMediaCost;

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnRemove;

	@FXML
	private TextField tfFilter;

	@FXML
	private RadioButton radioBtnFilterId;

	@FXML
	private RadioButton radioBtnFilterTitle;

	@FXML
	private Label costLabel;

	public CartController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}

	@FXML
	private void initialize() {
		colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

		filteredMedia = new FilteredList<Media>(cart.getItemsOrdered(), media -> true);
		tblMedia.setItems(filteredMedia);
		updateCostLabel();

		btnPlay.setVisible(false);
		btnPlay.setManaged(false);
		btnRemove.setVisible(false);
		btnRemove.setManaged(false);

		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				(ChangeListener<Media>) (observable, oldValue, newValue) -> updateButtonBar(newValue));
		tfFilter.textProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia());
		radioBtnFilterId.selectedProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia());
		cart.getItemsOrdered().addListener((ListChangeListener<Media>) change -> {
			updateCostLabel();
			showFilteredMedia();
		});
	}

	private void updateButtonBar(Media media) {
		boolean selected = media != null;
		boolean playable = media instanceof Playable;

		btnRemove.setVisible(selected);
		btnRemove.setManaged(selected);
		btnPlay.setVisible(playable);
		btnPlay.setManaged(playable);
	}

	private void showFilteredMedia() {
		String filter = tfFilter.getText();
		if (filter == null || filter.isBlank()) {
			filteredMedia.setPredicate(media -> true);
			return;
		}

		String normalizedFilter = filter.trim().toLowerCase();
		if (radioBtnFilterTitle.isSelected()) {
			filteredMedia.setPredicate(media -> media.getTitle() != null
					&& media.getTitle().toLowerCase().contains(normalizedFilter));
		} else {
			filteredMedia.setPredicate(media -> String.valueOf(media.getId()).contains(normalizedFilter));
		}
	}

	@FXML
	private void btnRemovePressed(ActionEvent event) {
		Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
		if (selectedMedia != null) {
			cart.removeMedia(selectedMedia);
			tblMedia.getSelectionModel().clearSelection();
			updateButtonBar(null);
		}
	}

	@FXML
	private void btnPlayPressed(ActionEvent event) {
		Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
		if (selectedMedia instanceof Playable) {
			try {
				((Playable) selectedMedia).play();
				showAlert(Alert.AlertType.INFORMATION, "Play", "Playing: " + selectedMedia.getTitle());
			} catch (PlayerException exception) {
				showAlert(Alert.AlertType.ERROR, "Play error", exception.getMessage());
			}
		}
	}

	@FXML
	private void btnPlaceOrderPressed(ActionEvent event) {
		if (cart.getItemsOrdered().isEmpty()) {
			showAlert(Alert.AlertType.WARNING, "Order", "Your cart is empty.");
			return;
		}
		cart.clearCart();
		tblMedia.getSelectionModel().clearSelection();
		updateButtonBar(null);
		showAlert(Alert.AlertType.INFORMATION, "Order", "Order placed successfully.");
	}

	@FXML
	private void btnViewStorePressed(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/globalict/aims/screen/customer/view/Store.fxml"));
		loader.setControllerFactory(controllerClass -> new ViewStoreController(store, cart));
		Parent root = loader.load();

		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("AIMS Store");
		stage.setScene(new Scene(root));
		stage.show();
	}

	private void updateCostLabel() {
		costLabel.setText(String.format("%.2f $", cart.totalCost()));
	}

	private void showAlert(Alert.AlertType type, String title, String content) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
		alert.showAndWait();
	}
}
