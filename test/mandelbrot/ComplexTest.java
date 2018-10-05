package mandelbrot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexTest {

  @Test
  void onePlusOneIsTwo() {
    assertEquals(Complex.real(2), Complex.ONE.add(Complex.ONE));
  }

}