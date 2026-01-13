//the class represent Line
    public class Line{
    //instance to store the first point of the line
    private Point firstPoint;
    //instance to store the second point of the line
    private Point secondPoint;
    /* constructor for Line
    * @param p1 the start point of the line
    * @param p2 the end point of the line
    * */
    public Line(Point p1, Point p2){
        this.firstPoint = p1;
        this.secondPoint = p2;
    }
    /* getFirstPoint
    * @return the Point that represent the start point of the line
    * */
    public Point getFirstPoint(){
        return this.firstPoint;
    }
    /* getSecondPoint
    * @return the Point that represent the end point of the line
    * */
    public Point getSecondPoint(){
        return this.secondPoint;
    }
    /*setFirstPoint to change the start Point of the line
    * @param p the start point of the line
    * */
    public void setFirstPoint(Point p){
        this.firstPoint = p;
    }
    /*setSecondPoint to change the end Point of the line
    * @param p the end point of the line
    * */
    public void setSecondPoint(Point p){
        this.secondPoint = p;
    }
    /**
    * method getLine
    * @return an array of Line
    */
    public Line[] getLines(){
        Line[] line = new Line[]{this};
        return line;
    }
    /* ovveride the method equals for line
    * @param takes a object
    * @return boolean whethere two line is equal*/
    public boolean equals(Object o){
        boolean result = false;
        if(o instanceof Line){
            Line line = (Line)o;
            //call the equals method in Point class
            result = (this.getFirstPoint().equals(line.getFirstPoint())) &&
            (this.getSecondPoint().equals(line.getSecondPoint()));
        }
        return result;
    }
}
