package de.microtema.reactivespringreactor.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class NotificationData {

    @NotNull
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String email;
}
