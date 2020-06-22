package ru.netology.repository;

import ru.netology.domain.TicketInformation;

public class TicketsRepository {
    private TicketInformation[] items = new TicketInformation[]{};

    public void add(TicketInformation item) {
        int length = items.length + 1;
        TicketInformation[] tmp = new TicketInformation[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public TicketInformation[] getAll() {
        return items;
    }

    public TicketInformation[] removeById(int id) {
        int length = items.length - 1;
        TicketInformation[] tmp = new TicketInformation[length];
        int index = 0;
        for (TicketInformation item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return tmp;
    }
}