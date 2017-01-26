package de.scandio.labelmerge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  Utility class to merge two sets of labels.
 *
 * @author Georg Schmidl
 */
public class LabelMerge {

    public enum Flag {
        ADD, REMOVE
    }

    /**
     * Merge two sets of labels.
     *
     * @param baseLabels common base for left and right labels
     * @param leftLabels left branch of labels
     * @param rightLabels right branch of labels
     * @return the merged labels.
     */
    public static Set<String> mergeLabels(Set<String> baseLabels, Set<String> leftLabels, Set<String> rightLabels) {
        Map<String, Flag> flags = new HashMap<>();

        Arrays.asList(leftLabels, rightLabels)
                .forEach(labels -> Stream.concat(baseLabels.stream(), labels.stream()).collect(Collectors.toSet())
                        .forEach(label -> {
                                    if (!flags.containsKey(label)) {
                                        if (baseLabels.contains(label) && !labels.contains(label)) {
                                            flags.put(label, Flag.REMOVE);
                                        } else if(!baseLabels.contains(label) && labels.contains(label)) {
                                            flags.put(label, Flag.ADD);
                                        }
                                    }
                                }
                        )
                );

        return Stream.concat(leftLabels.stream(), rightLabels.stream())
                .filter(label -> !flags.containsKey(label) || flags.get(label).equals(Flag.ADD))
                .collect(Collectors.toSet());
    }
}
