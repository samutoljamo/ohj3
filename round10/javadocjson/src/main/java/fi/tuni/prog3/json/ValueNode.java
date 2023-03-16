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
     * Constructs a JSON value node that stores the given number.
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
    * @return true if this value node stores a boolean value, false otherwise.
    */
    boolean isBoolean() {
        return this._valueType == ValueType.BOOLEAN;
    }
    /**
     * Checks whether this value node stores a number(double).
     * @return true if this value node stores a number, false otherwise.
     */
    boolean isNumber() {
        return this._valueType == ValueType.NUMBER;
    }


    /**
     * Checks whether this value node stores a string.
     * @return true if this value node stores a string, false otherwise.
     */
    boolean isString() {
        return this._valueType == ValueType.STRING;
    }
    /**
     * Checks whether this value node stores the null value.
     * @return true if this value node stores the null value, false otherwise.
     */
    boolean isNull() {
        return this._valueType == ValueType.NULL;
    }

    /**
     * Returns the boolean value stored in this value node.
     * @return the boolean value stored in this value node.
     */
    boolean getBoolean() {
        return this._value3;
    }
    /**
     * Returns the number stored in this value node.
     * @return the number stored in this value node.
     */
    double getNumber() {
        return this._value;
    }
    /**
     * Returns the String stored in this value node.
     * @return the String stored in this value node.
     */
    String getString() {
        return this._value2;
    }
    /**
     * Returns the null value stored in this value node.
     * @return the null value stored in this value node.
     */
    Object getNull() {
        return null;
    }
    
}
