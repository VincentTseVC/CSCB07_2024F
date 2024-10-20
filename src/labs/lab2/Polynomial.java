package labs.lab2;

import java.io.*;
import java.util.Scanner;

public class Polynomial {

  private double[] coefficients;
  private int[] exponents;

  public Polynomial() {
    coefficients = new double[0]; // TODO: Ask Piazza [0] / [1]
    exponents = new int[0];
  }

  public Polynomial(double[] coefficients, int[] exponents) {
    this.coefficients = coefficients;
    this.exponents = exponents;
  }

  public Polynomial(File file) throws FileNotFoundException {
    // BufferedReader reader = new BufferedReader(new FileReader(file));
    // String line = reader.readLine();
    // reader.close();

    Scanner scanner = new Scanner(file);
    String line = scanner.nextLine();
    scanner.close();

    // line   => "5-3x2+7x8"
    // terms  => ["5", "-3x2", 7x8"]

    // insert a '+' sign in-front of every '-' sign
    // line   => "5-3x2+7x8"  -->  "5+-3x2+7x8"
    line = line.replace("-", "+-");
    String[] terms = line.split("\\+"); // Regular Expression (Regex)

    this.coefficients = new double[terms.length];
    this.exponents = new int[terms.length];

    // terms[i]            ceo   exp
    //  "-3x2"    --->    ["-3", "2"]
    //  "5"       --->    ["5"]

    for (int i = 0; i < terms.length; i++) {
      String[] ceo_exp = terms[i].split("x");
      this.coefficients[i] = Double.parseDouble(ceo_exp[0]);
      this.exponents[i] = (ceo_exp.length == 1) ? 0: Integer.parseInt(ceo_exp[1]);
    }
  }

  public Polynomial add(Polynomial other) {
    // if (this.exponents.length == 1 && this.exponents[0] == 0)
    if (this.exponents.length == 0)
      return new Polynomial(other.coefficients, other.exponents);
    if (other.exponents.length == 0)
      return new Polynomial(this.coefficients, this.exponents);

    // this   => 6 - 2x + 5x3 + 2x4 => [6, -2, 5, 2] and [0, 1, 3, 4]
    // other  => 5 + 2x + 6x4       => [5,  2, 6]    and [0, 1, 4]

    // res    => 11 + 5x3 + 8x4

    // => 4
    int max_exp = Math.max(this.exponents[this.exponents.length-1],
                           other.exponents[other.exponents.length-1]);

    // temp_coe => [0, 0, 0, 0, 0]
    double[] temp_coe = new double[max_exp + 1];

    // temp_coe => [6, -2, 0, 5, 2]
    for (int i = 0; i < this.coefficients.length; i++)
      temp_coe[this.exponents[i]] = this.coefficients[i];

    // temp_coe => [11, 0, 0, 5, 8]
    for (int i = 0; i < other.coefficients.length; i++)
      temp_coe[other.exponents[i]] += other.coefficients[i];

    // [11, 0, 0, 5, 8] => [11, 5, 8] and [0, 3, 4]

    // count how many non-zero coefficients
    int len = 0;
    for (int i = 0; i < temp_coe.length; i++) if (temp_coe[i] != 0) len++;

    double[] new_coe = new double[len];
    int[] new_exp = new int[len];

    // new_ceo => [11, 5, 8]
    // new_exp => [0, 3, 4]
    int j = 0;
    for (int i = 0; i < temp_coe.length; i++) {
      if (temp_coe[i] != 0) {
        new_coe[j] = temp_coe[i];
        new_exp[j] = i;
        j++;
      }
    }

    return new Polynomial(new_coe, new_exp);
  }

  // 2789 Example       ceo         exp
  // 1 + x + x2  =>   [1, 1, 1]   [0, 1, 2]
  // 2x2 + x4    =>   [2, 1]      [2, 4]

  // temp_ceo   => [0, 0, 0, 0, 0]
  // for this   => [1, 1, 1, 0, 0]
  // for other  => [1, 1, 3, 0, 1]  => [1, 1, 3, 1]  [0, 1, 2, 4]

  public Polynomial multiply(Polynomial other) {
    // if (this.exponents.length == 1 && this.exponents[0] == 0)
    if (this.exponents.length == 0)
      return new Polynomial(other.coefficients, other.exponents);
    if (other.exponents.length == 0)
      return new Polynomial(this.coefficients, this.exponents);

    // this   => 6 - 2x + 5x3 + 2x4 => [6, -2, 5, 2] and [0, 1, 3, 4]
    // other  => 5 + 2x + 6x4       => [5,  2, 6]    and [0, 1, 4]

    // res    => 30 - 4x2 + 5x3 + 12x8 ****************

    // => 4
    int max_exp = Math.max(this.exponents[this.exponents.length-1],
                           other.exponents[other.exponents.length-1]);

    // temp_coe => [0, 0, 0, 0, 0]
    double[] temp_coe = new double[max_exp + 1];

    // temp_coe => [6, -2, 0, 5, 2]
    for (int i = 0; i < this.coefficients.length; i++)
      temp_coe[this.exponents[i]] = this.coefficients[i];

    // temp_coe => [30, -4, 0, 5, 12]
    for (int i = 0; i < other.coefficients.length; i++) {
      if (temp_coe[other.exponents[i]] == 0)
        temp_coe[other.exponents[i]] = other.coefficients[i];
      else
        temp_coe[other.exponents[i]] *= other.coefficients[i];
    }


    // [30, -4, 0, 5, 12] => [30, -4, 5, 12] and [0, 1, 3, 4]

    // count how many non-zero coefficients
    int len = 0;
    for (int i = 0; i < temp_coe.length; i++) if (temp_coe[i] != 0) len++;

    double[] new_coe = new double[len];
    int[] new_exp = new int[len];

    // new_ceo => [30, -4, 5, 12]
    // new_exp => [0, 1, 3, 4]
    int j = 0;
    for (int i = 0; i < temp_coe.length; i++) {
      if (temp_coe[i] != 0) {
        new_coe[j] = temp_coe[i];
        new_exp[j] = i;
        j++;
      }
    }

    return new Polynomial(new_coe, new_exp);
  }

  public double evaluate(double x) {
    double res = 0.0;
    for (int i = 0; i < this.coefficients.length; i++)
      res += this.coefficients[i] * Math.pow(x, this.exponents[i]);
    return res;
  }

  public boolean hasRoot(double x) {
    return evaluate(x) == 0.0;
  }

  public double[] getCoefficients() {
    return coefficients;
  }

  public int[] getExponents() {
    return exponents;
  }

  public String toString() {
    String result = "Coe:\n";
    for (int i = 0; i < coefficients.length; i++) {
      result += coefficients[i] + " ";
    }
    result += "\nExp:\n";

    for (int i = 0; i < exponents.length; i++) {
      result += exponents[i] + " ";
    }
    return result;
  }

  public void saveToFile(String filename) throws IOException {
    // TODO: use printStream?
    FileWriter writer = new FileWriter(filename);
    String line = "";

    // Example: 單獨處理 x0
    // String line = "" + coefficients[0] + ((exponents[0] == 0) ? "" : exponents[0]);
    // for (int i = 1; ...)

    for (int i = 0; i < this.coefficients.length; i++) {
      // TODO: 可以檢查 exponents 是否是 0, 單獨處理一下 (不能加 'x', 'x0')
      //       可以檢查 coefficients 是否是 .0, 可以處理一下 (parseInt) [問 PIAZZA]
      //       可以撿查, '-' 是不是不要 加上 '+'

      line += this.coefficients[i] + "x" + this.exponents[i] + "+";
    }

    // coefficients   => [5,  2, 6]
    // exponents      => [0, 1, 4]
    // 第一次 for 結束, line => "5x0+"

    line += "Nioki";

    // VC 的想法 :)
    line = line
            .replace("+-", "-")
            .replace("x0", "")
            .replace("x1", "x") // TODO: Ask Piazza
            .replace(".0", "")
            .replace("+Nioki", ""); // delete the last '+' sign

    writer.write(line);
    writer.close();

  }
}