public class Rectangle extends Polygon{
    //instance field to store the width of the rectangle
    private double width;
    //instance field to store the height of the rectangle
    private double height;
    //instance field for rectangle center
    private final Point recCenter;
    //the empty list of Point to passing
    /*constructor for Rectangle, set up the rectangle and also get the height and
    width for this rectangle
    * @param center represent the center of rectangle
    * @param width double value represent the width of the rectangle
    * @param height double value represent the height of the rectangle
    */
    public Rectangle(Point center, double width, double height){
        super(new Point[0]);
        this.recCenter = center;
        this.width = width;
        this.height = height;
    }
    /*getter method for width
    * @return double value represent the width of the rectangle
    * */
    public double getWidth(){
        return this.width;
    }
    /*getter method for height
    * @return double value represent the height of the rectangle
    * */
    public double getHeight(){
        return this.height;
    }
    /*setter method for width
    * @param double value represent the width of the rectangle
    * */
    public void setWidth(double width){
        this.width = width;
    }
    /*setter method for height
    * @param height double value represent the height of the rectangle
    * */
    public void setHeight(double height){
        this.height = height;
    }
    /*override the method for getCenter for rectangle
    * @return the point that represent the center of the rectangle
    * */
    @Override
    public Point getCenter(){
        return this.recCenter;
    }
    /*getter method for getPoint[]
    * idea: center point x coordinate plus or minus half-wide will be left & right
    edge of rectangle, so as y-coordinate
    * four point for rectangel will be the combination of left/right edges, top and
    bottom edges.
    * @return the array of Point that construct the rectangle
    */
    @Override
    public Point[] getPoints(){
        double halfWidth = this.getWidth() / 2;
        double halfHeight = this.getHeight() / 2;
        //get four points for rectangle
        Point rightTop = new Point(this.getCenter().getX() + halfWidth,
        this.getCenter().getY() + halfHeight);
        Point rightBottom = new Point(this.getCenter().getX() + halfWidth,
        this.getCenter().getY() - halfHeight);
        Point leftTop = new Point(this.getCenter().getX() - halfWidth,
        this.getCenter().getY() + halfHeight);
        Point leftBottom = new Point(this.getCenter().getX() - halfWidth,
        this.getCenter().getY() - halfHeight);
        //make a PointsArray that calls the rotateAbout cuntion in Point, to get the Points in correct space even after we rotate
        Point[] pointList = new Point[]
            {rightTop.rotateAbout(this.getCenter(),super.getAngle()),
            rightBottom.rotateAbout(this.getCenter(),super.getAngle()),
            leftBottom.rotateAbout(this.getCenter(),super.getAngle()),
            leftTop.rotateAbout(this.getCenter(),super.getAngle())};
        return pointList;
    }
}