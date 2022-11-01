package fr.uge.blockbuster;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Catalog {
	private final ArrayList<Article> catalog;
	
	public Catalog()
	{
		this.catalog = new ArrayList<Article>();
	}
	
	public void add(Article movie)
	{
		if(lookup(movie.name()))
		{
			throw new IllegalArgumentException("Le film est déja dans le catalogue");
		}
		catalog.add(movie);
	}

	public boolean lookup(String name) {
		for(Article movie:catalog)
		{
			if(movie.name().equals(name))
			{
				return true;
			}
		}
		return false;
	}
	
	public String toText()
	{
		var string = new StringBuilder();
		for(Article movie:catalog)
		{
			if(movie instanceof LaserDisc)
			{
				string.append("LaserDisc:");
				string.append(movie.name());
				string.append("\n");
			}
			else
			{
				string.append("VideoTape:");
				string.append(movie.name());
				string.append(":");
				string.append(movie.duration().toMinutes());
				string.append("\n");
			}
		}
		return string.toString();
	}
	
	public void save(Path path) throws IOException {
		try(var writer = Files.newBufferedWriter(path)){
			for(var article:catalog) {
				writer.write(article.toText());
				writer.newLine();
			}
		}
	}

	public void load(Path path) throws IOException {
		try(var reader = Files.newBufferedReader(path)){
			Article article;
			String line;
			while((line = reader.readLine()) != null)
			{
				article = Article.fromText(line);
				catalog.add(article);
			}
		}
	}
	
}
