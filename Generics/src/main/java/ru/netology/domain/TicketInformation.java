package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TicketInformation  implements Comparable<TicketInformation> {

    private int id;
    private int price;
    private String from;
    private String to;
    private int time;

    @Override
    public int compareTo(TicketInformation o) {
        return price - o.price;
    }
}
