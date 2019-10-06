package shiva.metamusic;

import java.util.ArrayList;
import java.util.List;

public class MMTemplatePhrase {

	

	List<MMTrackItem> items = new ArrayList<>();
	
	

	public MMTemplatePhrase() {
		
	}
	
	public List<MMTrackItem> getItems() {
		return items;
	}
	
	public void addItem(MMTrackItem item) {
		items.add(item);
	}

	
	
}
