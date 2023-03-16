package fi.tuni.prog3.json;

enum ValueType {
    NUMBER,
    STRING,
    BOOLEAN,
    NULL
}
/**
 * A class for representing a JSON value. The value can be either a double, a boolean, a String or null.
 */
public class ValueNode extends Node {
    private double _value;
    private String _value2;
    private boolean _value3;

    Enum _valueType;
    /**
     * Constructs a JSON value node that stores the null value.
     */
    public ValueNode(){
        _valueType = ValueType.NULL;
    }

    /**
     * Constructs a JSON value node that stores the given boolean value.
     * @param value the boolean value to be stored.
     */
    public ValueNode(boolean value) {
        this._value3 = value;
        this._valueType = ValueType.BOOLEAN;
    }

    /**
     * Constructs a JSON value node that stores the given double value.
     * @param value the number to be stored.
     */
    public ValueNode(double value) {
        this._value = value;
        this._valueType = ValueType.NUMBER;
    }

    /**
     * Constructs a JSON value node that stores the given String.
     * @param value the String to be stored.
     */
    public ValueNode(String value) {
        this._value2 = value;
        this._valueType = ValueType.STRING;
    }    
    
    /**
    * Checks whether this value node stores a boolean value.
    * @return true if this node stores a boolean value, otherwise false.
    */
    public boolean isBoolean() {
        return this._valueType == ValueType.BOOLEAN;
    }
    /**
     * Checks whether this value node stores a number (double).
     * @return true if this node stores a double value, otherwise false.
     */
    public boolean isNumber() {
        return this._valueType == ValueType.NUMBER;
    }


    /**
     * Checks whether this value node stores a string.
     * @return true if this node stores a string, otherwise false.
     */
    public boolean isString() {
        return this._valueType == ValueType.STRING;
    }
    /**
     * Checks whether this value node stores null.
     * @return true if this node stores null, otherwise false.
     */
    public boolean isNull() {
        return this._valueType == ValueType.NULL;
    }

    /**
     * Returns the stored value as a boolean value.
     * @return the stored boolean value.
     */
    public boolean getBoolean() {
        return this._value3;
    }
    /**
     * Returns the stored value as a number (double).
     * @return the stored number as a double value.
     */
    public double getNumber() {
        return this._value;
    }
    /**
     * Returns the stored value as a string.
     * @return the stored string.
     */
    public String getString() {
        return this._value2;
    }
    /**
     * Returns the stored value as null.
     * @return null.
     */
    public Object getNull() {
        return null;
    }
    
}
