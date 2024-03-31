module gridpanel.newproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens gridpanel.newproject to javafx.fxml;
    exports gridpanel.newproject;
    exports gridpanel.newproject.view;
    opens gridpanel.newproject.view to javafx.fxml;
}