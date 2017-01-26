# LabelMerge

Utility class to merge two sets of labels.

Example:

    Set<String> baseLabels = new LinkedHashSet<String>() {{
        add("1"); add("2"); add("3"); // base labels, i.e. the set of labels when the branch was created
    }};
    
    Set<String> leftLabels = new LinkedHashSet<String>() {{
        add("1"); add("2"); // left side removes label "3"
    }};
    
    Set<String> rightLabels = new LinkedHashSet<String>() {{
        add("1"); add("2"); add("3"); add("4"); // right side adds label "4"
    }};

    LabelMerge.mergeLabels(baseLabels, leftLabels, rightLabels); // returns 1, 2, 4

