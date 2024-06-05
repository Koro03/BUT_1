/**
 * 
 */
/**
 * 
 */
module entrainement {
	requires javafx.graphics;
	requires javafx.controls;
	requires java.desktop;
	requires javafx.fxml;
	requires javafx.base;
	
	opens entrainementPack to javafx.graphics, javafx.controls, javafx.fxml, javafx.base;
	
}