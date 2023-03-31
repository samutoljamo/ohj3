package fi.tuni.prog3.calc;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class PrimaryController {
    @FXML private TextField fieldOp1;
    @FXML private TextField fieldOp2;
    @FXML private Label fieldRes;
    
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    private void add() throws IOException {
        double firstOperand = Double.parseDouble(fieldOp1.getText());
        double secondOperand = Double.parseDouble(fieldOp2.getText());
        
        double res = firstOperand+secondOperand;
        fieldRes.setText(String.valueOf(res));
    }
    @FXML
    private void subtract() throws IOException {
        double firstOperand = Double.parseDouble(fieldOp1.getText());
        double secondOperand = Double.parseDouble(fieldOp2.getText());
        
        double res = firstOperand-secondOperand;
        fieldRes.setText(String.valueOf(res));
    }
    @FXML
    private void multiply() throws IOException {
        double firstOperand = Double.parseDouble(fieldOp1.getText());
        double secondOperand = Double.parseDouble(fieldOp2.getText());
        
        double res = firstOperand*secondOperand;
        fieldRes.setText(String.valueOf(res));
    }
    @FXML
    private void divide() throws IOException {
        double firstOperand = Double.parseDouble(fieldOp1.getText());
        double secondOperand = Double.parseDouble(fieldOp2.getText());
        
        double res = firstOperand/secondOperand;
        fieldRes.setText(String.valueOf(res));
    }
}
