package ru.netology.manager;

import ru.netology.domain.TicketInformation;

import java.util.Arrays;
import java.util.Comparator;

public class TicketsManager {
    private ru.netology.repository.TicketsRepository repository;

    public TicketsManager(ru.netology.repository.TicketsRepository repository) {
        this.repository = repository;
    }

    public TicketInformation[] findAll(String from, String to, Comparator<TicketInformation> comparator) {
        TicketInformation[] result = new TicketInformation[0];

        for (TicketInformation items : repository.getAll()) {
            if (matches(items, from) && matches(items, to)) {
                TicketInformation[] tmp = new TicketInformation[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = items;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

    private boolean matches(TicketInformation information, String search) {
        if (information.getFrom().equalsIgnoreCase(search)) {
            return true;
        }
        if (information.getTo().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }
}