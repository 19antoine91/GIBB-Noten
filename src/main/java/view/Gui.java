package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gui {

	public Gui(Stage stage) throws Exception {
			Parent root = FXMLLoader.load(getClass().getResource("/FxmlDesignCode.fxml"));
			
			Scene scene = new Scene(root, 400, 600);
			
			stage.setTitle("GIBB Noten Way-Up");
			stage.setScene(scene);
	}
}
