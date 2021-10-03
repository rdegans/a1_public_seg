package design3;

import design2.PointCP2;
import design5.PointCP5;

public class PointCP3 extends PointCP5 {
	private double x;
	private double y;

	// Constructors ******************************************************

	/**
	 * Constructs a coordinate object, with a type identifier.
	 */

	public PointCP3(char type, double xOrRho, double yOrTheta) {
		if (type != 'C' && type != 'P')
			throw new IllegalArgumentException();
		else if (type == 'P') {
			this.x = Math.cos(Math.toRadians(yOrTheta)) * xOrRho;
			this.y = Math.sin(Math.toRadians(yOrTheta)) * xOrRho;
		} else {
			this.x = xOrRho;
			this.y = yOrTheta;
		}
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRho() {
		return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
	}

	@Override
	public double getTheta() {

		return Math.toDegrees(Math.atan2(y, x));
	}

	public char getType() {

		return 'C';
	}

	/**
	 * Converts cartesion coordinates to Polarcoordinates.
	 */
	@Override
	public PointCP2 convertStorageToPolar() {
		return new PointCP2('P', getRho(), getTheta());
	}

	@Override
	public PointCP3 convertStorageToCartesian() {

		return new PointCP3('C', this.x, this.y);
	}

	/**
	 * Calculates the distance in between two points using the Pythagorean theorem
	 * (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
	 *
	 * @param pointA The first point.
	 * @param pointB The second point.
	 * @return The distance between the two points.
	 */
	@Override
	public double getDistance(PointCP5 point) {
		// TODO Auto-generated method stub
		return Math.sqrt((Math.pow(getX() - point.getX(), 2) + Math.pow(getY() - point.getY(), 2)));
	}

	/**
	 * Calculates the distance in between two points using the Pythagorean theorem
	 * (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
	 *
	 * @param pointA The first point.
	 * @param pointB The second point.
	 * @return The distance between the two points.
	 */
	/**
	 * Rotates the specified point by the specified number of degrees. Not required
	 * until E2.30
	 *
	 * @param point    The point to rotate
	 * @param rotation The number of degrees to rotate the point.
	 * @return The rotated image of the original point.
	 */
	@Override
	public PointCP3 rotatePoint(double rotation) {
		// TODO Auto-generated method stub
		double radian = Math.toRadians(rotation);
		return new PointCP3('C', (Math.cos(radian) * getX()) - (Math.sin(radian) * getY()),
				(Math.cos(radian) * getX()) + (Math.sin(radian) * getY()));
	}

	/**
	 * Returns information about the coordinates.
	 *
	 * @return A String containing information about the coordinates.
	 */
	public String toString() {
		return "Stored as Cartesian [" + x + "," + y + "]" + "\n";
	}

}
