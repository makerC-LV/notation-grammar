package shiva.swing.syntaxeditor;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

import org.antlr.v4.runtime.tree.ParseTree;

import shiva.song4.Song4Parser;

@SuppressWarnings("serial")
public class ParseTreeModel extends DefaultTreeModel {

	public ParseTreeModel(TreeNode root) {
		super(root);
		// TODO Auto-generated constructor stub
	}

	public static DefaultTreeModel getTreeModel(ParseTree parseTree, Song4Parser parser) {
		return new DefaultTreeModel(getTreeNodes(parseTree, parser));
	}
	
	public static ParseTreeNode getTreeNodes(ParseTree parseTree, Song4Parser parser) {
		ParseTreeNode node = new ParseTreeNode(parseTree, parser);
		for (int i = 0; i < parseTree.getChildCount(); i++) {
			ParseTreeNode ptn = getTreeNodes(parseTree.getChild(i), parser);
			node.add(ptn);
		}
		return node;
	}

	public static TreeModel emptyModel() {
		return new DefaultTreeModel(new ParseTreeNode(null, null));
	}
	
	

}
