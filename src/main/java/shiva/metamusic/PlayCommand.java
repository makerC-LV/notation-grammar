package shiva.metamusic;

import java.util.ArrayList;

public class PlayCommand extends ArrayList<IPlayable> implements ISongElement {

	@Override
	public Type getSongElementType() {
		return Type.PLAYCOMMAND;
	}

	public String toSong4() {
		StringBuilder sb = new StringBuilder();
		System.out.println(this);
		for (IPlayable p : this) {
			sb.append(p.toSong4());
		}
		return "play " + sb.toString() + " ;" ;
	}
}
