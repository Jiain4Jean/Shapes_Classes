//this represent the class of Point
public class Point extends Object{
    //instance to store the x-coordinate of the point
    private double xValue;
    //instance to store the y-coordinate of the point
    private double yValue;
    /*constructor for Point
    * @param x double value represent the x-coordinate of the point
    * @param y double value represent the y-coordinate of the point
    * */
    public Point(double x, double y){
        this.xValue = x;
        this.yValue = y;
    }
    /*getter method for x-coordinate of the point
    * @return double value that represent the x-coordinate of the point
    * */
    public double getX(){
        return this.xValue;
    }
    /*getter method for y-coordinate of the point
    * @return double value that represent the y-coordinate of the point
    * */
    public double getY(){
        return this.yValue;
    }
    /*setter method for x-coordinate of the point
    * @param x double value represent the x-coordinate of the point
    */
    public void setX(double x){
        this.xValue = x;
    }
    /*setter method for y-coordinate of the point
    * @param y double value represent the y-coordinate of the point
    */
    public void setY(double y){
        this.yValue = y;
    }


    /**method: rotateAbout
    * rotate this point about the input point by the input angle
    * @param p represent the origin point for rotation
    * @param angle the double value represent the angle for rotation
    * @return the point after rotation
    */
    public Point rotateAbout(Point p, double angle){
        //to get the x-coordinate and y-coordinate for claculation for the rotation equation
        double xForCal = this.getX() - p.getX();
        double yForCal = this.getY() - p.getY();
        //apply the rotation equation
        double xRotate = (xForCal * Math.cos(angle)) - (yForCal * Math.sin(angle));
        double yRotate = (xForCal * Math.sin(angle)) + (yForCal * Math.cos(angle));
        //set the result to be new x & y coordinate
        this.setX(p.getX() + xRotate);
        this.setY(p.getY() + yRotate);
        //return the point after rotation
        return new Point(p.getX() + xRotate, p.getY() + yRotate);
    }

    /* override the method equals for points, within 0.000001
    * @param takes a object
    * @return boolean whethere two points are equal*/
    @Override
    public boolean equals(Object o){
        boolean result = false;
        //if the object cannot be typecast into point, return false
        if(o instanceof Point){
            Point point = (Point)o;
            //if the two point is not approximately equal, return false
            result = ((this.getX() - point.getX()) < 0.000001) && 
            ((this.getY() - point.getY()) < 0.000001);
        }
        return result;
    }
}
