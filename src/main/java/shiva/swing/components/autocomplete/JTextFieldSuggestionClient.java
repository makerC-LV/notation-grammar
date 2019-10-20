package shiva.swing.components.autocomplete;

import java.awt.Point;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JTextField;

public class JTextFieldSuggestionClient  implements SuggestionClient<JTextField>{
	
	List<String> names;
	
	public JTextFieldSuggestionClient(List<String> names) {
		super();
		this.names = names;
	}
	
	@Override
	public List<String> getSuggestions(JTextField invoker) {
		String str = invoker.getText();
		List<String> candidates = names.stream().filter(
				s -> s.toLowerCase().contains(str.toLowerCase()) ).collect(Collectors.toList());
		return candidates;
	}


	@Override
	public void setSelectedText(JTextField invoker, String selectedValue) {
		invoker.setText(selectedValue);
		
	}

	@Override
	public Point getPopupLocation(JTextField invoker) {
		return new Point(0, invoker.getHeight());
	}

}
