package pairmatching.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import pairmatching.model.domain.Course;

class CrewServiceTest {
    @Test
    void 과정_별_크루정보_조회() {
        CrewService crewService = new CrewService();
        assertThat(crewService.findAllCrewsByCourse(Course.FRONTEND)).hasSize(15);
        assertThat(crewService.findAllCrewsByCourse(Course.BACKEND)).hasSize(20);
    }
}