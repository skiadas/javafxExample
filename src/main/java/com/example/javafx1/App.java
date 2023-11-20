package com.example.javafx1;

import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.List;

public class App {
    private final HBox hBox = new HBox();
    private final TextField xField = new TextField();
    private final TextField yField = new TextField();
    private final TextField sumField = new TextField();
    private final ComboBox<String> opCombo2 = new ComboBox<>();
    private final ViewModel vm;

    App(ViewModel viewModel) {
        vm = viewModel;
        sumField.setEditable(false);
        sumField.setFocusTraversable(false);

        xField.textProperty().bindBidirectional(vm.x);
        yField.textProperty().bindBidirectional(vm.y);
        sumField.textProperty().bind(vm.result);
        opCombo2.itemsProperty().bindBidirectional(vm.opChoices);
        opCombo2.valueProperty().bindBidirectional(vm.op);

        hBox.getChildren().addAll(List.of(
            xField, opCombo2, yField,
            new Text("="), sumField));
    }

    Parent getView() {
        return hBox;
    }

}
