package viewer;

import mandelbrot.Complex;

/** A class to represent the view (a rectangle over the complex plane)
 * to be displayed. Some interesting views are already defined.
 *
 */
public class Camera {

  /** The high-level view of the Mandelbrot set.
   *
   */
  public static Camera camera0 =
    new Camera(
      -1.0,
      0.0,
      5,
      4./3.);

  /**
   * Some detail.
   */
  public static Camera camera1 =
    new Camera(
      0.001643721971153,
      0.822467633298876,
      0.0000003,
      4./3.);

  /**
   * Some other detail.
   */
  public static Camera camera2 =
        new Camera(
          -0.743643887037151,
          0.13182590420533,
          0.00003,
          4./3.
        );

  /**
   * Yet another detail.
   */
   public static Camera camera3 =
     new Camera(
       -0.82,
       -0.19,
       0.038,
       4./3.
     );

  private Complex center; /* Center of the rectangle */
  private Complex width; /* Vector for the width of the rectangle */
  private Complex height; /* Vector for the height of the rectangle */


  /** Creates a view.
   * @param centerX the real part of the point on which the view is centered
   * @param centerY the imaginary part of the point on which the view is centered
   * @param width the width of the rectangle to display
   * @param aspectRatio the ratio width/height of the rectangle to display
   */
  public Camera(double centerX, double centerY, double width, double aspectRatio) {
    this.width = Complex.real(width);
    this.height = new Complex(0,width / aspectRatio);
    this.center = new Complex(centerX, centerY);
  }

  /** Converts position relative to the rectangle defining the view
   * into absolute complex numbers.
   * @param tx horizontal relative position, between 0 (left) and 1 (right)
   * @param ty vertical relative position, between 0 (bottom) and 1 (top)
   * @return the complex at this position of the rectangle
   */
  public Complex toComplex(double tx, double ty) {
    return center.add(width.scale(tx - 0.5)).add(height.scale(ty));
  }

}
