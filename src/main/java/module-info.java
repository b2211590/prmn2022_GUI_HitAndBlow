module com.example.saisyuukadai {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.saisyuukadai to javafx.fxml;
    exports com.example.saisyuukadai;

    exports sample;
    opens sample to javafx.fxml;

    opens HandB to javafx.fxml;
    exports HandB;
}