package com.akbar.employees.services;

import com.akbar.employees.models.Position;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionService {

    private List<Position> positions = load();

    private List<Position> load() {
        positions = new ArrayList<>();
        positions.add(new Position(1, "director"));
        positions.add(new Position(2, "manager"));
        positions.add(new Position(3, "accountant"));
        positions.add(new Position(4, "boss"));
        positions.add(new Position(5, "guard"));
        positions.add(new Position(6, "programmer"));
        positions.add(new Position(7, "cleaner"));
        return positions;
    }

    public List<Position> getAll() {
        return positions;
    }

    public Position getById(int id) {
        return positions.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public Position create(Position position) {
        int id = positions.get(positions.size() - 1).getId() + 1;
        positions.add(new Position(id, position.getName()));
        position.setId(id);
        return position;
    }

    public Position update(Position position) {
        Position findPosition = getById(position.getId());
        if (findPosition != null) {
            findPosition.setName(position.getName());
        }
        return findPosition;
    }

    public void delete(Position position) {
        Position deletedPosition = getById(position.getId());
        if (deletedPosition != null) {
            positions.remove(deletedPosition);
        }
    }
}
