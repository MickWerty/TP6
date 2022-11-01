package fr.uge.blockbuster;

import java.time.Duration;

public sealed interface Article permits LaserDisc, VideoTape  {
	String name();
	Duration duration();
	String toString();
	String toText();
	
	public static Article fromText(String string) {
		Duration duration;
		String name;
		var value = string.split(":");
		switch (value[0]) {
		case "LaserDisc": {
			name = value[1];
			var laserDisc = new LaserDisc(name);
			return laserDisc;
		}
		case "VideoTape": {
			name = value[1];
			duration = Duration.ofMinutes(Long.parseLong(value[2], 10));
			var videoTape = new VideoTape(name, duration);
			return videoTape; 
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + value[0]);
		}
		
	}
}
