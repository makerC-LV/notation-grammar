package shiva.swing.syntaxeditor;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import org.antlr.v4.runtime.tree.ParseTree;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import shiva.song4.Song4Parser;


@SuppressWarnings("serial")
public class Song4OutlineTree extends JTree {

	private interface ParseTreeProvider {

		ParseTree getTree();

	}

	Song4Parser parser;

	ParseTreeProvider viewer;

	public Song4OutlineTree() {
		super();
		// An "empty" icon that will be used for the JTree's nodes.
		Icon empty = new EmptyIcon();

		UIManager.put("Tree.closedIcon", empty);
		UIManager.put("Tree.openIcon", empty);
		UIManager.put("Tree.leafIcon", empty);

		setModel(ParseTreeModel.emptyModel());
		
		getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {

				JTree selectedTree = (JTree) e.getSource();
				TreePath path = selectedTree.getSelectionPath();
				if (path != null) {
					ParseTreeNode treeNode = (ParseTreeNode) path.getLastPathComponent();

					// Set the clicked AST.
					// viewer.setTree((Tree) treeNode.getUserObject());
				}
			}
		});

	}

	public void listenTo(RSyntaxTextArea textArea) {
		System.out.println("Song4OutlineTree: listenTo(): Implement me...");

	}

	
	private static class EmptyIcon implements Icon {

		@Override
		public int getIconWidth() {
			return 0;
		}

		@Override
		public int getIconHeight() {
			return 0;
		}

		@Override
		public void paintIcon(Component c, Graphics g, int x, int y) {
			/* Do nothing. */
		}
	}

}
