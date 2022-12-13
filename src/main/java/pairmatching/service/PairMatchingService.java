package pairmatching.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import pairmatching.domain.CrewGroup;

public class PairMatchingService {

    private final CrewGroup crewGroup = new CrewGroup();

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
}
