package com.ProdProject.ProdPro.Modals;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseModal {
    @Id
    @GeneratedValue(generator = "uuidgenerator")
    @GenericGenerator(name = "uuidgenerator",strategy="uuid2")
    @Column(name = "id",columnDefinition="binary(16)",nullable=false)
    private UUID id;
}
