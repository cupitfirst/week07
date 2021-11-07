package com.bh1ofp.week07.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

public class Base implements Serializable {
    private static final long serialVersionUID = 8323931567701331992L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "jc")
    @SequenceGenerator(name = "jc", sequenceName = "seq_a", allocationSize = 1)
    private Long id;
}
