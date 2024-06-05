/**
 * 
 */
/**
 * @author befauchet
 *
 */
module ihm_td1 {
	requires javafx.graphics;
	requires javafx.controls;
	requires java.desktop;
	requires javafx.fxml;
	requires javafx.base;
	
	opens premsPackages to javafx.graphics, javafx.controls, javafx.fxml, javafx.base;

}