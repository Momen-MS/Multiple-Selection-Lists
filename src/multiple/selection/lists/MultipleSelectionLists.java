/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiple.selection.lists;

import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author MOMEN
 */
public class MultipleSelectionLists extends Application {

    private ListView<String> list1;
    private ListView<String> list2;
    private Button copy;

    @Override
    public void start(Stage primaryStage) {
        list1 = new ListView<>();
        copy = new Button("Copy >>>");
        Label x = new Label("");
        list2 = new ListView<>();
        HBox list1box = new HBox(5, list1);
        list1box.setMaxHeight(200);
        list1box.setMaxWidth(200);

        HBox list2box = new HBox(5, list2);
        list2box.setMaxHeight(200);
        list2box.setMaxWidth(200);
        
        
         VBox Vbox = new VBox(10 , copy , x);
         copy.setAlignment(Pos.CENTER);
         x.setAlignment(Pos.BOTTOM_CENTER);
         Vbox.setAlignment(Pos.CENTER);
         Vbox.setMaxHeight(220);
         Vbox.setMaxWidth(80);
         Vbox.setMinWidth(80);
         Vbox.setMinHeight(220);
         
         
         
         
        HBox box = new HBox(5, list1box, Vbox, list2box);
        box.setMaxHeight(220);
        box.setMaxWidth(450);
        box.setMinWidth(450);
        box.setMinHeight(220);
        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER);

        list1.getItems().addAll("Black", "Blue", "Cyan ", "Dark Gray", "Gray", "Green"
                + "Champagne", "Crimson", "Maroon ", "Olive", "Puce", "Taupe", "Teal");
        list1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        list1.getItems().setAll(list1.getItems().stream().sorted().collect(Collectors.toList()));

        copy.setOnAction(e -> {
            if(!list2.getItems().isEmpty()){
            list2.getItems().clear();
            }
            if(!list1.getSelectionModel().isEmpty()){
            list2.getItems().addAll(list1.getSelectionModel().getSelectedItems());
            list1.getSelectionModel().clearSelection();
            }else {
                Alert ar = new Alert(AlertType.INFORMATION);
                ar.setHeaderText("Error...");
                ar.setContentText("There is no item seleced");
                ar.setTitle("Error");
                ar.show();
            }
        });

        Scene scene = new Scene(box, 400, 200);

        primaryStage.setTitle("Multiple Selection Lists");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
