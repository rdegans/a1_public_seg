package design5;

import design2.PointCP2;
import design3.PointCP3;

public abstract class PointCP5 {
	/**
	   * Contains C(artesian) or P(olar) to identify the type of
	   * coordinates that are being dealt with.
	   */
	  private char typeCoord;
	  
	  /**
	   * Contains the current value of X or RHO depending on the type
	   * of coordinates.
	   */
	  private double xOrRho;
	  
	  /**
	   * Contains the current value of Y or THETA value depending on the
	   * type of coordinates.
	   */
	  private double yOrTheta;
	  
	  public abstract double getX();
	  public abstract double getY();
	  public abstract double getRho();
	  public abstract double getTheta();
	  public abstract PointCP2 convertStorageToPolar();
	  public abstract PointCP3 convertStorageToCartesian();
	  public abstract double getDistance(PointCP5 point);
	  public abstract PointCP5 rotatePoint(double rotation);
}
