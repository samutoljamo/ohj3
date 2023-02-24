enum ValueType {
    NUMBER,
    STRING,
    BOOLEAN,
    NULL
}

public class ValueNode extends Node {
    private double _value;
    private String _value2;
    private Boolean _value3;

    Enum _valueType;

    public ValueNode(){
        _valueType = ValueType.NULL;
    }

    public ValueNode(double value) {
        this._value = value;
        this._valueType = ValueType.NUMBER;
    }

    public ValueNode(String value) {
        this._value2 = value;
        this._valueType = ValueType.STRING;
    }

    public ValueNode(Boolean value) {
        this._value3 = value;
        this._valueType = ValueType.BOOLEAN;
    }

    Boolean isNumber() {
        return this._valueType == ValueType.NUMBER;
    }

    Boolean isString() {
        return this._valueType == ValueType.STRING;
    }

    Boolean isNull() {
        return this._valueType == ValueType.NULL;
    }

    Boolean isBoolean() {
        return this._valueType == ValueType.BOOLEAN;
    }

    double getNumber() {
        return this._value;
    }
    
    String getString() {
        return this._value2;
    }

    Boolean getBoolean() {
        return this._value3;
    }

    Object getNull() {
        return null;
    }
    
}
