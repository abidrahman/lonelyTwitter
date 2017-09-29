/**
 * Tweetable class
 *
 * Copyright 2017 Abid Rahman
 *
 * @author arahman1
 * @version 1.0
 * @created 2017-09-27
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * The Tweetable interface states that any class
 * that implements this interface must also
 * implement the getText and getDate functions.
 * All Tweet classes should implement this interface.
 */

public interface Tweetable {
    public String getText();
    public Date getDate();
}
