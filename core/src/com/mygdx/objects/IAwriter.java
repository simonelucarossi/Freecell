package com.mygdx.objects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.GameOfCards;

public class IAwriter {
	String pathFile;
	File file;
	FileWriter fileWriter;
	BufferedWriter writer;

	public IAwriter () throws IOException {
		pathFile = Gdx.files.getExternalStoragePath() + "eclipse-workspace/FreeCell/android/assets/IA/IA_facts.txt";
		this.file = new File(pathFile);
		if (!(file.exists())) {
			file.createNewFile();
		} else {
			file.delete();
			file.createNewFile();
		}
		this.fileWriter = new FileWriter(file);
		writer = new BufferedWriter(fileWriter);
	}

	public void writeOnFile(GameOfCards game) throws IOException {
		this.writer.write("#const allowedMoves = " + game.availableToMove() + ". \n");
		writeCards(game);
		writeScales(game);
		writeCardsInFreeCells(game);
		writeIA();

		writer.flush();
		writer.close();
	}


	public void writeCards(GameOfCards game) throws IOException {
		int pos = 1;

		this.writer.write("% CARDS" + "\n");

		for(int i = 0; i < game.getLevel().getPilesOfCards().size(); i++) {
			pos = 1;
			for(Card cardInspected : game.getLevel().getPilesOfCards().get(i).getCards()) {

				this.writer.write("cards(" + cardInspected.getNumber() + "," + cardInspected.getColumn() + "," + "\"" + cardInspected.getColor()+ "\"" + "," + "\"" + cardInspected.getSuit() + "\"" + "," + pos + "). \n");
				pos++;
			}
			this.writer.write("%--- END COLUMN " + (i+1) + " --- \n \n" );
		}
	}

	public void writeScales(GameOfCards game) throws IOException {
		this.writer.write("% SCALES  " + "\n \n");
		Card cardInspected;

		for(int i = 0; i < game.getLevel().getScales().size(); i++) {
			this.writer.write("scales(" + i + "). \n");

			if(game.getLevel().getScales().get(i).getScale().size() >= 1) {
				cardInspected = game.getLevel().getScales().get(i).getScale().get(game.getLevel().getScales().get(i).getScale().size() - 1);
				this.writer.write("cardOnScale(" + cardInspected.getNumber() + "," + i + "," + "\"" + cardInspected.getSuit() + "\").\n");
			}
			this.writer.write("% --- END SCALE " + (i+1) + " --- \n \n" );
		}

	}
	
	public void writeCardsInFreeCells(GameOfCards game) throws IOException {
		int pos = 1;
		this.writer.write("% CARDS IN FREE CELLS  " + "\n \n");
		Card cardInspected;

		for(int i = 0; i < game.getLevel().getFreeCells().size(); i++) {
			if(game.getLevel().getFreeCells().get(i).getFreeCells().size() == 1) {
				cardInspected = game.getLevel().getFreeCells().get(i).getFreeCells().get(game.getLevel().getFreeCells().get(i).getFreeCells().size() - 1);
				this.writer.write("cards(" + cardInspected.getNumber() + "," + cardInspected.getColumn() + ", \"" + cardInspected.getColor()+ "\",\"" + cardInspected.getSuit() + "\"," + pos + "). \n");
			}
			this.writer.write("% --- END FREE CELL " + (i+1) + " --- \n \n" );
		}
	}
	

	public void writeIA() throws IOException {
		this.writer.write("% IA  " + "\n");
		
		//this.writer.write(":- #count{Num: move(Num,_,_,_,_)} = 0.  :- #count{Num: move(Num,_,_,_,_)} > allowedMoves.  :- #count{Column : selectedColumn(Column)} > 1.  :- selectedColumn(Column), lastCards(Column, Pos, _), noMove(_, Column, _, _, Pos).  :- move(_,_,Color,_,Pos), move(_,_,Color,_,Pos2), #succ(Pos,Pos2).  :- move(Num,_,_,_,Pos), move(Num2,_,_,_,Pos2), #succ(Pos,Pos2), not #prec(Num,Num2).  :- moveAdjacency(Pos,Pos2), not #succ(Pos,Pos2).  landingCards(Num, Column, Color, Suit, Pos) :- unselectedColumns(Column), lastCards(Column, Pos, _), cards(Num, Column, Color, Suit, Pos).  correctLandingCards(LandingNum, Column, Color, Suit, Pos) :- landingCards(LandingNum, Column, Color, Suit, Pos), minimumCard(MinimumNum, Color2), #prec(LandingNum, MinimumNum), Color != Color2.  landingScales(Scale) :- not movingMoreThanOneCard, move(1, _, _, _, _), scales(Scale), #count{Num : cardOnScale(Num, Scale, _)} = 0.  landingScales(Scale) :- not movingMoreThanOneCard, move(Num, _, _, Suit, _), cardOnScale(LandingNum, Scale, Suit), #succ(LandingNum, Num).  :- #count{Column : correctLandingCards(Column, _, _, _, _)} = 0, #count{Scales : landingScales(Scales)} = 0.");
	}

	/*bw.write("Questo � il nostro primo file");
	bw.flush();
	bw.close();
	}*/

}
