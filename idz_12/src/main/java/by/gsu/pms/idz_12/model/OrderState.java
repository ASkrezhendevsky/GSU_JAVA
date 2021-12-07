package by.gsu.pms.idz_12.model;

import java.util.List;

public enum OrderState {
    READY, IN_PROCESS, DELIVERED;
    public static final List<OrderState> ALL = List.of(READY, IN_PROCESS, DELIVERED);
}
