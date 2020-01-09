package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class LoaderTexture {
	public Texture textureBackgroundTable;
	public Texture textureAceFlowers, textureTwoFlowers, textureThreeFlowers, textureFourFlowers, textureFiveFlowers, textureSixFlowers, textureSevenFlowers, textureEightFlowers, textureNineFlowers, textureTenFlowers;
	public Texture textureAceSquares, textureTwoSquares, textureThreeSquares, textureFourSquares, textureFiveSquares, textureSixSquares, textureSevenSquares, textureEightSquares, textureNineSquares, textureTenSquares;
	public Texture textureAceSpades, textureTwoSpades, textureThreeSpades, textureFourSpades, textureFiveSpades, textureSixSpades, textureSevenSpades, textureEightSpades, textureNineSpades, textureTenSpades;
	public Texture textureAceHearts, textureTwoHearts, textureThreeHearts, textureFourHearts, textureFiveHearts, textureSixHearts, textureSevenHearts, textureEightHearts, textureNineHearts, textureTenHearts;
	public Texture textureKnightFlowers, textureKnightSpades, textureKnightHearts, textureKnightSquares;
	public Texture textureQueenFlowers, textureQueenSpades, textureQueenHearts, textureQueenSquares;
	public Texture textureKingFlowers, textureKingSpades, textureKingHearts, textureKingSquares;
	public Texture textureEmptyBoxe, textureAces, textureMenuGameBackground, textureCardsGameMenu, texturePlayButton, texturePauseButton, textureUndoButton;
	
	public LoaderTexture() {
		
		//////
		// LOADING TEXTURES
		
		/* LOADING TEXTURES FLOWERS CARDS */
		textureAceFlowers = new Texture("AC.png");
		textureTwoFlowers = new Texture("2C.png");
		textureThreeFlowers = new Texture("3C.png");
		textureFourFlowers = new Texture("4C.png");
		textureFiveFlowers = new Texture("5C.png");
		textureSixFlowers = new Texture("6C.png");
		textureSevenFlowers = new Texture("7C.png");
		textureEightFlowers = new Texture("8C.png");
		textureNineFlowers = new Texture("9C.png");
		textureTenFlowers = new Texture("10C.png");
		textureKnightFlowers = new Texture("JC.png");
		textureQueenFlowers = new Texture("QC.png");
		textureKingFlowers = new Texture("KC.png");
		
		/* LOADING TEXTURES SPADES CARDS */
		textureAceSpades = new Texture("AS.png");
		textureTwoSpades = new Texture("2S.png");
		textureThreeSpades = new Texture("3S.png");
		textureFourSpades = new Texture("4S.png");
		textureFiveSpades = new Texture("5S.png");
		textureSixSpades = new Texture("6S.png");
		textureSevenSpades = new Texture("7S.png");
		textureEightSpades = new Texture("8S.png");
		textureNineSpades = new Texture("9S.png");
		textureTenSpades = new Texture("10S.png");
		textureKnightSpades = new Texture("JS.png");
		textureQueenSpades = new Texture("QS.png");
		textureKingSpades = new Texture("KS.png");
		
		/* LOADING TEXTURES HEARTS CARDS */
		textureAceHearts = new Texture("AH.png");
		textureTwoHearts = new Texture("2H.png");
		textureThreeHearts = new Texture("3H.png");
		textureFourHearts = new Texture("4H.png");
		textureFiveHearts = new Texture("5H.png");
		textureSixHearts = new Texture("6H.png");
		textureSevenHearts = new Texture("7H.png");
		textureEightHearts = new Texture("8H.png");
		textureNineHearts = new Texture("9H.png");
		textureTenHearts = new Texture("10H.png");
		textureKnightHearts = new Texture("JH.png");
		textureQueenHearts = new Texture("QH.png");
		textureKingHearts = new Texture("KH.png");
		
		/* LOADING TEXTURES SQUARES CARDS */
		textureAceSquares = new Texture("AD.png");
		textureTwoSquares = new Texture("2D.png");
		textureThreeSquares = new Texture("3D.png");
		textureFourSquares = new Texture("4D.png");
		textureFiveSquares = new Texture("5D.png");
		textureSixSquares = new Texture("6D.png");
		textureSevenSquares = new Texture("7D.png");
		textureEightSquares = new Texture("8D.png");
		textureNineSquares = new Texture("9D.png");
		textureTenSquares = new Texture("10D.png");
		textureKnightSquares = new Texture("JD.png");
		textureQueenSquares = new Texture("QD.png");
		textureKingSquares = new Texture("KD.png");
		
		/* LOADING SYSTEM TEXTURES  */
		textureBackgroundTable = new Texture("green_background_table.jpg");
		textureEmptyBoxe = new Texture("empty_box.png");
		textureAces = new Texture("aces.png");
		textureMenuGameBackground = new Texture("menu_game_background.png");
		textureCardsGameMenu = new Texture("cards.png");
		texturePauseButton = new Texture("pause_button.png");
		texturePlayButton = new Texture("play_button.png");
		textureUndoButton = new Texture("undo_button.png");
	}
	
}