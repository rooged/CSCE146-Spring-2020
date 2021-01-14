//written by Timothy Gedney

//sets template for the human player and the pc player used by the basicPlayer class
public interface Player {
	
	public int getPoints();
	
	public int getx();
	
	public int gety();
	
	public void setPoints(int aPoints);
	
	public void setx(int xTurn);
	
	public void sety(int yTurn);
	
	public void choosex();

	public void choosey();
}
