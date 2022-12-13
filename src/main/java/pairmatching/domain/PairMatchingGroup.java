package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.constant.Constant;

public class PairMatchingGroup {

    private List<PairMatching> pairMatchingGroup = new ArrayList<>();

    public void backendPairMatching(List<String> crews, String level, String mission) {
        PairMatching pairMatching = new PairMatching(Course.BACKEND, level, mission, crews);
        pairMatchingGroup.add(pairMatching);
    }

    public void frontendPairMatching(List<String> crews, String level, String mission) {
        PairMatching pairMatching = new PairMatching(Course.FRONTEND, level, mission, crews);
        pairMatchingGroup.add(pairMatching);
    }

    public List<List<String>> findBackendPairMatching(String level, String mission) {
        return pairMatchingGroup.stream()
                .filter(pairMatching -> pairMatching.isSameCourse(Course.BACKEND))
                .filter(pairMatching -> pairMatching.isSameLevel(level))
                .filter(pairMatching -> pairMatching.isSameMission(mission))
                .map(PairMatching::getCrews)
                .collect(Collectors.toList());
    }

    public List<List<String>> findFrontendPairMatching(String level, String mission) {
        return pairMatchingGroup.stream()
                .filter(pairMatching -> pairMatching.isSameCourse(Course.FRONTEND))
                .filter(pairMatching -> pairMatching.isSameLevel(level))
                .filter(pairMatching -> pairMatching.isSameMission(mission))
                .map(PairMatching::getCrews)
                .collect(Collectors.toList());
    }

    public boolean isExistPairMatching(List<String> courseLevelMission) {
        String courseName = courseLevelMission.get(Constant.COURSE_INDEX);
        String level = courseLevelMission.get(Constant.LEVEL_INDEX);
        String mission = courseLevelMission.get(Constant.MISSION_INDEX);
        Course course = Course.findCourseByName(courseName);
        return pairMatchingGroup.stream()
                .filter(pairMatching -> pairMatching.isSameCourse(course))
                .filter(pairMatching -> pairMatching.isSameLevel(level))
                .anyMatch(pairMatching -> pairMatching.isSameMission(mission));
    }

    public void delete(List<String> courseLevelMission) {
        String courseName = courseLevelMission.get(Constant.COURSE_INDEX);
        String level = courseLevelMission.get(Constant.LEVEL_INDEX);
        String mission = courseLevelMission.get(Constant.MISSION_INDEX);
        Course course = Course.findCourseByName(courseName);
        pairMatchingGroup.removeIf(pairMatching -> pairMatching.isSameCourse(course) && pairMatching.isSameLevel(level) && pairMatching.isSameMission(mission));
    }

    public List<List<String>> findPairMatching(List<String> courseLevelMission) {
        String courseName = courseLevelMission.get(Constant.COURSE_INDEX);
        String level = courseLevelMission.get(Constant.LEVEL_INDEX);
        String mission = courseLevelMission.get(Constant.MISSION_INDEX);
        Course course = Course.findCourseByName(courseName);
        return pairMatchingGroup.stream()
                .filter(pairMatching -> pairMatching.isSameCourse(course))
                .filter(pairMatching -> pairMatching.isSameLevel(level))
                .filter(pairMatching -> pairMatching.isSameMission(mission))
                .map(PairMatching::getCrews)
                .collect(Collectors.toList());
    }

    public void init() {
        pairMatchingGroup = new ArrayList<>();
    }
}
