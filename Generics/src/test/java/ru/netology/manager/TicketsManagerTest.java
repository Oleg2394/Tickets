package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketInformation;
import ru.netology.repository.TicketsRepository;


class TicketsManagerTest {
    private TicketsRepository repository = new TicketsRepository();
    private TicketsManager[] ticket = new TicketsManager[]{};

    private TicketInformation first = new TicketInformation(1, 1_000, "ABA", "OMS", 120);
    private TicketInformation second = new TicketInformation(2, 2_000, "BZK", "OMS", 180);
    private TicketInformation third = new TicketInformation(3, 3_000, "ABA", "OMS", 240);
    private TicketInformation fourth = new TicketInformation(4, 4_000, "RZN", "BZK", 300);

    @Test
    void shouldFindIfMatchesQuery() {
        TicketsManager manager = new TicketsManager(repository);
        String from = "ABA";
        String to = "OMS";

        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);

        TicketInformation[] expected = new TicketInformation[]{first,third};
        TicketInformation[] actual = manager.findAll(from, to);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNorFindIfMotMatchesQuery() {
        TicketsManager manager = new TicketsManager(repository);
        String from = "BZK";
        String to = "ABA";

        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);

        TicketInformation[] expected = new TicketInformation[]{};
        TicketInformation[] actual = manager.findAll(from, to);

        assertArrayEquals(expected, actual);
    }
}