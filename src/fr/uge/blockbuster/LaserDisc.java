package fr.uge.blockbuster;

import java.time.Duration;
import java.util.Objects;

public final class LaserDisc implements Article{
	private final String name;
	
	
	
	public LaserDisc(String name) {
		this.name = Objects.requireNonNull(name);
	}

	@Override
	public String name() {
		return this.name;
	}

	@Override
	public Duration duration() {
		return null;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof LaserDisc laserDisC
		&& name.equals(laserDisC.name);
	}
	
	public String ToString() {
		var string = new StringBuilder();
		string.append("LaserDisc:");
		string.append(name);
		return string.toString();
	}
	
	public String toText() {
		var string = new StringBuilder();
		string.append("LaserDisc:");
		string.append(name);
		return string.toString();
	}
	
	
	
}
