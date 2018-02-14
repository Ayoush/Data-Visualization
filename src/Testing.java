import processing.core.*;
public class Testing extends PApplet{
	private String URL="https://i.ytimg.com/vi/FEvtY5sh5bM/maxresdefault.jpg";
	private PImage backgroundImg;
	
	public void setup()
	{
		size(200,200);
		backgroundImg = loadImage(URL,"jpg");
	}
	public void draw()
	{
		backgroundImg.resize(width, height);
		image(backgroundImg,0,0);
		fill(255,209,0);
		ellipse(width/4,height/5,width/5,height/5);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
