import com.test.*;
import javafx.application.*;
import javafx.stage.Stage;

import java.util.List;
import java.util.ArrayList;


public class Main {
    // @Override
    // public void start(Stage primaryStage) {
        
    // }

    // public static void main() { launch(args); }
    public static void main(String [] args) {
        Progression progression = new Progression(1, 2.345);
        for(int i = 0; i < 20; i++) {
            progression.next();
        }
        System.out.println(progression.sum(21));
        System.out.println(progression.sum());
        System.out.println(Math.round(progression.sum()) == Math.round(progression.sum(21)));
        try {
            progression.throwException();
        } catch (CustomException e) {
            System.out.println(e.toString() + "\n" + e.getNumber());
        }
    }    
}