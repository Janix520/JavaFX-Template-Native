package com.rocoplayer.app;

import java.io.IOException;

import com.jfoenix.assets.JFoenixResources;
import com.rocoplayer.app.config.AppConfig;
import com.rocoplayer.app.util.AppUtil;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * JavaFX Template Native APP
 * 
 * @author ZJ
 *
 */
public class App extends Application {

	public static void main(String[] args) {
		AppConfig.init();
		launch();
	}
	
	

//    @Override
//	public void init() throws Exception {
//		// TODO Auto-generated method stub
//		super.init();
//		
//		// 设置系统屏幕缩放比例
//        try {
//            var scaleX =  Screen.getScreens().get(0).getOutputScaleX();
//            System.setProperty("glass.win.uiScale", String.valueOf(scaleX));
//        } catch (Exception ignored) {
//            System.setProperty("glass.win.uiScale", "1.0");
//        }
//	}

	@Override
	public void init() throws Exception {
		super.init();
		
//		SingleAppCheckUtil.check();
	}



	@Override
	public void start(Stage stage) throws IOException {
//        log.info("start");
		// 加载并创建主场景
		Parent root = FXMLLoader.load(App.class.getResource("fxml/Main.fxml"));

		ImageView iconView = new ImageView(new Image(App.class.getResourceAsStream(AppConfig.icon)));
		iconView.setFitHeight(24);
		iconView.setFitWidth(24);

		Scene scene = new Scene(root, AppConfig.stageWidth, AppConfig.stageHeight);

		final ObservableList<String> stylesheets = scene.getStylesheets();
		stylesheets.addAll(JFoenixResources.load("css/jfoenix-fonts.css").toExternalForm(),
				JFoenixResources.load("css/jfoenix-design.css").toExternalForm());

		// 设置窗口信息
		stage.setTitle(AppConfig.title);
		stage.setResizable(AppConfig.stageResizable);
		stage.getIcons().add(new Image(App.class.getResourceAsStream(AppConfig.icon)));
		stage.setScene(scene);
		stage.show();

		stage.setOnCloseRequest(event -> {
        	AppUtil.exitApp();
		});

	}


}
