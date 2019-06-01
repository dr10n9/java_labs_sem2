import com.my.lab6.Progression;
import com.my.lab6.ProgressionException;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextField a0;
    @FXML
    TextField step;
    @FXML
    TextField n;
    @FXML
    TextArea result;

    private Progression progression;

    public Controller() {
        progression = new Progression();
    }

    public void defaultSum() {
        try {
            progression.setStep(Double.parseDouble(step.getText()));
            progression.setA0(Double.parseDouble(a0.getText()));
            result.setText("Sum: " + progression.getSum(Integer.parseInt(n.getText())));
        } catch (Exception e) {
            result.setText("Exception: " + e.toString());
        }
    }
    public void standard() {
        try {
            progression.setStep(Double.parseDouble(step.getText()));
            progression.setA0(Double.parseDouble(a0.getText()));
            result.setText("Sum: " + progression.getSumWithStandartExcpetion(Integer.parseInt(n.getText())));
        } catch (ArithmeticException e) {
            result.setText("Standard exception: " + e.toString());
        }
    }
    public void custom() {
        try {
            progression.setStep(Double.parseDouble(step.getText()));
            progression.setA0(Double.parseDouble(a0.getText()));
            result.setText("Sum: " + progression.getSumWithCustomException(Integer.parseInt(n.getText())));
        } catch (ProgressionException e) {
            result.setText("Custom exception: " + e.toString());
        }
    }
 }
