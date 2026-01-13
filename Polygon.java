//class represent Polygon
public class Polygon extends Object{
    //instance method to store the angle for rotation
    private double angle = 0.0;
    //array to store every point that make up the polygon
    private Point[] polygonPointList;
    /*constructor for Polygon to setup the polygon by an array of points of polygon
    * @param polyPoints represent the array of points of polygon
    * */
    public Polygon(Point[] polyPoints){
    //if statment to make sure we only deal with Polygon
        if(polyPoints.length >= 3){
            this.polygonPointList = polyPoints;
        }
    }

    /** method for setCenter,
    * it will change the location of every points that make up the polygon to the
    new location with center of new center
    * @param p take a point representing the center point
    * */
    public void setCenter(Point p){
        double xChange = p.getX();
        double yChange = p.getY();
        //for each iteration, change the points that make up the polygon to be new points 
        for(int i = 0; i < this.getPoints().length; i++){
            //add Xchange and changeY to the original Points' x and y value
            this.getPoints()[i] = new Point(this.getPoints()[i].getX() + xChange,
            this.getPoints()[i].getY() + yChange);
        }
    }


    /**setter method for center point
    *@return Point the point that represent the center of the polygon
    */
    public Point getCenter(){
        //set variables for Maximum and Minimum in both x and y axis of the polygon
        double maxX = this.getPoints()[0].getX();
        double minX = this.getPoints()[0].getX();
        double maxY = this.getPoints()[0].getY();
        double minY = this.getPoints()[0].getY();
        //for loop to get the leftmost, rightmost, top and bottom value for polygon
        //subgoa: for each iteration, if the point representing the 1 edge of the polygon, store the value that represent that edge
        for(int i = 1; i < this.getPoints().length; i++){
            if(this.getPoints()[i].getX() > maxX)
                maxX = this.getPoints()[i].getX();
            if(this.getPoints()[i].getX() < minX)
                minX = this.getPoints()[i].getX();
            if(this.getPoints()[i].getY() > maxY)
                maxY = this.getPoints()[i].getY();
            if(this.getPoints()[i].getY() < minY)
                minY = this.getPoints()[i].getY();
        }
        //apply midpoint formula to get both x-coordinate and y-coordinate for the centerPoint
        double centerX = (maxX + minX) / 2;
        double centerY = (maxY + minY) / 2;
        //return the center point
        return new Point(centerX, centerY);
    }


    /**method to rotate every points in polygon
    * @param angle take a double vraible angle for represent the angle for rotation
    * setup the Line array that contains every line that make up the polygon
    * */
    public void rotate(double angle){
        //to store the angle for rotation
        this.setAngle(angle);
        //save the center point of the shape before rotation, because everytime we rotate one point, will change the center
        Point originalCenter = this.getCenter();
        for(int i = 0; i < this.getPoints().length; i++){
            //for every point make up the polygon -> call the method rotateAbout in Point class
            //and store them back to the PointList
            this.getPoints()[i] = this.getPoints()[i].rotateAbout(originalCenter,angle);
        }
    }

    /* getter method for polygonPointList
    * @return the array of Point that construct the polygon
    * */
    public Point[] getPoints(){
        return this.polygonPointList;
    }

    /**method to get the Lines that make up the polygon
    * @return the Line array that contains every line that make up the polygon
    * this should work for every shape
    * */
    public Line[] getLines(){
        //try-catch block to catch the NullPointerException
        //because if the polygonPointList is null, we are not able to create Line array with length of polygonPointList
        try{
            Line[] lineList = new Line[this.getPoints().length];
        }
        catch(NullPointerException e){
            Line[] emptylist = new Line[0];
            return emptylist;
        }
        //to create a Line Array to store the lines for Polygon
        Line[] lineList = new Line[this.getPoints().length];
        //for every point of the polygon, make a line between them and store into the Line array.
        for(int i = 0; i < this.getPoints().length - 1; i++){
            Line line = new Line(this.getPoints()[i],this.getPoints()[i+1]);
            lineList[i] = line;
        }
        //make the last space of the LineArray to be the line that connect first point and last point of the pointArray
        lineList[this.getPoints().length - 1] = new Line(this.getPoints()[this.getPoints().length - 1],this.getPoints()[0]);
        return lineList;
    }

    /*getter method for angle
    * @return the double value represent the angle
    * */
    public double getAngle(){
        return this.angle;
    }
    /*setter method for angle
    * @param angle takes the double value for setup the angle for rotation
    * */
    public void setAngle(double angle){
        this.angle = angle;
    }

    /** Override the method for "euqlas" for different shapes\
    * compare this Polygon to input Polygon
    * idea: verify whether points getX and getY are same, test everypoints with
    other points in the array, nested loop
    * @param o the object, if that object can be typecast into Polygon, the array of
    Points that make up the shape
    * @return boolean of whether two shape are the same
    * */
    @Override
    public boolean equals(Object o){
        Polygon shape;
        //check whether we able to typecast
        if(o instanceof Polygon){
            shape = (Polygon)o;
        }
        else{
            return false;
        }
        //check whether two Point array have the same length
        if(this.getPoints().length == shape.getPoints().length){
            //to store the index that match the first point in this.Point array
            int save = 0;
            //goal find the point that match at the beginning
            //subgoal: for every iteration, if point in shape.array match the first point in this, we store that index
            for(int i = 0; i < shape.getPoints().length; i++){
                //if the first point of this.array is equal any point in shape.array, we save the spot for that point that match
                if(this.getPoints()[0].equals(shape.getPoints()[i])){
                    //we had checked the i with first element in this, so add 1 to check next
                    save = i + 1;
                }
            }
            //goal: to check whether the rest points in the array match
            //subgoal: for each iteration, if the the points does not match, return false immediately
            for(int i = 1; i < this.getPoints().length; i++){
                //if statement to reset the save value inorder for us go over all the points in shape.array
                if(save == shape.getPoints().length){
                    save = 0;
                }
                //if statement to check whethere every point following are match
                if(!this.getPoints()[i].equals(shape.getPoints()[save])){
                    return false;
                }
                save++;
            }
            //if we successfully run over the for-loop, it means every elements in both array match, return true
            return true;
        }
        else{
            return false;
        }
    }
}
