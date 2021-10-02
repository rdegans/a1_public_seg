package design2;

import design3.PointCP3;

public class PointCP2 {
	  
	  /**
	   * Contains the current value of X or RHO depending on the type
	   * of coordinates.
	   */
	  private double rho;
	  
	  /**
	   * Contains the current value of Y or THETA value depending on the
	   * type of coordinates.
	   */
	  private double theta;
		
	  
	  //Constructors ******************************************************

	  /**
	   * Constructs a coordinate object, with a type identifier.
	   */
	  public PointCP2(char type, double rho, double theta)
	  {
	    if(type != 'C' && type != 'P')
	      throw new IllegalArgumentException();
	    else if (type=='C') {
	    	this.rho=(Math.sqrt(Math.pow(rho, 2) + Math.pow(theta, 2)));
	    	this.theta=Math.toDegrees(Math.atan2(theta, rho));
	    } else if (type=='P') {
	    	this.rho=rho;
	    	this.theta=theta;
	    }
	  }
		
	  
	  //Instance methods **************************************************
	 
	 
	  public double getX()
	  {
	    
	      return (Math.cos(Math.toRadians(theta)) * rho);
	  }
	  
	  public double getY()
	  {
	   
	      return (Math.sin(Math.toRadians(theta)) * rho);
	  }
	  
	  public double getRho()
	  {
	      return rho;
	   
	  }
	  
	  public double getTheta()
	  { 
	      return theta;
	   
	  }
	  
	  /**
	   * Converts Polar coordinates to Cartesian coordinates.
	   */
	  public PointCP3 convertStorageToCartesian()
	  {
		  double y =getY();
		  double x=getX();
		  return new PointCP3('C',x,y);
	  }
	  public PointCP2 convertStorageToPolar() {
		  return new PointCP2('P',this.rho,this.theta);
	  }

	  /**
	   * Calculates the distance in between two points using the Pythagorean
	   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
	   *
	   * @param pointA The first point.
	   * @param pointB The second point.
	   * @return The distance between the two points.
	   */
	  public double getDistance(PointCP2 pointB)
	  {
	    // Obtain differences in X and Y, sign is not important as these values
	    // will be squared later.
	    double deltaX = getX() - pointB.getX();
	    double deltaY = getY() - pointB.getY();
	    
	    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	  }

	  /**
	   * Rotates the specified point by the specified number of degrees.
	   * Not required until E2.30
	   *
	   * @param point The point to rotate
	   * @param rotation The number of degrees to rotate the point.
	   * @return The rotated image of the original point.
	   */
	  public PointCP2 rotatePoint(double rotation)
	  {
		  double newRho= this.getRho()+rotation;
		  return new PointCP2('P',newRho,this.getTheta());
	  }

	  /**
	   * Returns information about the coordinates.
	   *
	   * @return A String containing information about the coordinates.
	   */
	  public String toString()
	  {
	    return "Stored as Polar" +"[" + getRho() + "," + getTheta() + "]" + "\n";
	  }
}
