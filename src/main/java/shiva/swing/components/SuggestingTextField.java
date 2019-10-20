package shiva.swing.components;

import java.util.List;

import javax.swing.JTextField;

import shiva.swing.components.autocomplete.JTextFieldSuggestionClient;
import shiva.swing.components.autocomplete.SuggestionDropDownDecorator;

@SuppressWarnings("serial")
public class SuggestingTextField extends JTextField {

	List<String> names;
	public SuggestingTextField(int chars, List<String> names) {
		super(chars);
		this.names = names;
		
		SuggestionDropDownDecorator.decorate(this, new JTextFieldSuggestionClient(names));

	}

	
	
}
