package com.jpm.inheritance.jt.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

//DEFINE OneToOne Relationships (SELF JOIN-No mandatory)
@Entity 
class Person {
     @Id
     private long identificator;
     
     @OneToOne(optional = true)
     @JoinColumn(name = "SoulmateId")
     private Person soulmate;
}