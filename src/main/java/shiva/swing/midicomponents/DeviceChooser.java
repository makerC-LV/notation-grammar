package shiva.swing.midicomponents;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiDevice.Info;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import shiva.midi.DeviceUtils;

@SuppressWarnings("serial")
public class DeviceChooser extends JComboBox<MidiDevice>{
	
	public static enum Type { 
		INPUT, OUTPUT, BOTH
	}
	
	public static interface DeviceListener {
		void deviceChosen(MidiDevice device);
	}
	
	private List<DeviceListener> listeners = new ArrayList<>();
	
	public DeviceChooser(Type type) {
		
		List<MidiDevice> devices = new ArrayList<MidiDevice>();
		if (type == Type.INPUT || type == Type.BOTH) {
			devices.addAll(DeviceUtils.inputDevices());
		} 
		if (type == Type.OUTPUT || type == Type.BOTH) {
			devices.addAll(DeviceUtils.outputDevices());
		}
		MidiDevice[] items = devices.toArray(new MidiDevice[0]);
		DefaultComboBoxModel<MidiDevice> model = new DefaultComboBoxModel<MidiDevice>(items);
		setModel(model);
		setRenderer(new DefaultListCellRenderer() {

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				Info info = ((MidiDevice) value).getDeviceInfo();
				String name = info.getName();
				return super.getListCellRendererComponent(list, name, index, isSelected, cellHasFocus);
			}
			
		});
		addActionListener(e-> {
			MidiDevice device = (MidiDevice) getSelectedItem();
			listeners.forEach(l-> {l.deviceChosen(device);});
		});
		
	}

	public void addDeviceListener(DeviceListener l) {
		listeners.add(l);
	}
}
