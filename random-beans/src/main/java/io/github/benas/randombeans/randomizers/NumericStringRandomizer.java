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
package io.github.benas.randombeans.randomizers;

import io.github.benas.randombeans.api.Randomizer;
import io.github.benas.randombeans.randomizers.internal.IntegerRandomizer;
import io.github.benas.randombeans.randomizers.range.IntegerRangeRandomizer;

/**
 * A {@link Randomizer} that generates numbers in string representation.
 *
 * @author Nikola Milivojevic (0dziga0@gmail.com)
 */
public class NumericStringRandomizer implements Randomizer<String> {

    private Randomizer delegate;

    /**
     * Create a new {@link NumericStringRandomizer}.
     */
    public NumericStringRandomizer() {
        delegate = new IntegerRandomizer();
    }

    /**
     * Create a new {@link NumericStringRandomizer}.
     *
     * @param minNumericValue the min numeric value
     * @param maxNumericValue the max numeric value
     */
    public NumericStringRandomizer(final Integer minNumericValue, final Integer maxNumericValue) {
        delegate = new IntegerRangeRandomizer(minNumericValue, maxNumericValue);
    }

    /**
     * Generate a random value for the given type.
     *
     * @return a random value for the given type
     */
    @Override
    public String getRandomValue() {
        return new StringDelegatingRandomizer(delegate).getRandomValue();
    }
}
