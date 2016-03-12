package cz.vendasky;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FractionalTreeTest {

    FractionalTree fractionalTree;

    @Before
    public void setUp() {
        fractionalTree = new FractionalTree(154, 41);
    }

    @Test
    public void shouldCreateParentOfActualFraction() {
        Fraction parent = new Fraction(113, 41);
        fractionalTree.generateParentOfActualFraction();
        assertTrue(fractionalTree.getActualFraction().equals(parent));
    }

    @Test
    public void shouldCheckIfRootFound() {
        assertFalse(fractionalTree.checkIfRootFound());
    }

}