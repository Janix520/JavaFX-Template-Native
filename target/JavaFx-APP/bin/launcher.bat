@echo off
set JLINK_VM_OPTIONS=--add-exports javafx.controls/com.sun.javafx.scene.control.behavior=com.jfoenix --add-exports javafx.base/com.sun.javafx.event=com.jfoenix --add-exports javafx.controls/javafx.scene.control=com.google.gson --add-opens com.jfoenix/com.jfoenix.controls.datamodels.treetable=com.google.gson
set DIR=%~dp0
"%DIR%\java" %JLINK_VM_OPTIONS% -m com.rocoplayer/com.rocoplayer.app.App %*
