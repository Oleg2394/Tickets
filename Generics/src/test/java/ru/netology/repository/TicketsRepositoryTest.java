package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketInformation;
import static org.junit.jupiter.api.Assertions.*;

public class TicketsRepositoryTest {
    private TicketsRepository repository = new TicketsRepository();

    private TicketInformation first = new TicketInformation(1, 1_000, "ABA", "OMS", 120);
    private TicketInformation second = new TicketInformation(2, 2_000, "BZK", "OMS", 180);
    private TicketInformation third = new TicketInformation(3, 3_000, "ABA", "OMS", 240);
    private TicketInformation fourth = new TicketInformation(4, 4_000, "RZN", "BZK", 300);

    @BeforeEach
    public void shouldSetUp() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
    }

    @Test
    void shouldGetFour() {

        TicketInformation[] expected = new TicketInformation[]{first, second, third};
        TicketInformation[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        int id = 3;
        TicketInformation[] expected = new TicketInformation[]{first, second};
        TicketInformation[] actual = repository.removeById(id);
        assertArrayEquals(expected, actual);
    }
}
