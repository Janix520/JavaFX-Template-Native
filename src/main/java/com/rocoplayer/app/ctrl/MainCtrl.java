package com.rocoplayer.app.ctrl;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * 主界面控制器
 */
public class MainCtrl implements Initializable {

	// 主容器
	public Pane rootPane;

	/**
	 * fx:id="btnAlert"，因为fxml里绑定了ctrl类，直接可以通过fx:id和变量名绑定 这里注意需要使用public
	 */
	public Button btnAlert;
	public Button btnChooseFile;

	/**
	 * init fxml view
	 */
	public void initialize(URL location, ResourceBundle resources) {

		btnAlert.setOnAction((event) -> {
			onBtnAlertClick(event);
		});

		btnChooseFile.setOnAction((event) -> {
			onchooseFile(event);
		});
	}

	/**
	 * 弹出框按钮单击事件
	 * 
	 * @param actionEvent
	 */
	public void onBtnAlertClick(ActionEvent actionEvent) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setContentText("你好");
		alert.show();
	}

	/**
	 * 选择文件按钮单机事件
	 * 
	 * @param actionEvent
	 */
	public void onchooseFile(ActionEvent actionEvent) {
		Window window = rootPane.getScene().getWindow();
		FileChooser fileChooser = new FileChooser();
//        fileChooser.setInitialDirectory(null);
		// 文件类型过滤器
		/*
		 * FileChooser.ExtensionFilter filter = new
		 * FileChooser.ExtensionFilter("Excel files (*.xls, *.xlsx)", "*.xls",
		 * "*.xlsx"); fileChooser.getExtensionFilters().add(filter);
		 */
		// ...
		File file = fileChooser.showOpenDialog(window);
		String fileName = file == null ? "" : file.getName();
		String fileAbsolutePath = file == null ? "" : file.getAbsolutePath();

		if (file != null) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("文件路径：" + fileAbsolutePath);
			alert.show();
		}
	}

}
