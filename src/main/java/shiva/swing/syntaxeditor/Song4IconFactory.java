package shiva.swing.syntaxeditor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jiconfont.IconCode;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;
import shiva.swing.components.Util;

public class Song4IconFactory {

	public static Icon getErrorIcon() {
		return Util.errorIcon();
	}

	public static Icon getWarningIcon() {
		return Util.warningIcon();
	}
	
	public static Image getAppIconImage() {
		Util.getOpenIcon(); // just to register the font in Util
		Icon icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.QUEUE_MUSIC, 12, Color.cyan);
		return Util.iconToImage(icon);
	}
	
	public static ImageIcon getOpenIcon() {
		return Util.getOpenIcon();
	}

	public static ImageIcon getSaveIcon() {
		return Util.getSaveIcon();
	}

	public static ImageIcon getSaveAsIcon() {
		return Util.getSaveAsIcon();
	}
	

	
	
}
