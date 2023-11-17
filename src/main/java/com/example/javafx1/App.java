package com.example.javafx1;

import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

import java.util.List;

public class App {
    private final HBox hBox = new HBox();
    private final TextField xField = new TextField();
    private final TextField yField = new TextField();
    private final TextField sumField = new TextField();
    private final ComboBox<Model.Operation> opCombo2 = new ComboBox<>();

    App(Model model) {
        opCombo2.getItems().addAll(Model.Operation.values());
        sumField.setEditable(false);
        sumField.setFocusTraversable(false);
        StringConverter<Number> converter = new StringConverter<>() {
            public String toString(Number number) {
                return String.valueOf(number);
            }

            public Number fromString(String s) {
                return Long.parseLong(s);
            }
        };
        xField.textProperty().bindBidirectional(model.xProperty(), converter);
        yField.textProperty().bindBidirectional(model.yProperty(), converter);
        opCombo2.valueProperty().bindBidirectional(model.op2Property());
        sumField.textProperty().bind(model.getSumBinding().asString());

        hBox.getChildren().addAll(List.of(
            xField, opCombo2, yField,
            new Text("="), sumField));
    }

    Parent getView() {
        return hBox;
    }

}
