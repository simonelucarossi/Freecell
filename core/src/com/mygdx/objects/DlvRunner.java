package com.mygdx.objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.badlogic.gdx.Gdx;

public class DlvRunner {
	public String readedLine;

    public DlvRunner () {
    	this.readedLine = null;
		String pathFile = Gdx.files.getExternalStoragePath() + "eclipse-workspace/FreeCell/android/assets/IA";

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c ", "\"" + pathFile + "/dlv.mingw-odbc.exe\"", "-n=all",  "-silent",  "-nofacts",  "-filter=move", "\"" + pathFile + "/IA_facts.txt" + "\"", "\"" + pathFile + "/IA.txt\"" );

        try {
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            if((line = reader.readLine()) != null) {
               readedLine = line; 
            }

            int exitCode = process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}