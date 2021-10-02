package design3;

import design2.PointCP2;
import design5.PointCP5;

public class PointCP3 extends PointCP5{
	private double x;
	private double y;
	
	public PointCP3(char type, double xOrRho, double yOrTheta) {
		if(type != 'C' && type != 'P')
		      throw new IllegalArgumentException();
		else if(type=='P') {
			this.x=Math.cos(Math.toRadians(yOrTheta)) * xOrRho;
			this.y=Math.sin(Math.toRadians(yOrTheta)) * xOrRho;
		}else {
			this.x=xOrRho;
			this.y=yOrTheta;
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

	@Override
	public PointCP2 convertStorageToPolar() {
		
		double x=getRho();
		double y=getTheta();
		return new PointCP2('P',x,y);
	}

	@Override
	public PointCP3 convertStorageToCartesian() {
		
		return new PointCP3('C',this.x,this.y);
	}

	@Override
	public double getDistance(PointCP5 point) {
		// TODO Auto-generated method stub
		return Math.sqrt((Math.pow(getX()-point.getX(), 2)+Math.pow(getY()-point.getY(), 2)));
	}

	@Override
	public PointCP3 rotatePoint(double rotation) {
		// TODO Auto-generated method stub
		double radian=Math.toRadians(rotation);
		return new PointCP3('C',(Math.cos(radian)*getX())-(Math.sin(radian)*getY()),(Math.cos(radian)*getX())+(Math.sin(radian)*getY()));
	}

}
