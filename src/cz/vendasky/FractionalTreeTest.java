package cz.vendasky;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
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

    @Test
    public void shouldReturnReversedPath() {
        fractionalTree.generateParentOfActualFraction();
        assertEquals("R", fractionalTree.getPath());
    }

    @Test
    public void shouldFindPathToRoot() {
        fractionalTree.findPathToRoot();
        assertEquals("LLLLLLLLLRRRLRRR", fractionalTree.getPath());
    }

}