/**
 * 
 */
/**
 * @author befauchet
 *
 */
module Tp5_miniAp {
	requires javafx.graphics;
	requires javafx.controls;
	requires java.desktop;
	requires javafx.fxml;
	requires javafx.base;
	
	opens controleur to javafx.graphics, javafx.controls, javafx.fxml, javafx.base;
	opens modele to javafx.graphics, javafx.controls, javafx.fxml, javafx.base;
	opens vue to javafx.graphics, javafx.controls, javafx.fxml, javafx.base;
}