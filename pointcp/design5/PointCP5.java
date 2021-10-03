package design5;

import design2.PointCP2;
import design3.PointCP3;

public abstract class PointCP5 {

	  private char typeCoord;
	  
	  
	  private double xOrRho;
	  
	
	  private double yOrTheta;
	  
	  public abstract double getX();
	  public abstract double getY();
	  public abstract double getRho();
	  public abstract double getTheta();
	  public abstract PointCP2 convertStorageToPolar();
	  public abstract PointCP3 convertStorageToCartesian();
	  public abstract double getDistance(PointCP5 point);
	  public abstract PointCP5 rotatePoint(double rotation);
	public abstract char getType();
}
