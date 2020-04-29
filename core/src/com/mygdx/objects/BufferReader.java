package com.mygdx.objects;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.badlogic.gdx.Gdx;

public class BufferReader {
	BufferedReader lineReader;
	String lineReaded;
	
	public BufferReader() {
		try {
			this.lineReader = new BufferedReader(new FileReader("1.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		this.lineReaded = "";
	}
	
	public BufferReader(int file) throws FileNotFoundException {
		this.lineReader = new BufferedReader(new FileReader(Gdx.files.getExternalStoragePath() + "eclipse-workspace/FreeCell/android/assets/levels/GAME_" + file + ".txt"));
		this.lineReaded = "";
	}
	
	public boolean hasLine() {
		if(lineReaded == null) {
			return false;
		}
		return true;
	}
	
	public void readLine() throws IOException {
		lineReaded = this.lineReader.readLine();
	}

	/**
	 * @return the lineReader
	 */
	public BufferedReader getLineReader() {
		return lineReader;
	}

	/**
	 * @param lineReader the lineReader to set
	 */
	public void setLineReader(BufferedReader lineReader) {
		this.lineReader = lineReader;
	}

	/**
	 * @return the lineReaded
	 */
	public String getLineReaded() {
		return lineReaded;
	}

	/**
	 * @param lineReaded the lineReaded to set
	 */
	public void setLineReaded(String lineReaded) {
		this.lineReaded = lineReaded;
	}
	
	
}
