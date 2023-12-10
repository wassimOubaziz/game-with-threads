module app.dacproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens app.dacproject to javafx.fxml;
    exports app.dacproject;
    exports app.dacproject.classes;
    opens app.dacproject.classes to javafx.fxml;
}