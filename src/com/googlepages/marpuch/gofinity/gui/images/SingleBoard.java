package com.googlepages.marpuch.gofinity.gui.images;

import java.awt.Color;

import com.googlepages.marpuch.gofinity.entity.BoardContent;
import com.googlepages.marpuch.gofinity.entity.FieldContent;
import com.googlepages.marpuch.gofinity.entity.GameParameters;

public class SingleBoard extends AbstractBoardImage {

	public SingleBoard(final BoardContent boardContent,
			final GameParameters gameParameters, final int singleFieldSize) {
		super(boardContent, gameParameters, singleFieldSize);
		drawBoard();
	}

	public void drawBoard()
	{
		drawBackground();
		drawLines();
		drawStones();
	}

	private void drawBackground() {
		// TODO localize me
		graphics.setColor(Color.lightGray);
		graphics.fillRect(0, 0, boardImage.getWidth(), boardImage.getHeight());
	}

	private void drawLines() {
		// TODO localize me
		graphics.setColor(Color.black);
		// vertical
		int xCoordinate = singleFieldSize/2;
		for (int i = 0; i < boardContent.getSize(); i++)
		{
			graphics.drawLine(xCoordinate, 0, xCoordinate, boardImage.getHeight());
			if (i == 0)
				graphics.drawLine(xCoordinate+1, 0, xCoordinate+1, boardImage.getHeight());
			xCoordinate += singleFieldSize;
		}
		// horizontal
		int yCoordinate = singleFieldSize/2;
		for (int i = 0; i < boardContent.getSize(); i++)
		{
			graphics.drawLine(0, yCoordinate, boardImage.getWidth(), yCoordinate);
			if (i == 0)
				graphics.drawLine(0, yCoordinate+1, boardImage.getWidth(), yCoordinate+1);
			yCoordinate += singleFieldSize;
		}
	}

	private void drawStones() {
		for (int x = 0; x < boardContent.getSize(); x++)
		{
			for (int y = 0; y < boardContent.getSize(); y++)
			{
				drawStone(x, y, boardContent.getFieldContent(x, y));
			}
		}
	}

	private void drawStone(final int x, final int y, final FieldContent fieldContent) {
		if (fieldContent.equals(FieldContent.WHITE)
				|| fieldContent.equals(FieldContent.BLACK))
		{
			int xCoordinate = getCoordinate(x);
			int yCoordinate = getCoordinate(y);
			drawStoneToImageCoordinates(xCoordinate, yCoordinate, fieldContent);
		}
	}
}

