/*
 * The MIT License
 *
 *   Copyright (c) 2016, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 *
 */
package io.github.benas.randombeans.randomizers.java8;

import io.github.benas.randombeans.api.Randomizer;
import io.github.benas.randombeans.randomizers.range.IntegerRangeRandomizer;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * A {@link Randomizer} that generates random {@link Duration}.
 *
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 */
public class DurationRandomizer implements Randomizer<Duration> {

    public static final int MIN_AMOUNT = 0;
    public static final int MAX_AMOUNT = 100;
    
    IntegerRangeRandomizer amountRandomizer = new IntegerRangeRandomizer(MIN_AMOUNT, MAX_AMOUNT);

    @Override
    public Duration getRandomValue() {
        int randomAmount = amountRandomizer.getRandomValue();
        ChronoUnit randomUnit = getRandomChronoUnit();
        return Duration.of(randomAmount, randomUnit);
    }

    private ChronoUnit getRandomChronoUnit() {
        return ChronoUnit.HOURS;
        // Returning a random unit leeds to java.time.temporal.UnsupportedTemporalTypeException: Unit must not have an estimated duration
        // see javadoc of java.time.temporal.TemporalUnit.isDurationEstimated()
        /* ChronoUnit[] chronoUnits = ChronoUnit.values();
        return chronoUnits[Constants.RANDOM.nextInt(chronoUnits.length)]; */
    }
}
