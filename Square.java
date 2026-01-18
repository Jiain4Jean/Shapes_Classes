//class for Square
public class Square extends Rectangle{
    /*constructor for Square
    * @param center represent the center of the suqare
    * @param length represent the length of each side of the square
    * */
    public Square(Point center, double length){
        super(center, length, length);
    }
    /*override setter method for width to change width and height of the square at
    the same time
    * @param double value represent the length of the square
    * */
    @Override
    public void setWidth(double length){
        super.setWidth(length);
        super.setHeight(length);
    }
    /*override setter method for height to change width and height of the square at
    the same time
    * @param double value represent the length of the square
    * */
    @Override
    public void setHeight(double length){
        super.setWidth(length);
        super.setHeight(length);
    }
}
