package de.scandio.labelmerge;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Georg Schmidl
 */
public class LabelMergeTest {

    @Test
    public void mergeLabelsAddLeft() throws Exception {
        Set<String> baseLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};
        Set<String> leftLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); add("4"); }};
        Set<String> rightLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};

        assertEquals(new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); add("4"); }}, LabelMerge.mergeLabels(baseLabels, leftLabels, rightLabels));
    }

    @Test
    public void mergeLabelsAddRight() throws Exception {
        Set<String> baseLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};
        Set<String> leftLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};
        Set<String> rightLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); add("5"); }};

        assertEquals(new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); add("5"); }}, LabelMerge.mergeLabels(baseLabels, leftLabels, rightLabels));
    }

    @Test
    public void mergeLabelsAddOnBothSides() throws Exception {
        Set<String> baseLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};
        Set<String> leftLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); add("4"); }};
        Set<String> rightLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); add("5"); }};

        assertEquals(new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); add("4"); add("5"); }}, LabelMerge.mergeLabels(baseLabels, leftLabels, rightLabels));
    }

    @Test
    public void mergeLabelsRemoveLeft() throws Exception {
        Set<String> baseLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};
        Set<String> leftLabels = new LinkedHashSet<String>() {{ add("2"); add("3"); }};
        Set<String> rightLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};

        assertEquals(new LinkedHashSet<String>() {{ add("2"); add("3"); }}, LabelMerge.mergeLabels(baseLabels, leftLabels, rightLabels));
    }

    @Test
    public void mergeLabelsRemoveRight() throws Exception {
        Set<String> baseLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};
        Set<String> leftLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};
        Set<String> rightLabels = new LinkedHashSet<String>() {{ add("1"); add("3"); }};

        assertEquals(new LinkedHashSet<String>() {{ add("1"); add("3"); }}, LabelMerge.mergeLabels(baseLabels, leftLabels, rightLabels));
    }

    @Test
    public void mergeLabelsRemoveOnBothSides() throws Exception {
        Set<String> baseLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};
        Set<String> leftLabels = new LinkedHashSet<String>() {{ add("2"); add("3"); }};
        Set<String> rightLabels = new LinkedHashSet<String>() {{ add("1"); add("3"); }};

        assertEquals(new LinkedHashSet<String>() {{ add("3"); }}, LabelMerge.mergeLabels(baseLabels, leftLabels, rightLabels));
    }

    @Test
    public void mergeLabelsAddAndRemoveLeft() throws Exception {
        Set<String> baseLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};
        Set<String> leftLabels = new LinkedHashSet<String>() {{ add("2"); add("3"); add("4"); }};
        Set<String> rightLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};

        assertEquals(new LinkedHashSet<String>() {{ add("2"); add("3"); add("4"); }}, LabelMerge.mergeLabels(baseLabels, leftLabels, rightLabels));
    }

    @Test
    public void mergeLabelsAddAndRemoveRight() throws Exception {
        Set<String> baseLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};
        Set<String> leftLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};
        Set<String> rightLabels = new LinkedHashSet<String>() {{ add("1"); add("3"); add("5"); }};

        assertEquals(new LinkedHashSet<String>() {{ add("1"); add("3"); add("5"); }}, LabelMerge.mergeLabels(baseLabels, leftLabels, rightLabels));
    }

    @Test
    public void mergeLabelsAddAndRemoveOnBothSides() throws Exception {
        Set<String> baseLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};
        Set<String> leftLabels = new LinkedHashSet<String>() {{ add("2"); add("3"); add("4"); }};
        Set<String> rightLabels = new LinkedHashSet<String>() {{ add("1"); add("3"); add("5"); }};

        assertEquals(new LinkedHashSet<String>() {{ add("3"); add("4"); add("5"); }}, LabelMerge.mergeLabels(baseLabels, leftLabels, rightLabels));
    }

    @Test
    public void mergeLabelsAddOnlyLeft() throws Exception {
        Set<String> baseLabels = new LinkedHashSet<String>() {{ }};
        Set<String> leftLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};
        Set<String> rightLabels = new LinkedHashSet<String>() {{  }};

        assertEquals(new LinkedHashSet<String>() {{add("1"); add("2"); add("3"); }}, LabelMerge.mergeLabels(baseLabels, leftLabels, rightLabels));
    }

    @Test
    public void mergeLabelsAddOnlyRight() throws Exception {
        Set<String> baseLabels = new LinkedHashSet<String>() {{ }};
        Set<String> leftLabels = new LinkedHashSet<String>() {{ }};
        Set<String> rightLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};

        assertEquals(new LinkedHashSet<String>() {{add("1"); add("2"); add("3"); }}, LabelMerge.mergeLabels(baseLabels, leftLabels, rightLabels));
    }

    @Test
    public void mergeLabelsRemoveOnlyLeft() throws Exception {
        Set<String> baseLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3");  }};
        Set<String> leftLabels = new LinkedHashSet<String>() {{ }};
        Set<String> rightLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};

        assertEquals(new LinkedHashSet<String>() {{ }}, LabelMerge.mergeLabels(baseLabels, leftLabels, rightLabels));
    }

    @Test
    public void mergeLabelsRemoveOnlyRight() throws Exception {
        Set<String> baseLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3");  }};
        Set<String> leftLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};
        Set<String> rightLabels = new LinkedHashSet<String>() {{ }};

        assertEquals(new LinkedHashSet<String>() {{ }}, LabelMerge.mergeLabels(baseLabels, leftLabels, rightLabels));
    }

    @Test
    public void removeLabelsRemoveLeftAndAddRight() throws Exception {
        Set<String> baseLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); }};
        Set<String> leftLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); }};
        Set<String> rightLabels = new LinkedHashSet<String>() {{ add("1"); add("2"); add("3"); add("4"); }};

        assertEquals(new LinkedHashSet<String>() {{ add("1"); add("2"); add("4"); }}, LabelMerge.mergeLabels(baseLabels, leftLabels, rightLabels));
    }
}