package ru.netology.manager;

import ru.netology.domain.TicketInformation;
import ru.netology.repository.TicketsRepository;
import java.util.Arrays;

public class TicketsManager {

    private TicketsRepository repository;

    public TicketsManager(TicketsRepository repository) {
        this.repository = repository;
    }

    public TicketInformation[] findAll(String from, String to) {
        TicketInformation[] result = new TicketInformation[]{};

        for (TicketInformation items : repository.getAll()) {
            if (matches(items, from) && (matches(items, to))
            ) {
                TicketInformation[] tmp = new TicketInformation[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = items;
                result = tmp;
            }
        }

        Arrays.sort(result);
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
