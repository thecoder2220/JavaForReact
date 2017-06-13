package com.claurier.common.commons.entities;

import java.time.LocalDateTime;

public interface IHistory {
    public Long getIdUserCreation();

    public Long getIdUserModification();

    public LocalDateTime getDateCreation();

    public LocalDateTime getDateModification();
}

