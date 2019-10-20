package shiva.swing.components.autocomplete;

import java.awt.Point;
import java.util.List;

public interface SuggestionClient<C> {

	List<String> getSuggestions(C invoker);

	void setSelectedText(C invoker, String selectedValue);

	Point getPopupLocation(C invoker);

}
