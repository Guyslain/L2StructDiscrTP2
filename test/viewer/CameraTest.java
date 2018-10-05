package viewer;

import mandelbrot.Complex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CameraTest {

  @Test
  void toComplex() {
    Camera camera = new Camera(0,0,8,4./3.);
  }
}