package shiva.metamusic;

import java.util.ArrayList;
import java.util.List;

public class MMNotePhrase {

	

	List<MMTrackItem> items = new ArrayList<>();
	
	

	public MMNotePhrase() {
		
	}
	
	public List<MMTrackItem> getItems() {
		return items;
	}
	
	public void addItem(MMTrackItem item) {
		items.add(item);
	}

	public MMNotePhrase repeat(int reps) {
		MMNotePhrase newphrase = new MMNotePhrase();
		for (int i = 0; i < reps; i++) {
			for (MMTrackItem item : items) {
				newphrase.addItem(item.copy());
			}
		}
		return newphrase;
	}

	
	
}
