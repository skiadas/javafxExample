package com.example.javafx1;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.LongBinding;
import javafx.beans.property.*;

public class Model {
    LongProperty x = new SimpleLongProperty(5);
    LongProperty y = new SimpleLongProperty(10);
    String op = "+";
    ObjectProperty<Operation> op2 = new SimpleObjectProperty<>(Operation.PLUS);

    public Model() {}

    void setOp(String op) {
        this.op = op;
    }

    long getX() {
        return x.getValue();
    }

    void setX(long x) {
        this.x.setValue(x);
    }

    LongProperty xProperty() {
        return x;
    }

    long getY() {
        return y.getValue();
    }


    void setY(long y) {
        this.y.setValue(y);
    }

    LongProperty yProperty() {
        return y;
    }

    long getSum() {
        switch (op2.getValue()) {
            case PLUS: return getX() + getY();
            case MINUS: return getX() - getY();
            case DIVIDE: return getX() / getY();
            case TIMES: return getX() * getY();
        }
        throw new RuntimeException();
    }

    LongBinding getSumBinding() {
        return Bindings.createLongBinding(this::getSum, x, y, op2);
    }

    String getOp() {
        return op;
    }

    Property<Operation> op2Property() {
        return op2;
    }

    public enum Operation {
        PLUS {
            public String toString() {
                return "+";
            }
        }, MINUS {
            public String toString() {
                return "-";
            }
        }, TIMES {
            public String toString() {
                return "*";
            }
        }, DIVIDE {
            public String toString() {
                return "/";
            }
        };
    }
}