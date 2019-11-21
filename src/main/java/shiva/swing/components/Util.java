package shiva.swing.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;


// http://jiconfont.github.io/swing  For jIconFont

// http://jiconfont.github.io/googlematerialdesignicons  Google material design icons cheatsheet

public class Util {
	
	public static final Color DEFAULT_COLOR = Color.black;
	public static final int DEFAULT_ICON_SIZE = 16;
	public static final int SMALL = 12;
	
	public static final Color SOLARIZED_base03 =     new Color(0x002b36);
	public static final Color SOLARIZED_base02 =     new Color(0x073642);
	public static final Color SOLARIZED_base01 =     new Color(0x586e75);
	public static final Color SOLARIZED_base00 =     new Color(0x657b83);
	public static final Color SOLARIZED_base0 =      new Color(0x839496);
	public static final Color SOLARIZED_base1 =      new Color(0x93a1a1);
	public static final Color SOLARIZED_base2 =      new Color(0xeee8d5);
	public static final Color SOLARIZED_base3 =      new Color(0xfdf6e3);
	public static final Color SOLARIZED_yellow =     new Color(0xb58900);
	public static final Color SOLARIZED_orange =     new Color(0xcb4b16);
	public static final Color SOLARIZED_red =        new Color(0xdc322f);
	public static final Color SOLARIZED_magenta =    new Color(0xd33682);
	public static final Color SOLARIZED_violet =     new Color(0x6c71c4);
	public static final Color SOLARIZED_blue =       new Color(0x268bd2);
	public static final Color SOLARIZED_cyan =       new Color(0x2aa198);
	public static final Color SOLARIZED_green =      new Color(0x859900);
	
	static {
		IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
	}

	public static Icon errorIcon() {
		return IconFontSwing.buildIcon(GoogleMaterialDesignIcons.CANCEL, SMALL, Color.red);
	}
	
	public static Icon warningIcon() {
		return IconFontSwing.buildIcon(GoogleMaterialDesignIcons.WARNING, SMALL, Color.yellow);
	}
	
	public static Icon closeIcon(Color color) {
		return IconFontSwing.buildIcon(GoogleMaterialDesignIcons.CLOSE, SMALL, color);
	}
	
	public static JLabel label(String text) {
		return new JLabel(text);
	}
	
	public static JTextField textField(int chars) {
		return new JTextField(chars);
	}

	public static JButton button(String string) {
		return new JButton(string);
	}
	
	public static JButton newButton() {
		return iconButton(GoogleMaterialDesignIcons.CREATE_NEW_FOLDER, DEFAULT_ICON_SIZE, DEFAULT_COLOR);
	}
	
	public static JButton openButton() {
		return iconButton(GoogleMaterialDesignIcons.FOLDER_OPEN, DEFAULT_ICON_SIZE, DEFAULT_COLOR);
	}
	
	public static JButton saveButton() {
		return iconButton(GoogleMaterialDesignIcons.SAVE, DEFAULT_ICON_SIZE, DEFAULT_COLOR);
	}
	
	public static JButton saveAsButton() {
		return iconButton(GoogleMaterialDesignIcons.SPEAKER_NOTES, DEFAULT_ICON_SIZE, DEFAULT_COLOR);
	}
	
	public static JButton copyButton() {
		return iconButton(GoogleMaterialDesignIcons.CONTENT_COPY, DEFAULT_ICON_SIZE, DEFAULT_COLOR);
	}

	public static JButton settingsButton() {
		return iconButton(GoogleMaterialDesignIcons.SETTINGS, DEFAULT_ICON_SIZE, DEFAULT_COLOR);
	}
	
	public static JButton editButton() {
		return iconButton(GoogleMaterialDesignIcons.EDIT, DEFAULT_ICON_SIZE, DEFAULT_COLOR);
	}
	
	public static JButton playResetButton() {
		return iconButton(GoogleMaterialDesignIcons.SKIP_PREVIOUS, DEFAULT_ICON_SIZE, DEFAULT_COLOR);
	}
	
	public static JButton equalizerButton() {
		return iconButton(GoogleMaterialDesignIcons.EQUALIZER, DEFAULT_ICON_SIZE, DEFAULT_COLOR);
	}
	
	public static JToggleButton playPauseButton() {
		return dualIconToggleButton(GoogleMaterialDesignIcons.PLAY_ARROW, 
				GoogleMaterialDesignIcons.PAUSE, DEFAULT_ICON_SIZE, DEFAULT_COLOR, Color.red);
	}
	
	public static JToggleButton recordPauseButton() {
		return dualIconToggleButton(GoogleMaterialDesignIcons.RECORD_VOICE_OVER, 
				GoogleMaterialDesignIcons.PAUSE, DEFAULT_ICON_SIZE, DEFAULT_COLOR, Color.red);
	}
	
	public static JToggleButton soloButton() {
		JToggleButton but = onOffButton(GoogleMaterialDesignIcons.RECORD_VOICE_OVER, 
			DEFAULT_ICON_SIZE, DEFAULT_COLOR, Color.green);
		but.setToolTipText("Solo");
		return but;
	}
	
	public static JToggleButton muteButton() {
		JToggleButton but = onOffButton(GoogleMaterialDesignIcons.VOLUME_OFF, 
			DEFAULT_ICON_SIZE, DEFAULT_COLOR, Color.red);
		but.setToolTipText("Mute");
		return but;
	}
	
	public static JToggleButton onOffButton(GoogleMaterialDesignIcons iconConstant, int size, Color offColor, Color onColor) {
		Icon offIcon = IconFontSwing.buildIcon(iconConstant, size, offColor);
		Icon onIcon = IconFontSwing.buildIcon(iconConstant, size, onColor);
		OnOffButton tb = new OnOffButton(offIcon, onIcon);
		tb.setSelectedIcon(onIcon);
		return tb;
	}
	
	public static JToggleButton dualIconToggleButton(GoogleMaterialDesignIcons iconOffConstant, 
			GoogleMaterialDesignIcons iconOnConstant,
			int size, Color offColor, Color onColor) {
		Icon offIcon = IconFontSwing.buildIcon(iconOffConstant, size, offColor);
		Icon onIcon = IconFontSwing.buildIcon(iconOnConstant, size, onColor);
		OnOffButton tb = new OnOffButton(offIcon, onIcon);
		tb.setSelectedIcon(onIcon);
		return tb;
	}
	
	public static JButton iconButton(GoogleMaterialDesignIcons iconConstant) {
		return iconButton(iconConstant, DEFAULT_ICON_SIZE, DEFAULT_COLOR);
	}
	
	public static JButton iconButton(GoogleMaterialDesignIcons iconConstant, int size, Color color) {
		Icon icon = IconFontSwing.buildIcon(iconConstant, size, color);
		return new JButton(icon);
	}
	
	public static ImageIcon getOpenIcon() {
		return buildImageicon(GoogleMaterialDesignIcons.FOLDER_OPEN, 14, Color.black);
	}

	public static ImageIcon getSaveIcon() {
		return buildImageicon(GoogleMaterialDesignIcons.SAVE, 14, Color.black);
	}

	public static ImageIcon getSaveAsIcon() {
		return buildImageicon(GoogleMaterialDesignIcons.STYLE, 14, Color.black);
	}
	

	private static ImageIcon buildImageicon(GoogleMaterialDesignIcons code, int size, Color color) {
		Icon icon = IconFontSwing.buildIcon(code, size, color);
		return new ImageIcon(iconToImage(icon));
	}

	
	
	public static Image iconToImage(Icon icon) {
		if (icon instanceof ImageIcon) {
			return ((ImageIcon)icon).getImage();
		} 
		else {
			int w = icon.getIconWidth();
			int h = icon.getIconHeight();
			GraphicsEnvironment ge = 
					GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice gd = ge.getDefaultScreenDevice();
			GraphicsConfiguration gc = gd.getDefaultConfiguration();
			BufferedImage image = gc.createCompatibleImage(w, h);
			Graphics2D g = image.createGraphics();
			icon.paintIcon(null, g, 0, 0);
			g.dispose();
			return image;
		}
	}

	public static void showInFrame(JComponent comp) {
		SwingUtilities.invokeLater(() -> {
			JFrame fr = new JFrame();
			fr.getContentPane().setLayout(new BorderLayout());
			fr.getContentPane().add(comp, BorderLayout.CENTER);
			fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fr.pack();
			fr.setVisible(true);
		});
	}
	
	public static void showInDialog(JComponent comp) {
		SwingUtilities.invokeLater(() -> {
			JDialog fr = new JDialog();
			fr.setModal(true);
			fr.getContentPane().setLayout(new BorderLayout());
			fr.getContentPane().add(comp, BorderLayout.CENTER);
			fr.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			fr.pack();
			fr.setVisible(true);
		});
	}
	
	private static class OnOffButton extends JToggleButton {
	    
		private Icon offIcon;
		private Icon onIcon;
		
		
	    public OnOffButton(Icon offIcon, Icon onIcon) {
			super();
			this.offIcon = offIcon;
			this.onIcon = onIcon;
			setIcon(offIcon);
		}


		public void setState() {
	        if (this.isSelected() || !this.isEnabled()) {
	            this.setIcon(onIcon);
	        } else {
	            this.setIcon(offIcon);
	        }
	    }
	}
}
