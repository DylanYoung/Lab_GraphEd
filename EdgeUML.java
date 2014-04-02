import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


public class EdgeUML extends AbstractEdge {

	private static final long serialVersionUID = 1L;

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub

		Line2D l = getConnectionPoints();
		Point2D p1 = l.getP1();
		Point2D p2 = l.getP2();
		Double xDist = p1.getX() - p2.getX();
		Double yDist = p1.getY() - p2.getY();
		Double s2x, s2y, f2x, f2y;
		
		Point2D temp;
		
		if ( Math.abs(xDist) < Math.abs(yDist) )
		{
			s2x = p1.getX() - xDist/2;
			s2y = p1.getY();
			f2x = p1.getX() - xDist/2;
			f2y = p2.getY(); 
		}else{
			s2x = p1.getX();
			s2y = p2.getY() + yDist/2;
			f2x = p2.getX();
			f2y = p2.getY() + yDist/2; 
		}
				
			
		g2.draw( new Line2D.Double(
				p1.getX(), p1.getY(), 
				s2x, s2y) );
		g2.draw( new Line2D.Double(
				s2x, s2y, 
				f2x, f2y) );
		g2.draw( new Line2D.Double(
				f2x, f2y, p2.getX(), p2.getY()
				) );
		
	}

	@Override
	public boolean contains(Point2D aPoint) {
		// TODO Auto-generated method stub
		return false;
	}

}
