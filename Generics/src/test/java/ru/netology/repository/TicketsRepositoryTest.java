package ru.netology.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketInformation;

class TicketsRepositoryTest {
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
        repository.add(fourth);
    }

    @Test
    void shouldGetFour() {

        TicketInformation[] expected = new TicketInformation[]{first, second, third, fourth};
        TicketInformation[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        int id = 2;
        TicketInformation[] expected = new TicketInformation[]{first, third, fourth};
        TicketInformation[] actual = repository.removeById(id);
        assertArrayEquals(expected, actual);
    }
}