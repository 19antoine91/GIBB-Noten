import javafx.application.Application;
import javafx.stage.Stage;
import view.Gui;


public class NotenAnwendung extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Gui gui = new Gui(primaryStage);
	}
}