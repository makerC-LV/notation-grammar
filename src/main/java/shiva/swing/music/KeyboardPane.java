package shiva.swing.music;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import shiva.metamusic.util.KeyboardModel;
import shiva.metamusic.util.KeyboardModel.KeyboardListener;
import shiva.swing.components.Util;


public class KeyboardPane extends JPanel implements KeyboardListener {

	private static String IMAGE = "x88-key-piano-keyboard-layout.jpg";
	private Image bgImage;
	
	private Color pressedColor = new Color(0x81b0b2);
	private Color keyColor = new Color(0xf0e2e0);
	
	//private static final double REL_HEIGHT_FOR_2_OCTAVES = 0.2;
	AffineTransform atr;
	//double relativeHeight;
	KeyboardModel model;
	
	public KeyboardPane(KeyboardModel model) {
		
		this.model = model;
		model.addKeyboardListener(this);
	}
	
	@Override
	public void keyPressed(int num) {
		refresh();
		
	}

	@Override
	public void keyReleased(int num) {
		refresh();
		
	}
	
	public void refresh() {
		SwingUtilities.invokeLater(() -> {
			revalidate();
			repaint();
		});
	}
	
	@Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Dimension d = getSize();
		atr = AffineTransform.getScaleInstance(d.getWidth(), d.getHeight());
		
		AffineTransform oldAt = g2d.getTransform();
		//g2d.setTransform(atr);
		drawKeyboard(g2d);
		
		//g2d.setTransform(oldAt);

	}

	private void drawKeyboard(Graphics2D g2d) {
		Font font = selectFont(g2d);
		Font oldFont = g2d.getFont();
		g2d.setFont(font);
		drawWhiteKeys(g2d);
		drawBlackKeys(g2d);
		g2d.setFont(oldFont);
		
	}
	
	private Font selectFont(Graphics2D g2d) {
		Font f = g2d.getFont();
		f.getSize2D();
		
		double width = ((double)getWidth())/model.getWhiteKeys().size();
		
		FontMetrics fm = g2d.getFontMetrics(f);
		int sw = fm.stringWidth("A#");
		
		if (sw > 0.5 * width) {
			float lastSize = f.getSize2D();
			while (sw > 0.5 * width || f.getSize2D() == lastSize) {
				//System.out.println(f.getSize2D());
				lastSize = f.getSize2D();
				f = f.deriveFont(f.getSize2D() * 0.75f);
				fm = g2d.getFontMetrics(f);
				sw = fm.stringWidth("A#");
			}
		} else if (sw < 0.25 * width) {
			float lastSize = f.getSize2D();
			while (sw < 0.25 * width || f.getSize2D() == lastSize) {
				//System.out.println(f.getSize2D());
				lastSize = f.getSize2D();
				f = f.deriveFont(f.getSize2D() * 1.25f);
				fm = g2d.getFontMetrics(f);
				sw = fm.stringWidth("A#");
			}
		}
		
				
		return f;
		
	}

	private void drawBlackKeys(Graphics2D g2d) {
		FontMetrics fm  = g2d.getFontMetrics();
		RoundRectangle2D.Double r2d = new RoundRectangle2D.Double();
		for (KeyboardModel.Key key : model.getBlackKeys().values()) {
			double w = key.highX - key.lowX;
			r2d.setRoundRect(key.lowX, 0.0, w, 0.6, w/4, w/4);
			Shape s = atr.createTransformedShape(r2d);
			drawKey(g2d, fm, key, s, Color.black, Color.white, Color.black);
			
		}
		
	}

	

	private void drawWhiteKeys(Graphics2D g2d) {
		FontMetrics fm  = g2d.getFontMetrics();
		RoundRectangle2D.Double r2d = new RoundRectangle2D.Double();
		for (KeyboardModel.Key key : model.getWhiteKeys().values()) {
			double w = key.highX - key.lowX;
			r2d.setRoundRect(key.lowX, 0.0, w, 1.0, w/4, w/4);
			Shape s = atr.createTransformedShape(r2d);
			drawKey(g2d, fm, key, s, Color.black, Color.black, Color.white);
		}
		
	}

	private void drawKey(Graphics2D g2d, FontMetrics fm, KeyboardModel.Key key, Shape s, 
			Color borderColor, Color textColor, Color defaultFillColor) {
		Color fill = key.isPressed ? pressedColor : (key.isInKey ? keyColor : defaultFillColor);
		
		Color oldcolor = g2d.getColor();
		g2d.setColor(fill);
		g2d.fill(s);
		g2d.setColor(borderColor);
		g2d.draw(s);
		Rectangle2D rect = s.getBounds2D();
		Rectangle2D sr = fm.getStringBounds(key.name, g2d);
		double offset = (rect.getWidth() - sr.getWidth())/2;
		g2d.setColor(textColor);
		g2d.drawString(key.name, (float) (rect.getX() + offset), (float) (rect.getHeight() - sr.getHeight()));
		
		g2d.setColor(oldcolor);
	}
	
	
	
	public static void main(String[] args) {
		Util.showInFrame(new KeyboardPane(new KeyboardModel(4)));
	}

	

	
}
