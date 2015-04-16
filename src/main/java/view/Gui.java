package view;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui {

	public Gui(Stage primaryStage) throws Exception {
			GridPane root = new GridPane(); 
			//FXMLLoader.load(getClass().getResource("/FxmlDesignCode.fxml"));
			
			Scene scene = new Scene(root, 400, 600);
			
			primaryStage.setTitle("GIBB Noten Way-Up");
			primaryStage.setScene(scene);
			primaryStage.show();
	}
}
