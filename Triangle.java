//class for Triangle
public class Triangle extends Polygon{
    /*constructor of triangle to set up the basic value of ctreating a triangle
    * @param p1 the first point that make up triangle
    * @param p2 the second point that make up triangle
    * @param p3 the third point that make up triangle
    * */
    public Triangle(Point p1, Point p2, Point p3){
        super(new Point[]{p1,p2,p3});
    }

    /*override the getCenter Method for triangle
    * @return the point that represent the center of the triangle
    */
    public Point getCenter(){
        //get the midPoint of two line of the triangle (apply midPoint formula twice for each point)
        //mid point represent one of the end points for line
        Point mid1 = new Point((this.getPoints()[0].getX() + this.getPoints()[1].getX()) / 2,
        (this.getPoints()[0].getY() + this.getPoints()[1].getY()) / 2);
        Point mid2 = new Point((this.getPoints()[1].getX() + this.getPoints()[2].getX()) / 2,
        (this.getPoints()[1].getY() + this.getPoints()[2].getY()) / 2);
        //get(x1, y1) (x2, y2) from the point[0] to mid2, bcs the midpoint mid2 is point btw point1 and point2,
        //which exist in the line oppoite to point0
        double x1 = this.getPoints()[0].getX();
        double y1 = this.getPoints()[0].getY();
        double x2 = mid2.getX();
        double y2 = mid2.getY();
        //get(x3, y3) (x4, y4) from the point[2] to mid1
        double x3 = this.getPoints()[2].getX();
        double y3 = this.getPoints()[2].getY();
        double x4 = mid1.getX();
        double y4 = mid1.getY();
        //store the variable for denominator for the formula, just make my code look simpler
        double denominator = ((x1-x2)*(y3-y4)) - ((y1-y2)*(x3-x4));
        //apply formula
        double centerX = (((x1*y2) - (y1*x2))*(x3-x4) - (x1-x2)*((x3*y4) - (y3*x4)))/denominator;
        double centerY = (((x1*y2) - (y1*x2))*(y3-y4) - (y1-y2)*((x3*y4) - (y3*x4)))/denominator;
        return new Point(centerX, centerY);
    }
}
