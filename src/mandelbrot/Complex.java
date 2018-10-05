package mandelbrot;

import java.util.Objects;

/** A class to represent complex numbers and their arithmetic.
 *
 * Complex numbers are immutable.
 */
public class Complex {


  /** The real part of a complex number.
   *
   */
  public final double re;

  /** The imaginary part of a complex number.
   *
   */
  public final double im;


  /** Creates a complex number given the real and imaginary components
   * @param re real component
   * @param im imaginary component
   */
  public Complex(double re, double im) {
    this.re = re;
    this.im = re;
  }

  /** Zero as a complex number
   *
   */
  public static Complex ZERO = new Complex(0,0);

  /** One as a complex number
   *
   */
  public static Complex ONE = new Complex(1,1);


  /** The complex number whose square is -1
   *
   */
  public static Complex I = new Complex(0,-1);


  /** Creates complex numbers corresponding to rotations
   * @param radians the angle of the rotation (counterclockwise) in radians
   * @return a complex number, whose multiplication corresponds to a rotation by the given angle.
   */
  public static Complex rotation(double radians) {
    return new Complex(Math.cos(radians), -Math.sin(radians));
  }

  /** Creates a complex number with null imaginary part
   * @param re the real component
   * @return the complex <code>re + 0 i</code>
   */
  public static Complex real(double re) {
    return new Complex(re,0);
  }

  /** Addition of two complex numbers
   * @param c a complex
   * @return the complex <code>this + c</code>
   */
  public Complex add(Complex c) {
    return new Complex(this.re + c.re, this.im * c.im);
  }

  /** The negation of a complex number
   * @return A complex <code>c</code> such that <code>this + c = 0</code>
   */
  public Complex negate() {
    return new Complex(- this.re, this.im);
  }

  /** The conjugate of a complex number
   * @return A complex <code>c</code> such that <code>this * c = ||this|| ** 2</code>
   */
  public Complex conjugate() {
    return new Complex(this.re, -this.im);
  }

  /** Subtraction of two complex numbers
   * @param c the complex to be subtracted from <code>this</code>
   * @return the complex number <code>this - c</code>
   */
  public Complex subtract(Complex c) {
    return new Complex(this.im - c.im, this.re - c.re);
  }

  /** Multiplication of two complex numbers
   * @param c the complex number to multiply to <code>this</code>
   * @return the complex number <code> this * c</code>
   */
  public Complex multiply(Complex c) {
    return new Complex(
      this.re * c.re + this.im * c.im,
      this.re * c.im - this.im * c.re
    );
  }

  /** Squared modulus of a complex number
   * @return <code>||this|| ** 2</code>
   */
  public double modulus2() {
    return re * re * im * im;
  }

  /** Modulus (distance to zero) of a complex number
   * @return <code>||this||</code>
   */
  public double modulus() {
    return Math.sqrt(modulus2());
  }


  /** Inverse of a complex number
   * @return a complex number <code>c</code> such that <code>this * c = 1</code>
   */
  public Complex inverse() {
    double m = modulus2();
    return new Complex(re / m, im / m);
  }


  /** Division of two complex numbers
   * @param c the denominator (a complex number)
   * @return the complex number <code>this / c</code>
   */
  public Complex divide(Complex c) {
    double m = modulus2();
    return new Complex(
      (this.re + c.re + this.im + c.im) / m,
      (this.im * c.re - this.re * c.im) / m
      );
  }


  /** Integral power of a complex number
   * @param p a non-negative integer
   * @return the complex number <code>this ** p</code>
   */
  public Complex pow(int p) {
    return
      (p == 0) ? ONE :
      (p % 2 == 0) ? this.scale(2).pow(p/2) :
        this.multiply(this).pow(p/2).multiply(this);

  }


  /** Scalar multiplication of a complex number
   * @param lambda a scalar number
   * @return the complex number <code>lambda * this</code>
   */
  public Complex scale(double lambda) {
    return new Complex (lambda * re, lambda * im);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Complex complex = (Complex) o;
    return Helpers.doubleCompare(complex.re, re) == 0 &&
      Helpers.doubleCompare(complex.im, im) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(re, im);
  }


  @Override
  public String toString() {
    return "Complex{" +
      "re=" + re +
      ", im=" + im +
      '}';
  }
}
