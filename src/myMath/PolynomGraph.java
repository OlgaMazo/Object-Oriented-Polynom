package myMath;

import java.awt.Color;
import javax.swing.JFrame;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

/**
 * This class present the polynom graph on the axis of numbers in [x0, x1] range,
 * the extreme points highlighted in red and their values printed on the console.
 * 
 * Note that the jar file "gral-core-0.11" must be added before use this class!
 * 
 * @author Daniel.
 *
 */
public class PolynomGraph extends JFrame {
	
//    public static void main(String[] args) {
//    	Polynom p = new Polynom("0.2x^4-1.5x^3+3.0x^2-x-5");
//    	PolynomGraph frame = new PolynomGraph(p,-2, 6);
//    	System.out.println("the area under the X axis and above the function between [-2,6] is: " + p.area_under_x_axis(-2, 6, 0.01));
//    	frame.setVisible(true);
//    }
	
    /**
     * PolynomGraph.
     * A constructor that receives polynom, start x point and end x point. 
     * displays the graph of the function and indicates the extreme points on him.
     * @param p - polynom
     * @param x0 - start point
     * @param x1 - end point
     */
	public PolynomGraph(Polynom p, double x0, double x1) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        DataTable p_data = find_polynom(p, x0, x1);
        DataTable e_data = find_extreme_points(p, x0, x1);
        create_graph (p_data, e_data);
	}
	
	/**
	 * find_polynom
	 * insert the polynom points at a deviation of 0.25 into an data table.
	 * @param p - polynom
	 * @param x0 - start point
	 * @param x1 - end point
	 * @return - data table object
	 */
	private DataTable find_polynom(Polynom p, double x0, double x1) {
		DataTable p_data = new DataTable(Double.class, Double.class);
		for (double x = x0; x <= x1; x += 0.25) {
			double y = p.f(x);
			p_data.add(x, y);
		}
		return p_data;
	}
	
	/**
	 * find_extreme_points
	 * Finds the extreme points of the polynom in the given range and inserts them into an data table.
	 * @param p - polynom
	 * @param x0 - start point
	 * @param x1 - end point
	 * @return - data table object
	 */
	private DataTable find_extreme_points(Polynom p, double x0, double x1) {
		
		boolean firstPoint = true;
        DataTable e_data = new DataTable(Double.class, Double.class);
        
        //calculate the polynomial derivative since the derivative in the extreme points is 0
        Polynom p_derivative = (Polynom) p.derivative();
        
        //check all polynom points with a deviation of 0.01
        for (double x = x0; x <= x1; x+=0.01) {
       
        	if (is_derivative_changed(p_derivative, x)) {
        		
        		//if the derivative changed find the exact point
        		//(otherwise, multiple points are multiplied for the same change in the derivative!)
        		double e_x = find_extreme_point(p_derivative, x);
        		
        		//if we find an extreme point, we will examine its Y value in the original function
        		double e_y = p.f(e_x);
        		
        		//print the extreme points values
        		if (firstPoint) {
        			System.out.println("The extreme points are:");
        			firstPoint = false;
        		}
        		System.out.println("(" + e_x + ", " + e_y + ")");
        		
        		//add the extreme point to the data table object.
        		e_data.add(e_x, e_y);
        		x=e_x;
        	}
        }
        return e_data;
	}
	
	/**
	 * is_derivative_changed
	 * If the derivative bfore and after this point were changed - this is extreme point.
	 * @param d_before - 0.01 before this point
	 * @param d_after - 0.01 after this point
	 * @return - true if the derivative has changed, otherwise false
	 */
	private boolean is_derivative_changed(Polynom p_derivative, double x) {
		
    	double d_before = p_derivative.f(x-0.01);
    	double d_after = p_derivative.f(x+0.01);

		//if the derivative before was negative and after positive 
		if (d_before < 0) {
			if (d_after > 0) {
				return true;
			}
		}
		
		//if the derivative before was positive and after negative
		else if (d_before > 0) {
			if (d_after < 0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * create_graph
	 * Displays the polynom in the graph with the extreme points highlighted.
	 * @param p_data - polynom data table object
	 * @param e_data - extreme points data table object
	 */
	private void create_graph (DataTable p_data, DataTable e_data) {
		
		//display the polynom on x,y-graph
        XYPlot plot = new XYPlot(p_data, e_data);
        getContentPane().add(new InteractivePanel(plot));
        LineRenderer lines = new DefaultLineRenderer2D();
        plot.setLineRenderers(p_data, lines);
        Color color = new Color(0.0f, 0.3f, 1.0f);
        plot.getPointRenderers(p_data).get(0).setColor(color);
        plot.getLineRenderers(p_data).get(0).setColor(color);
        
        //display the highlighted extreme points
        Color e_color = new Color(255,0,0);
        plot.getPointRenderers(e_data).get(0).setColor(e_color);
	}
	
	/**
	 * find_extreme_point
	 * Find the nearest point to the extreme point with a deviation of 0.01.
	 * @param p_derivative - the polynom derivative
	 * @param x - x point
	 * @return - the nearest x point to the extreme point with a deviation of 0.01
	 */
	private double find_extreme_point(Polynom p_derivative, double x) {

		double d_before = p_derivative.f(x - 0.01);
		double d_after = p_derivative.f(x + 0.01);

		//as long as there is a change in the derivative, advance by 0.01 and check the next point
		while (is_derivative_changed(p_derivative, x)) {
			x += 0.01;
		}
		return x - 0.01;
	}
}
