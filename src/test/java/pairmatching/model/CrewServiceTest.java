package pairmatching.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import pairmatching.model.domain.Crew;
import pairmatching.model.domain.CrewRepository;

class CrewServiceTest {
    private final CrewService crewService = new CrewService();

    @Test
    void 크루정보_저장_성공() {
        crewService.importCrewResources();
        List<Crew> importedCrews = CrewRepository.crews();
        System.out.println(importedCrews);
        assertThat(importedCrews).hasSize(35);
    }
}