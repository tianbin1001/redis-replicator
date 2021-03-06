/*
 * Copyright 2016 leon chen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.moilioncircle.redis.replicator.rdb.datatype;

import java.io.Serializable;

/**
 * @author Leon Chen
 * @since 2.1.0
 */
public class ZSetEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    private String element;
    private double score;
    private byte[] rawElement;

    public ZSetEntry() {
    }

    public ZSetEntry(String element, double score) {
        this(element, score, null);
    }

    public ZSetEntry(String element, double score, byte[] rawElement) {
        this.element = element;
        this.score = score;
        this.rawElement = rawElement;
    }

    public String getElement() {
        return element;
    }

    public double getScore() {
        return score;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public byte[] getRawElement() {
        return rawElement;
    }

    public void setRawElement(byte[] rawElement) {
        this.rawElement = rawElement;
    }

    @Override
    public String toString() {
        return "[" + element + ", " + score + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZSetEntry zSetEntry = (ZSetEntry) o;

        if (Double.compare(zSetEntry.score, score) != 0) return false;
        return element.equals(zSetEntry.element);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = element.hashCode();
        temp = Double.doubleToLongBits(score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
