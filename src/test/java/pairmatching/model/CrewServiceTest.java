package pairmatching.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import pairmatching.model.domain.Course;

class CrewServiceTest {
    @Test
    void 과정_별_크루정보_조회() {
        CrewService crewService = new CrewService();

        assertThat(crewService.findAllCrewsByCourse(Course.FRONTEND.getName())).hasSize(15);
        assertThat(crewService.findAllCrewsByCourse(Course.BACKEND.getName())).hasSize(20);
    }

    @Test
    void 과정_별_크루정보_조회_존재하지_않는_과정명_예외발생() {
        CrewService crewService = new CrewService();

        assertThatThrownBy(() -> crewService.findAllCrewsByCourse("테스트"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}