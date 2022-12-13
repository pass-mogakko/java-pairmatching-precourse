package pairmatching.model.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PairGroupRepository {
    private static final Set<PairGroup> pairGroups = new HashSet<>();

    public static PairGroup findByStep(Step findStep) {
        return pairGroups.stream()
                .filter(pairGroup -> pairGroup.hasSameStep(findStep))
                .findFirst()
                .orElse(null);
    }

    public static PairGroup findByCourseLevel(Course course, Level level) {
        return pairGroups.stream()
                .filter(pairGroup -> pairGroup.hasSameCourseLevel(course, level))
                .findFirst()
                .orElse(null);
    }

    public static Set<PairGroup> pairGroups() {
        return Collections.unmodifiableSet(pairGroups);
    }

    public static void deleteAll() {
        pairGroups.clear();
    }
}
