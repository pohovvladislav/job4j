package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Popov Vladislav (mailto:navodbmd.2@mail.ru)
* @version $Id$
* @since 0.1
*/

public class CalculateTest {
	/**
	* Test echo.
	*/@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Vladislav";
		String expect = "Echo, echo, echo : Vladislav";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}