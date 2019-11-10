package ru.unn.agile.binaryTree.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeMultiNodeTests {
    private BinaryTree binaryTree;

    private int     firstKey = 1;
    private String  firstData = "FirstSimpleText";

    private int     secondKey = 2;
    private String  secondData = "SecondSimpleText";

    final   int     thirdKey = 3;
    final   String  thirdData = "ThirdSimpleText";

    @Before
    public void setUp() {
        binaryTree = new BinaryTree();
    }

    @Test
    public void canAddTwoElements() {
        binaryTree.add(firstKey, firstData);
        binaryTree.add(secondKey, secondData);
    }

    @Test
    public void canFindTwoElements() {
        binaryTree.add(firstKey, firstData);
        binaryTree.add(secondKey, secondData);

        final String firstResult  = binaryTree.find(firstKey);
        final String secondResult = binaryTree.find(secondKey);

        assertEquals(firstResult, firstData);
        assertEquals(secondResult, secondData);
    }

    @Test
    public void canAddChildToChild() {
        binaryTree.add(firstKey, firstData);
        binaryTree.add(secondKey, secondData);
        binaryTree.add(thirdKey, thirdData);

        final String expectedData = binaryTree.getRoot().getRightChild().getRightChild().getValue();
        assertEquals(expectedData, binaryTree.find(thirdKey));
    }

    @Test
    public void connectTwoChildIfMiddleDeleted() {
        binaryTree.add(firstKey, firstData);
        binaryTree.add(secondKey, secondData);
        binaryTree.add(thirdKey, thirdData);

        assertTrue(binaryTree.remove(secondKey));

        final String expectedData = binaryTree.getRoot().getRightChild().getValue();
        assertEquals(expectedData, thirdData);
    }

    @Test
    public void canRemoveLastOneWithThreeNodes() {
        binaryTree.add(firstKey, firstData);
        binaryTree.add(secondKey, secondData);
        binaryTree.add(thirdKey, thirdData);

        assertTrue(binaryTree.remove(secondKey));

        assertNull(binaryTree.find(secondKey));
    }

    @Test
    public void canRemoveRootChildShouldSurvive() {
        binaryTree.add(firstKey, firstData);
        binaryTree.add(secondKey, secondData);

        assertTrue(binaryTree.remove(firstKey));
        final String  childData = binaryTree.find(secondKey);

        assertEquals(secondData, childData);
    }

    @Test
    public void threeNodesTreeWillBeBalanced() {
        binaryTree.add(secondKey, secondData);
        binaryTree.add(firstKey, firstData);
        binaryTree.add(thirdKey, thirdData);

        assertEquals(2, binaryTree.getHeight());
    }
}
