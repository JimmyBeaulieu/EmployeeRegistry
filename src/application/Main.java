package application;
	
import java.sql.Connection;
import java.sql.SQLException;

import org.sqlite.SQLiteDataSource;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Database db = new Database();
		Login loginPage = new Login(primaryStage, db);
		loginPage.requestFocus();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void connectDb() {

        SQLiteDataSource ds = null;

        try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:database.db");
        } 
        catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println( "Opened database successfully" );

        try {
        	Connection conn = ds.getConnection();
        } 
        catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }

        System.out.println( "Created database successfully" );
    }
}
