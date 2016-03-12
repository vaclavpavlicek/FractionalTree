package cz.vendasky;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FractionalTreeTest {

    FractionalTree fractionalTree;

    @Before
    public void setUp() {
        fractionalTree = FractionalTree.createFractionalTree("154 41");
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

    @Test
    public void shouldReadFromInputFile() {
        assertEquals("253 1110", FractionalTree.readFromInputFile("/home/vaclav/IdeaProjects/FractionalTree/outputs/01.in"));
    }

    @Test
    public void shouldCreateFractionalTree() {
        assertNotNull(FractionalTree.createFractionalTree("154 41"));
    }

}