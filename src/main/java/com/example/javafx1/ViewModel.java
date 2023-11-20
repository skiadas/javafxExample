package com.example.javafx1;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ViewModel {
    private static final StringConverter<Number> converter = new StringConverter<>() {
        public String toString(Number number) {
            return String.valueOf(number);
        }

        public Number fromString(String s) {
            return Long.parseLong(s);
        }
    };
    private static final StringConverter<Model.Operation> stringOpConverter = new StringConverter<>() {
        public String toString(Model.Operation op) {
            return op.toString();
        }

        public Model.Operation fromString(String s) {
            return Model.Operation.fromSign(s);
        }
    };
    StringProperty x = new SimpleStringProperty();
    StringProperty y = new SimpleStringProperty();
    StringProperty op = new SimpleStringProperty();
    StringProperty result = new SimpleStringProperty();
    private ObservableList<String> list = FXCollections.observableArrayList();
    ListProperty<String> opChoices = new SimpleListProperty<>(list);
    private Model model;

    public ViewModel(Model model) {
        this.model = model;
        List<String> strings =
                Arrays.stream(Model.Operation.values())
                        .map(Enum::toString)
                        .collect(Collectors.toList());
        list.addAll(strings);
        op.bindBidirectional(model.op2Property(), stringOpConverter);
        x.bindBidirectional(model.xProperty(), converter);
        y.bindBidirectional(model.yProperty(), converter);
        result.bind(model.getSumBinding().asString());
    }
}
