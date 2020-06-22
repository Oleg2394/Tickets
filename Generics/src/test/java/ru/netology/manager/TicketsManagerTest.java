package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketInformation;
import ru.netology.repository.TicketsRepository;
import java.util.Comparator;

class TicketsManagerTest {
    private TicketsRepository repository = new TicketsRepository();

    private TicketInformation first = new TicketInformation(1, 1_000, "ABA", "OMS", 120);
    private TicketInformation second = new TicketInformation(2, 2_000, "BZK", "OMS", 180);
    private TicketInformation third = new TicketInformation(3, 3_000, "ABA", "OMS", 240);
    private TicketInformation fourth = new TicketInformation(4, 4_000, "RZN", "BZK", 300);

    @Test
    void shouldFindAndSortByPrice() {
        TicketsManager manager = new TicketsManager(repository);

        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);

        TicketInformation[] expected = new TicketInformation[]{first,third};
        TicketInformation[] actual = manager.findAll("ABA", "OMS", Comparator.comparing(TicketInformation::getPrice));
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindAndSortByPrice() {
        TicketsManager manager = new TicketsManager(repository);

        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);

        TicketInformation[] expected = new TicketInformation[]{};
        TicketInformation[] actual = manager.findAll("BZK", "ABA", Comparator.comparing(TicketInformation::getPrice));
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldFindAndSortByTime() {
        TicketsManager manager = new TicketsManager(repository);

        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);

        TicketInformation[] expected = new TicketInformation[]{first,third};
        TicketInformation[] actual = manager.findAll("ABA", "OMS", (Comparator.comparing(information -> information.getTime())));
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindAndSortByTime() {
        TicketsManager manager = new TicketsManager(repository);

        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);

        manager.findAll("RZN", "OMS", (Comparator.comparing(information -> information.getTime())));
        TicketInformation[] expected = new TicketInformation[]{};
        TicketInformation[] actual = manager.findAll("RZN", "OMS", (Comparator.comparing(information -> information.getTime())));
        assertArrayEquals(expected, actual);
    }

}