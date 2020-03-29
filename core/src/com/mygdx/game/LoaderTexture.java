package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class LoaderTexture {
	/* TEXTURE NORMAL MODE CARDS*/
	public Texture textureBackgroundTable;
	public Texture textureAceFlowers, textureTwoFlowers, textureThreeFlowers, textureFourFlowers, textureFiveFlowers, textureSixFlowers, textureSevenFlowers, textureEightFlowers, textureNineFlowers, textureTenFlowers;
	public Texture textureAceSquares, textureTwoSquares, textureThreeSquares, textureFourSquares, textureFiveSquares, textureSixSquares, textureSevenSquares, textureEightSquares, textureNineSquares, textureTenSquares;
	public Texture textureAceSpades, textureTwoSpades, textureThreeSpades, textureFourSpades, textureFiveSpades, textureSixSpades, textureSevenSpades, textureEightSpades, textureNineSpades, textureTenSpades;
	public Texture textureAceHearts, textureTwoHearts, textureThreeHearts, textureFourHearts, textureFiveHearts, textureSixHearts, textureSevenHearts, textureEightHearts, textureNineHearts, textureTenHearts;
	public Texture textureKnightFlowers, textureKnightSpades, textureKnightHearts, textureKnightSquares;
	public Texture textureQueenFlowers, textureQueenSpades, textureQueenHearts, textureQueenSquares;
	public Texture textureKingFlowers, textureKingSpades, textureKingHearts, textureKingSquares;
	
	/* TEXTURE SELECTED MODE CARDS */
	public Texture textureAceFlowersSelected, textureTwoFlowersSelected, textureThreeFlowersSelected, textureFourFlowersSelected, textureFiveFlowersSelected, textureSixFlowersSelected, textureSevenFlowersSelected, textureEightFlowersSelected, textureNineFlowersSelected, textureTenFlowersSelected;
	public Texture textureAceSquaresSelected, textureTwoSquaresSelected, textureThreeSquaresSelected, textureFourSquaresSelected, textureFiveSquaresSelected, textureSixSquaresSelected, textureSevenSquaresSelected, textureEightSquaresSelected, textureNineSquaresSelected, textureTenSquaresSelected;
	public Texture textureAceSpadesSelected, textureTwoSpadesSelected, textureThreeSpadesSelected, textureFourSpadesSelected, textureFiveSpadesSelected, textureSixSpadesSelected, textureSevenSpadesSelected, textureEightSpadesSelected, textureNineSpadesSelected, textureTenSpadesSelected;
	public Texture textureAceHeartsSelected, textureTwoHeartsSelected, textureThreeHeartsSelected, textureFourHeartsSelected, textureFiveHeartsSelected, textureSixHeartsSelected, textureSevenHeartsSelected, textureEightHeartsSelected, textureNineHeartsSelected, textureTenHeartsSelected;
	public Texture textureKnightFlowersSelected, textureKnightSpadesSelected, textureKnightHeartsSelected, textureKnightSquaresSelected;
	public Texture textureQueenFlowersSelected, textureQueenSpadesSelected, textureQueenHeartsSelected, textureQueenSquaresSelected;
	public Texture textureKingFlowersSelected, textureKingSpadesSelected, textureKingHeartsSelected, textureKingSquaresSelected;
	
	
	public Texture textureEmptyBoxe, textureScales, textureAces, textureMenuGameBackground, textureCardsGameMenu, texturePlayButton, texturePauseButton, textureUndoButton;
	
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
		textureScales = new Texture("scales.png");
		textureAces = new Texture("aces.png");
		textureMenuGameBackground = new Texture("menu_game_background.png");
		textureCardsGameMenu = new Texture("cards.png");
		texturePauseButton = new Texture("pause_button.png");
		texturePlayButton = new Texture("play_button.png");
		textureUndoButton = new Texture("undo_button.png");
		
		
		
		/* LOADING TEXTURES SELECTED FLOWERS CARDS */
		textureAceFlowersSelected = new Texture("AC_selected.png");
		textureTwoFlowersSelected = new Texture("2C_selected.png");
		textureThreeFlowersSelected = new Texture("3C_selected.png");
		textureFourFlowersSelected = new Texture("4C_selected.png");
		textureFiveFlowersSelected = new Texture("5C_selected.png");
		textureSixFlowersSelected = new Texture("6C_selected.png");
		textureSevenFlowersSelected = new Texture("7C_selected.png");
		textureEightFlowersSelected = new Texture("8C_selected.png");
		textureNineFlowersSelected = new Texture("9C_selected.png");
		textureTenFlowersSelected = new Texture("10C_selected.png");
		textureKnightFlowersSelected = new Texture("JC_selected.png");
		textureQueenFlowersSelected = new Texture("QC_selected.png");
		textureKingFlowersSelected = new Texture("KC_selected.png");
		
		/* LOADING TEXTURES SELECTED SPADES CARDS */
		textureAceSpadesSelected = new Texture("AS_selected.png");
		textureTwoSpadesSelected = new Texture("2S_selected.png");
		textureThreeSpadesSelected = new Texture("3S_selected.png");
		textureFourSpadesSelected = new Texture("4S_selected.png");
		textureFiveSpadesSelected = new Texture("5S_selected.png");
		textureSixSpadesSelected = new Texture("6S_selected.png");
		textureSevenSpadesSelected = new Texture("7S_selected.png");
		textureEightSpadesSelected = new Texture("8S_selected.png");
		textureNineSpadesSelected = new Texture("9S_selected.png");
		textureTenSpadesSelected = new Texture("10S_selected.png");
		textureKnightSpadesSelected = new Texture("JS_selected.png");
		textureQueenSpadesSelected = new Texture("QS_selected.png");
		textureKingSpadesSelected = new Texture("KS_selected.png");
		
		/* LOADING TEXTURES SELECTED HEARTS CARDS */
		textureAceHeartsSelected = new Texture("AH_selected.png");
		textureTwoHeartsSelected = new Texture("2H_selected.png");
		textureThreeHeartsSelected = new Texture("3H_selected.png");
		textureFourHeartsSelected = new Texture("4H_selected.png");
		textureFiveHeartsSelected = new Texture("5H_selected.png");
		textureSixHeartsSelected = new Texture("6H_selected.png");
		textureSevenHeartsSelected = new Texture("7H_selected.png");
		textureEightHeartsSelected = new Texture("8H_selected.png");
		textureNineHeartsSelected = new Texture("9H_selected.png");
		textureTenHeartsSelected = new Texture("10H_selected.png");
		textureKnightHeartsSelected = new Texture("JH_selected.png");
		textureQueenHeartsSelected = new Texture("QH_selected.png");
		textureKingHeartsSelected = new Texture("KH_selected.png");
		
		/* LOADING TEXTURES SELECTED SQUARES CARDS */
		textureAceSquaresSelected = new Texture("AD_selected.png");
		textureTwoSquaresSelected = new Texture("2D_selected.png");
		textureThreeSquaresSelected = new Texture("3D_selected.png");
		textureFourSquaresSelected = new Texture("4D_selected.png");
		textureFiveSquaresSelected = new Texture("5D_selected.png");
		textureSixSquaresSelected = new Texture("6D_selected.png");
		textureSevenSquaresSelected = new Texture("7D_selected.png");
		textureEightSquaresSelected = new Texture("8D_selected.png");
		textureNineSquaresSelected = new Texture("9D_selected.png");
		textureTenSquaresSelected = new Texture("10D_selected.png");
		textureKnightSquaresSelected = new Texture("JD_selected.png");
		textureQueenSquaresSelected = new Texture("QD_selected.png");
		textureKingSquaresSelected = new Texture("KD_selected.png");
		
		/* LOADING SYSTEM TEXTURES  */
		textureBackgroundTable = new Texture("green_background_table.jpg");
		textureEmptyBoxe = new Texture("empty_box.png");
		textureScales = new Texture("scales.png");
		textureAces = new Texture("aces.png");
		textureMenuGameBackground = new Texture("menu_game_background.png");
		textureCardsGameMenu = new Texture("cards.png");
		texturePauseButton = new Texture("pause_button.png");
		texturePlayButton = new Texture("play_button.png");
		textureUndoButton = new Texture("undo_button.png");
	}
}