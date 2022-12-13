package pairmatching.repository;

import pairmatching.domain.Crew;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrewRepository {
    private static final List<Crew> crews = new ArrayList<>();

    public static void save(Crew crew) {
        crews.add(crew);
    }

    public static List<Crew> findAll() {
        return Collections.unmodifiableList(crews);
    }

}
