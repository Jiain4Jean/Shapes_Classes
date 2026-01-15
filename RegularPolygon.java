//the interface to store the static Points() method for EqualateralTriangle
public interface RegularPolygon{
    //abstract method for getSideLength which we will use in the PointsMethod
    public abstract double getSideLength();
    //abstract method for getNumSide which we will use in the PointsMethod
    public abstract int getNumSide();
    //abstract method for getCenter which we will use in the PointsMethod
    public abstract Point getCenter();
    //abstarct method to get the angle of rotation that ensure the Points change everytime we rotate
    public abstract double getAngle();
    /**Points method that does get Points that make up the regularpolygon
    * @param p represent the shape that implements the regularyPolygon interface
    * @return the array of points that make up the shape
    * */
    public static Point[] points(RegularPolygon p){
        //if the number of side is not zero
        if(p.getNumSide() >= 3){
            //create an array for points
            Point[] points = new Point[p.getNumSide()];
            //store the center of the shape
            Point center = p.getCenter();
            //get the distance between center and midpoint of one side
            double distance = p.getNumSide()/(2 * Math.tan(Math.PI / p.getNumSide()));
            //get the interior angle for calculation
            double interior = (Math.PI*(p.getNumSide() - 2))/ p.getNumSide();
            //get the starting point
            Point start = new Point(p.getCenter().getX() + distance, p.getCenter().getY());
            points[0] = start;
            //to get the rotated point
            for(int k = 1; k < p.getNumSide(); k++){
                //calculate the next point based on the previous point
                Point next = points[k - 1].rotateAbout(center,interior);
                //store the point we just create into the points array
                points[k] = next;
            }
            //return the point array after for loop
            return points;
        }else{
            return null;
        }
    }
}