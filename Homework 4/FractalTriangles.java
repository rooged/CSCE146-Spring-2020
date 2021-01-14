//written by Timothy Gedney
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class FractalTriangles extends JPanel {

	//attributes
	int tWidth;
	int tHeight;
	int fractal = 2;
	Timer clock;
	BufferedImage draw;
	JLabel jlabel;

	public static void main(String[] agrs) {
		//initialize methods
		FractalTriangles fractal = new FractalTriangles();
		JFrame triangle = new JFrame();
		//triangle dimensions
		triangle.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		triangle.setLocationByPlatform(true);
		triangle.add(fractal);
		triangle.pack();
		triangle.setVisible(true);
	}

	public FractalTriangles() {
		//window dimensions
		final int width = 400;
		final int height = 400;
		//initialize drawing objects & draw
		draw = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		jlabel = new JLabel(new ImageIcon(draw));
		add(jlabel);
		final Graphics2D G2D = draw.createGraphics();
		G2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		G2D.setColor(new Color(150, 50, 225));

		//queue for lines
		final ArrayList<line> queue = new ArrayList<line>();
		queue.add(new line(new Point(width / 2, 0), new Point(0, height)));
		queue.add(new line(new Point(0, height), new Point(width, height)));
		queue.add(new line(new Point(width, height), new Point(width / 2, 0)));
		drawLine(queue.get(0), G2D);
		drawLine(queue.get(1), G2D);
		drawLine(queue.get(2), G2D);

		ActionListener e = new ActionListener() {
		int temp = 0;

			public void actionPerformed(ActionEvent ae) {
				//end when triangle is filled
				if (fractal > 6) {
					clock.stop();
					return;
				}
				//find points
				line[] toDraw = queue.get(0).calcTriangle(fractal, width, height);
				Point[] drawPoints = toDraw[0].getPoints();
				if (Math.sqrt(((Math.pow(drawPoints[1].x - drawPoints[0].x, 2)) + (Math.pow(drawPoints[1].y - drawPoints[0].y, 2)))) <= 4) {
					System.out.println("stop drawing");
					return;
				}

				//draw lines
				drawLine(toDraw[0], G2D);
				drawLine(toDraw[1], G2D);
				drawLine(toDraw[2], G2D);
				queue.remove(0);

				//add lines to queue
				queue.add(toDraw[0]);
				queue.add(toDraw[1]);
				queue.add(toDraw[2]);
				temp++;
				if (temp - Math.pow(3, fractal - 1) == 0) {
					temp = 0;
					fractal++;
				}
				jlabel.repaint();
			}
		};
		clock = new Timer(20, e);
		clock.start();
	}

	private void drawLine(line tLine, Graphics g) {
		g.drawLine(tLine.getPoints()[0].x, tLine.getPoints()[0].y, tLine.getPoints()[1].x, tLine.getPoints()[1].y);
	}
}

//create line object
class line {
	//attributes
	private Point tPoint1;
	private Point tPoint2;
	private Point midpoint;
	private double slope;

	//parameterized constructor
	public line(Point point1, Point point2) {
		this.tPoint1 = point1;
		this.tPoint2 = point2;
		midpoint = new Point((point1.x + point2.x) / 2, (point1.y + point2.y) / 2);
		slope = (double) (point2.y - point1.y) / (double) (point2.x - point1.x);

	}

	//return point
	public Point[] getPoints() {
		return new Point[]{tPoint1, tPoint2};
	}

	//calc point
	public line[] calcTriangle(int fractal, int tWidth, int tHeight) {

		line[] lines = new line[3];
		
		//negative slope
		if (slope > 0) {
			Point tLeft = new Point(midpoint.x - (tWidth / (int) (Math.pow(2, fractal - 1))), midpoint.y);
			Point middle = new Point(midpoint.x - (tWidth / (int) (Math.pow(2, fractal))), midpoint.y + (tHeight / (int) (Math.pow(2, fractal - 1))));
			lines[0] = new line(midpoint, tLeft);
			lines[1] = new line(midpoint, middle);
			lines[2] = new line(middle, tLeft);
		//positive slope
		} else if (slope < 0) {
			Point right = new Point(midpoint.x + (tWidth / (int) (Math.pow(2, fractal - 1))), midpoint.y);
			Point middle = new Point(midpoint.x + (tWidth / (int) (Math.pow(2, fractal))), midpoint.y + (tHeight / (int) (Math.pow(2, fractal - 1))));
			lines[0] = new line(midpoint, right);
			lines[1] = new line(midpoint, middle);
			lines[2] = new line(middle, right);
		//0 slope
		} else {
			Point left = new Point(midpoint.x - (tWidth / (int) (Math.pow(2, fractal))), midpoint.y - (tHeight / (int) (Math.pow(2, fractal - 1))));
			Point right = new Point(midpoint.x + (tWidth / (int) (Math.pow(2, fractal))), midpoint.y - (tHeight / (int) (Math.pow(2, fractal - 1))));
			lines[0] = new line(midpoint, left);
			lines[1] = new line(midpoint, right);
			lines[2] = new line(left, right);
		}
	return lines;
	}
}
