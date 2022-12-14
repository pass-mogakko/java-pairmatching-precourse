package pairmatching.model.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PairGroupRepository {
    private static final Map<Step, PairGroup> pairGroups = new HashMap<>();

    public static void add(Step step, PairGroup pairGroup) {
        pairGroups.put(step, pairGroup);
    }

    public static PairGroup findByStep(Step step) {
        return pairGroups.get(step);
    }

    public static List<PairGroup> findByCourseLevel(Course course, Level level) {
        return pairGroups.keySet()
                .stream()
                .filter(step -> step.isSameCourseLevel(course, level))
                .map(pairGroups::get)
                .collect(Collectors.toList());
    }

    public static void deleteAll() {
        pairGroups.clear();
    }
}
