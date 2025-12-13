import java.nio.file.Files;
import java.nio.file.Path;
import java.math.BigInteger;

public class Euler13 {
  public static void main(String[] args) throws Exception {
    var sum = Files.lines(Path.of("euler13.txt"))
      .map(BigInteger::new)
      .reduce(BigInteger.ZERO, BigInteger::add)
      .toString();

    System.out.println(sum.substring(0, 10));
  }
}
