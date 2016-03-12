package cz.vendasky;

import org.junit.After;
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
        assertEquals("460 129", FractionalTree.readFromInputFile("/home/vaclav/IdeaProjects/FractionalTree/inputs/01.in"));
    }

    @Test
    public void shouldCreateFractionalTree() {
        assertNotNull(FractionalTree.createFractionalTree("154 41"));
    }

    @After
    public void run() {
        FractionalTree.run("/home/vaclav/IdeaProjects/FractionalTree/inputs/08.in", "/home/vaclav/IdeaProjects/FractionalTree/outputs/08.txt");
    }

}