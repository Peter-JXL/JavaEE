package chapter5Junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @Test
  public void testAdd(){
    System.out.println("Hello Junit!");
    Calculator c = new Calculator();
    int result = c.add(1,2);
    System.out.println(result);
  }
}
