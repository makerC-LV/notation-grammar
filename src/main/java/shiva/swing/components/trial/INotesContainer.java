package shiva.swing.components.trial;

import java.util.HashSet;

public interface INotesContainer {

	int getLastBeat();

	int getNoteLevelDifference();

	int getLowestNoteLevel();

	HashSet<INote> getNotesArray(int i);

}
