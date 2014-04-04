package edu.berkeley.ischool.aep;

/**
 * Created by prabha on 3/7/14.
 */
public interface Bestable<T> { //parameterizing the method using <T>
    boolean betterThan(T other);
}
