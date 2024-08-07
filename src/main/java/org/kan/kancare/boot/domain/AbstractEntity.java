package org.kan.kancare.boot.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@MappedSuperclass
@Data
public abstract class AbstractEntity<ID extends Serializable> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;
}