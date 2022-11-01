package fr.uge.blockbuster;
import java.time.Duration;
import java.util.Objects;

public final class VideoTape implements Article{
	private final String name;
	private final Duration duration;
	public VideoTape(String name, Duration duration)
	{
		this.name = Objects.requireNonNull(name);
		if(duration.isNegative())
		{
			throw new IllegalArgumentException("Durée < O");
		}
		this.duration = Objects.requireNonNull(duration);
	}
	@Override
	public String name() {
		return this.name;
	}
	@Override
	public Duration duration() {
		return this.duration;
	}
	
	@Override
	public boolean equals(Object o) {
		return o instanceof VideoTape videoTape
		&& name.equals(videoTape.name) && duration.equals(videoTape.duration);
	}
	
	public String toSting() {
		var string = new StringBuilder();
		string.append("VideoTape:");
		string.append(name);
		string.append(":");
		string.append(duration.toMinutes());
		return string.toString();
	}
	
	public String toText() {
		var string = new StringBuilder();
		string.append("VideoTape:");
		string.append(name);
		string.append(":");
		string.append(duration.toMinutes());
		return string.toString();
	}
}
