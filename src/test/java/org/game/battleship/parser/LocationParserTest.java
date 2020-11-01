package org.game.battleship.parser;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.game.battleship.common.ErrorConstants;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LocationParserTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	

	@Test
	public void shouldParseLocationsAndReturnRespectivePoints() {
		Point pointOne = LocationParser.parseLocation("F5");
		Point pointTwo = LocationParser.parseLocation("A2");
		Point pointThree = LocationParser.parseLocation("B3");
		
		assertEquals(pointOne, new Point(5, 6));
		assertEquals(pointTwo, new Point(2, 1));
		assertEquals(pointThree, new Point(3, 2));
	}
	
	@Test
	public void shouldThrowIllegalArgumentExceptionIfLocationIsInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage(ErrorConstants.ERROR_INVALID_SHIP_OR_MISSILE_LOCATION);
		
		LocationParser.parseLocation("5C");
	}
}
