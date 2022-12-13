package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;
import pairmatching.constant.Constant;
import pairmatching.domain.Course;
import pairmatching.domain.CrewGroup;
import pairmatching.domain.PairMatchingGroup;

public class PairMatchingService {

    private final CrewGroup crewGroup = new CrewGroup();
    private final PairMatchingGroup pairMatchingGroup = new PairMatchingGroup();

    public void initData() {
        String backendCrews = readBackendCrews();
        String frontendCrews = readFrontendCrews();
        crewGroup.initBackendCrews(backendCrews);
        crewGroup.initFrontendCrews(frontendCrews);
    }

    private String readBackendCrews() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("/Users/gimjinbeom/code/utc/study/pairmatching/java-pairmatching-precourse/src/main/resources/backend-crew.md"));
            return lines.get(0);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String readFrontendCrews() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("/Users/gimjinbeom/code/utc/study/pairmatching/java-pairmatching-precourse/src/main/resources/frontend-crew.md"));
            return lines.get(0);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<List<String>> pairMatching(List<String> courseLevelMission) {
        String courseName = courseLevelMission.get(Constant.COURSE_INDEX);
        String level = courseLevelMission.get(Constant.LEVEL_INDEX);
        String mission = courseLevelMission.get(Constant.MISSION_INDEX);
        Course course = Course.findCourseByName(courseName);
        if (course.equals(Course.BACKEND)) {
            return backendPairMatching(level, mission);
        }
        return frontendPairMatching(level, mission);
    }

    private List<List<String>> backendPairMatching(String level, String mission) {
        List<String> allBackendCrewNames = crewGroup.findAllBackendCrewNames();
        List<String> shuffledCrew = Randoms.shuffle(allBackendCrewNames);
        IntStream.range(0, shuffledCrew.size() / 2)
                .forEach(crewIndex -> backendPairMatching(shuffledCrew, crewIndex * 2, level, mission));
        return pairMatchingGroup.findBackendPairMatching(level, mission);
    }

    private void backendPairMatching(List<String> shuffledCrew, int crewIndex, String level, String mission) {
        List<String> crews = computeCrews(shuffledCrew, crewIndex);
        pairMatchingGroup.backendPairMatching(crews, level, mission);
    }

    private List<String> computeCrews(List<String> shuffledCrew, int crewIndex) {
        if (isMustBeThreeCrew(shuffledCrew, crewIndex)) {
            return List.of(shuffledCrew.get(crewIndex), shuffledCrew.get(crewIndex + 1), shuffledCrew.get(crewIndex + 2));
        }
        return List.of(shuffledCrew.get(crewIndex), shuffledCrew.get(crewIndex + 1));
    }

    private boolean isMustBeThreeCrew(List<String> shuffledCrew, int crewIndex) {
        return isOddCrewNumber(shuffledCrew) && crewIndex == shuffledCrew.size() - 3;
    }

    private boolean isOddCrewNumber(List<String> shuffledCrew) {
        return shuffledCrew.size() % 2 == 1;
    }

    private List<List<String>> frontendPairMatching(String level, String mission) {
        List<String> allFrontendCrewNames = crewGroup.findAllFrontendCrewNames();
        List<String> shuffledCrew = Randoms.shuffle(allFrontendCrewNames);
        IntStream.range(0, shuffledCrew.size() / 2)
                .forEach(crewIndex -> frontendPairMatching(shuffledCrew, crewIndex * 2, level, mission));
        return pairMatchingGroup.findFrontendPairMatching(level, mission);
    }

    private void frontendPairMatching(List<String> shuffledCrew, int crewIndex, String level, String mission) {
        List<String> crews = computeCrews(shuffledCrew, crewIndex);
        pairMatchingGroup.frontendPairMatching(crews, level, mission);
    }

    public boolean isExistPairMatching(List<String> courseLevelMission) {
        return pairMatchingGroup.isExistPairMatching(courseLevelMission);
    }

    public void deletePairMatching(List<String> courseLevelMission) {
        pairMatchingGroup.delete(courseLevelMission);
    }

    public List<List<String>> findPairMatching(List<String> courseLevelMission) {
        return pairMatchingGroup.findPairMatching(courseLevelMission);
    }
}
