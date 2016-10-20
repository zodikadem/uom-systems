/*
 *  Unit-API - Units of Measurement API for Java
 *  Copyright (c) 2005-2015, Jean-Marie Dautelle, Werner Keil, V2COM.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363 nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package systems.uom.common;

import static tec.uom.se.unit.MetricPrefix.MICRO;
import static si.uom.SI.*;

import tec.uom.se.AbstractSystemOfUnits;
import tec.uom.se.AbstractUnit;
import tec.uom.se.format.SimpleUnitFormat;
import tec.uom.se.function.RationalConverter;
import tec.uom.se.unit.ProductUnit;
import tec.uom.se.unit.TransformedUnit;

import javax.measure.Unit;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Area;

import javax.measure.quantity.Energy;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Power;
import javax.measure.quantity.Temperature;
import javax.measure.quantity.Time;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Volume;
import javax.measure.spi.SystemOfUnits;

/**
 * <p>
 * This class contains units from the United States customary system.
 * </p>
 * <p>
 * 
 * @noextend This class is not intended to be extended by clients.
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.24, $Date: 2016-10-20 $
 * @see <a href="http://en.wikipedia.org/wiki/United_States_customary_units">
 *      Wikipedia: United State Customary Units</a>
 * @see <a href=
 *      "https://en.wikipedia.org/wiki/Imperial_and_US_customary_measurement_systems">
 * @since 0.3
 */
public final class USCustomary extends AbstractSystemOfUnits {
	private static final String SYSTEM_NAME = "United State Customary Units";

	/**
	 * Default constructor (prevents this class from being instantiated).
	 */
	private USCustomary() {
	}

	/**
	 * Returns the unique instance of this class.
	 * 
	 * @return the USCustomary instance.
	 */
	public static SystemOfUnits getInstance() {
		return INSTANCE;
	}

	private static final USCustomary INSTANCE = new USCustomary();

	////////////
	// Length //
	////////////
	/**
	 * US name for {@link SI#METRE}.
	 */
	public static final Unit<Length> METER = addUnit(METRE);

	/**
	 * A unit of length equal to <code>0.3048 m</code> (standard name
	 * <code>ft</code>).
	 */
	public static final Unit<Length> FOOT = addUnit(METER.multiply(3048).divide(10000), "Foot", "ft");

	/**
	 * A unit of length equal to <code>1200/3937 m</code> (standard name
	 * <code>foot_survey_us</code>). See also:
	 * <a href="http://www.sizes.com/units/foot.htm">foot</a>
	 */
	public static final Unit<Length> FOOT_SURVEY = addUnit(METER.multiply(1200).divide(3937), "US Survey foot",
			"ft_survey_us");

	/**
	 * A unit of length equal to <code>0.9144 m</code> (standard name
	 * <code>yd</code>).
	 */
	public static final Unit<Length> YARD = addUnit(FOOT.multiply(3), "Yard", "yd");

	/**
	 * A unit of length equal to <code>0.0254 m</code> (standard name
	 * <code>in</code>).
	 */
	public static final Unit<Length> INCH = addUnit(FOOT.divide(12), "Inch", "in", true);

	/**
	 * A unit of length equal to <code>1609.344 m</code> (standard name
	 * <code>mi</code>).
	 */
	public static final Unit<Length> MILE = addUnit(METER.multiply(1609344).divide(1000), "Mile", "mi");

	/**
	 * A unit of length equal to the distance that light travels in one year
	 * through a vacuum (standard name <code>ly</code>).
	 */
	public static final Unit<Length> LIGHT_YEAR = addUnit(METRE.multiply(9.460528405e15), "Light year", "ly");

	/**
	 * A unit of length equal to <code>1852.0 m</code> (standard name
	 * <code>nmi</code>).
	 */
	public static final Unit<Length> NAUTICAL_MILE = addUnit(METER.multiply(1852), "Nautical mile", "nmi");

	//////////
	// Mass //
	//////////

	/**
	 * A unit of mass equal to <code>453.59237 grams</code> (avoirdupois pound,
	 * standard name <code>lb</code>).
	 */
	public static final Unit<Mass> POUND = addUnit(KILOGRAM.multiply(45359237).divide(100000000), "Pound", "lb");
	// Messages.US_lb_name);

	/**
	 * A unit of mass equal to <code>1 / 16 {@link #POUND}</code> (standard name
	 * <code>oz</code>).
	 */
	public static final Unit<Mass> OUNCE = addUnit(POUND.divide(16), "oz", true);

	/**
	 * A unit of mass equal to <code>2000 {@link #POUND}</code> (short ton,
	 * standard name <code>ton</code>).
	 */
	public static final Unit<Mass> TON = addUnit(POUND.multiply(2000), "ton_us");

	/////////////////
	// Temperature //
	/////////////////

	/**
	 * A unit of temperature equal to <code>5/9 °K</code> (standard name
	 * <code>°R</code>).
	 */
	public static final Unit<Temperature> RANKINE = addUnit(KELVIN.multiply(5).divide(9));

	/**
	 * A unit of temperature equal to degree Rankine minus
	 * <code>459.67 °R</code> (standard name <code>°F</code>).
	 * 
	 * @see #RANKINE
	 */
	public static final Unit<Temperature> FAHRENHEIT = addUnit(RANKINE.shift(459.67), "°F");

	///////////
	// Angle //
	///////////

	/**
	 * A unit of angle equal to a full circle or <code>2<i>&pi;</i>
	 * {@link SI#RADIAN}</code> (standard name <code>rev</code>).
	 */
	public static final Unit<Angle> REVOLUTION = addUnit(RADIAN.multiply(2).multiply(Math.PI).asType(Angle.class),
			"rev", true);

	/**
	 * A unit of angle equal to <code>1/360 {@link #REVOLUTION}</code> (standard
	 * name <code>deg</code>).
	 */
	public static final Unit<Angle> DEGREE_ANGLE = addUnit(REVOLUTION.divide(360));

	/**
	 * A unit of angle equal to <code>1/60 {@link #DEGREE_ANGLE}</code>
	 * (standard name <code>'</code>).
	 */
	public static final Unit<Angle> MINUTE_ANGLE = addUnit(DEGREE_ANGLE.divide(60));

	/**
	 * A unit of angle equal to <code>1/60 {@link #MINUTE_ANGLE}</code>
	 * (standard name <code>"</code>).
	 */
	public static final Unit<Angle> SECOND_ANGLE = addUnit(MINUTE_ANGLE.divide(60));

	/**
	 * A unit of angle equal to <code>0.01 {@link SI#RADIAN}</code> (standard
	 * name <code>centiradian</code>).
	 */
	public static final Unit<Angle> CENTIRADIAN = addUnit(RADIAN.divide(100));

	/**
	 * A unit of angle measure equal to <code>1/400 {@link #REVOLUTION}</code>
	 * (standard name <code>grade</code> ).
	 */
	public static final Unit<Angle> GRADE = addUnit(REVOLUTION.divide(400));

	//////////////
	// Time //
	//////////////
	/**
	 * A unit of time equal to <code>60 s</code> (standard name <code>min</code>
	 * ).
	 */
	public static final Unit<Time> MINUTE = addUnit(SECOND.multiply(60));

	/**
	 * A unit of duration equal to <code>60 {@link #MINUTE}</code> (standard
	 * name <code>h</code>).
	 */
	public static final Unit<Time> HOUR = addUnit(MINUTE.multiply(60));

	//////////////
	// Speed //
	//////////////
	/**
	 * A unit of velocity expressing the number of {@link #FOOT feet} per
	 * {@link Units#SECOND second}.
	 */
	public static final Unit<Speed> FOOT_PER_SECOND = addUnit(FOOT.divide(SECOND)).asType(Speed.class);

	/**
	 * Alias for {@link FOOT_PER_SECOND}
	 * 
	 * @deprecated use FOOT_PER_SECOND.
	 */
	public static final Unit<Speed> FEET_PER_SECOND = FOOT_PER_SECOND;

	/**
	 * A unit of velocity expressing the number of international {@link #MILE
	 * miles} per {@link #HOUR hour} (abbreviation <code>mph</code>).
	 */
	public static final Unit<Speed> MILE_PER_HOUR = addUnit(MILE.divide(HOUR).asType(Speed.class), "Mile per hour",
			"mph");

	/**
	 * Alias for {@link MILE_PER_HOUR}
	 * 
	 * @deprecated use MILE_PER_HOUR.
	 */
	public static final Unit<Speed> MILES_PER_HOUR = MILE_PER_HOUR;

	/**
	 * A unit of velocity expressing the number of {@link #NAUTICAL_MILE
	 * nautical miles} per {@link #HOUR hour} (abbreviation <code>kn</code>).
	 */
	public static final Unit<Speed> KNOT = addUnit(NAUTICAL_MILE.divide(HOUR).asType(Speed.class), "Knot", "kn");

	//////////
	// Area //
	//////////

	/**
	 * A unit of area (standard name <code>sft</code> ).
	 */
	public static final Unit<Area> SQUARE_FOOT = addUnit(new ProductUnit<Area>((AbstractUnit<?>) FOOT.multiply(FOOT)));

	/**
	 * A unit of area equal to <code>100 m²</code> (standard name <code>a</code>
	 * ).
	 */
	public static final Unit<Area> ARE = addUnit(SQUARE_METRE.multiply(100));

	/**
	 * A unit of area equal to <code>100 {@link #ARE}</code> (standard name
	 * <code>ha</code>).
	 */
	public static final Unit<Area> HECTARE = addUnit(ARE.multiply(100)); // Exact.

	/**
	 * The acre is a unit of area used in the imperial and U.S. customary
	 * systems. It is equivalent to <code>43,560 square feet</code>. An acre is
	 * about 40% of a <code>HECTARE</code> – slightly smaller than an American
	 * football field. (standard name <code>ac</code> ).
	 * 
	 * @see <a href="http://en.wikipedia.org/wiki/Acre">Wikipedia: Acre</a>
	 */
	public static final Unit<Area> ACRE = addUnit(SQUARE_FOOT.multiply(43560));

	////////////
	// Energy //
	////////////

	/**
	 * A unit of energy equal to one electron-volt (standard name
	 * <code>eV</code>, also recognized <code>keV, MeV, GeV</code>).
	 */
	public static final Unit<Energy> ELECTRON_VOLT = addUnit(JOULE.multiply(1.602176462e-19), "Electron Volt", "eV");

	////////////
	// Power //
	////////////

	/**
	 * Horsepower (HP) is the name of several units of measurement of power. The
	 * most common definitions equal between 735.5 and 750 watts. Horsepower was
	 * originally defined to compare the output of steam engines with the power
	 * of draft horses. The unit was widely adopted to measure the output of
	 * piston engines, turbines, electric motors, and other machinery. The
	 * definition of the unit varied between geographical regions. Most
	 * countries now use the SI unit watt for measurement of power. With the
	 * implementation of the EU Directive 80/181/EEC on January 1, 2010, the use
	 * of horsepower in the EU is only permitted as supplementary unit.
	 */
	public static final Unit<Power> HORSEPOWER = addUnit(WATT.multiply(735.499), "Horsepower", "HP");

	////////////
	// Volume //
	////////////
	/**
	 * A unit of volume equal to one cubic decimeter (default label
	 * <code>L</code>, also recognized <code>µL, mL, cL, dL</code>).
	 */
	public static final TransformedUnit<Volume> LITER = addUnit(
			new TransformedUnit<Volume>(CUBIC_METRE, new RationalConverter(1, 1000)));

	/**
	 * A unit of volume equal to one cubic inch (<code>in³</code>).
	 */
	public static final Unit<Volume> CUBIC_INCH = addUnit(INCH.pow(3).asType(Volume.class));

	/**
	 * A unit of volume equal to one US dry gallon. (standard name
	 * <code>gallon_dry_us</code>).
	 */
	public static final Unit<Volume> GALLON_DRY = addUnit(CUBIC_INCH.multiply(2688025).divide(10000));

	/**
	 * The cubic foot is an imperial and US customary (non-metric) unit of
	 * volume, used in the United States, Canada, and the United Kingdom. It is
	 * defined as the volume of a cube with sides of one foot (0.3048 m) in
	 * length. Its volume is 28.3168 liters or about 1⁄35 of a cubic meter. (
	 * <code>ft³</code>).
	 */
	public static final Unit<Volume> CUBIC_FOOT = addUnit(CUBIC_INCH.multiply(1728), "ft³", true);

	/**
	 * An acre-foot is a unit of volume commonly used in the United States in
	 * reference to large-scale water resources, such as reservoirs, aqueducts,
	 * canals, sewer flow capacity, irrigation water, and river flows.
	 */
	public static final Unit<Volume> ACRE_FOOT = addUnit(CUBIC_FOOT.multiply(43560), "Acre-foot", "ac ft");

	/**
	 * A unit of volume equal to one US gallon, Liquid Unit. The U.S. liquid
	 * gallon is based on the Queen Anne or Wine gallon occupying 231 cubic
	 * inches (standard name <code>gal</code>).
	 */
	public static final Unit<Volume> GALLON_LIQUID = addUnit(CUBIC_INCH.multiply(231));

	/**
	 * A unit of volume equal to <code>1 / 128 {@link #GALLON_LIQUID}</code>
	 * (standard name <code>oz_fl</code>).
	 */
	public static final Unit<Volume> FLUID_OUNCE = addUnit(GALLON_LIQUID.divide(128));

	/**
	 * A unit of volume equal to 4 US oz_fl (standard name <code>liq.gi</code>).
	 */
	public static final Unit<Volume> GILL_LIQUID = addUnit(FLUID_OUNCE.multiply(4), "Liquid Gill", "liq.gi");

	/**
	 * A unit of volume <code>~ 1 drop or 0.95 grain of water </code> (standard
	 * name <code>min</code>).
	 */
	public static final Unit<Volume> MINIM = addUnit(MICRO(LITER).multiply(61.61152d));

	/**
	 * A unit of volume equal to <code>60 {@link #MINIM}</code> (standard name
	 * <code>fl dr</code>).
	 */
	public static final Unit<Volume> FLUID_DRAM = addUnit(MINIM.multiply(60));

	/**
	 * The cup is a unit of measurement for volume, used in cooking to measure
	 * liquids (fluid measurement) and bulk foods such as granulated sugar (dry
	 * measurement). A cup is equal to <code>8 {@link #FLUID_OUNCE}</code>
	 * (standard name <code>cup</code>).
	 */
	public static final Unit<Volume> CUP = addUnit(FLUID_OUNCE.multiply(8));

	/**
	 * A unit of volume equal to <code>80 {@link #MINIM}</code> (standard name
	 * <code>tsp</code>).
	 */
	public static final Unit<Volume> TEASPOON = addUnit(MINIM.multiply(80));

	/**
	 * A unit of volume equal to <code>3 {@link #TEASPOON}</code> (standard name
	 * <code>Tbsp</code>).
	 */
	public static final Unit<Volume> TABLESPOON = addUnit(TEASPOON.multiply(3));

	/**
	 * A unit of volume equal to <code>238.4810 {@link #LITER}</code> (standard
	 * name <code>bbl</code>).
	 */
	public static final Unit<Volume> BARREL = addUnit(LITER.multiply(238.4810d), "Barrel", "bbl");

	/**
	 * A unit of volume equal to <code>4 {@link #GILL_LIQUID}</code> (standard
	 * name <code>pt</code>).
	 */
	public static final Unit<Volume> PINT = addUnit(GILL_LIQUID.multiply(4), "Pint", "pt");

	/**
	 * Holds the international foot: 0.3048 m exact.
	 */
	// private static final int INTERNATIONAL_FOOT_DIVIDEND = 3048;

	// private static final int INTERNATIONAL_FOOT_DIViSOR = 10000;

	/**
	 * Adds a new unit to the collection.
	 * 
	 * @param unit
	 *            the unit being added.
	 * @return <code>unit</code>.
	 */
	protected static <U extends Unit<?>> U addUnit(U unit) {
		INSTANCE.units.add(unit);
		return unit;
	}

	@Override
	public String getName() {
		return SYSTEM_NAME;
	}

	/**
	 * Adds a new unit not mapped to any specified quantity type and puts a text
	 * as symbol or label.
	 *
	 * @param unit
	 *            the unit being added.
	 * @param name
	 *            the string to use as name
	 * @param text
	 *            the string to use as label or symbol
	 * @param isLabel
	 *            if the string should be used as a label or not
	 * @return <code>unit</code>.
	 */
	private static <U extends Unit<?>> U addUnit(U unit, String name, String text, boolean isLabel) {
		if (isLabel) {
			SimpleUnitFormat.getInstance().label(unit, text);
		}
		if (name != null && unit instanceof AbstractUnit) {
			return Helper.addUnit(INSTANCE.units, unit, name);
		} else {
			INSTANCE.units.add(unit);
		}
		return unit;
	}

	/**
	 * Adds a new unit not mapped to any specified quantity type and puts a text
	 * as symbol or label.
	 *
	 * @param unit
	 *            the unit being added.
	 * @param name
	 *            the string to use as name
	 * @param label
	 *            the string to use as label
	 * @return <code>unit</code>.
	 */
	private static <U extends Unit<?>> U addUnit(U unit, String name, String label) {
		return addUnit(unit, name, label, true);
	}

	/**
	 * Adds a new unit not mapped to any specified quantity type and puts a text
	 * as symbol or label.
	 *
	 * @param unit
	 *            the unit being added.
	 * @param text
	 *            the string to use as label or symbol
	 * @param isLabel
	 *            if the string should be used as a label or not
	 * @return <code>unit</code>.
	 */
	private static <U extends Unit<?>> U addUnit(U unit, String text, boolean isLabel) {
		return addUnit(unit, null, text, isLabel);
	}
	
	/**
	 * Adds a new unit not mapped to any specified quantity type and puts a text
	 * as label.
	 *
	 * @param unit
	 *            the unit being added.
	 * @param text
	 *            the string to use as label or symbol
	 * @return <code>unit</code>.
	 */
	private static <U extends Unit<?>> U addUnit(U unit, String text) {
		return addUnit(unit, null, text, true);
	}
}
