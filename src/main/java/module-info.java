module com.rocoplayer {
	
    requires javafx.controls;
    requires javafx.fxml;
    
    requires com.jfoenix;
    
    requires org.apache.commons.lang3;
    requires io.netty.all;
    requires commons.math;
    

    opens com.rocoplayer.app.ctrl to javafx.fxml;
    

    exports com.rocoplayer.app;
}

