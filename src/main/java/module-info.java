module com.rocoplayer {
	
    requires javafx.controls;
    requires javafx.fxml;
    
    requires com.jfoenix;
    
    requires org.apache.commons.lang3;
    requires io.netty.all;
    requires commons.math;
    
    
    requires org.bytedeco.javacv;
    requires org.bytedeco.javacpp;
    requires org.bytedeco.ffmpeg;
    requires org.bytedeco.ffmpeg.windows.x86_64;
    
    //每个动态库都需要require，如果没有用到opencv可以去掉，还能小很多空间
    requires org.bytedeco.opencv;
    requires org.bytedeco.opencv.windows.x86_64;
    requires org.bytedeco.openblas;
    requires org.bytedeco.openblas.windows.x86_64;

    opens com.rocoplayer.app.ctrl to javafx.fxml;
    

    exports com.rocoplayer.app;
}

