package org.game.battleship;

import org.game.battleship.domain.BattleAreaTest;
import org.game.battleship.domain.BattleShipGameTest;
import org.game.battleship.domain.BattleShipTest;
import org.game.battleship.parser.LocationParserTest;
import org.game.battleship.setup.GameSetupTest;
import org.game.battleship.validators.GameSetupValidatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BattleAreaTest.class, BattleShipGameTest.class, BattleShipTest.class, LocationParserTest.class,
		GameSetupTest.class, GameSetupValidatorTest.class })
public class AllTests {

}
