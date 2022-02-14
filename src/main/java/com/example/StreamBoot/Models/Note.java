package com.example.StreamBoot.Models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull нельзя - не записываеться в DB(в DB ставим NotNull)
    private Long id;
    @NonNull
    private Date date;
    @NotNull
    @Size(min=2,max=45)
    private String name;
    @NotNull
    @Size(min=2,max=600)
    private String text;

    //метод отсекает часы и минуты у даты и форматирует Date in String
    public String changeThisDateInString() {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        return formatForDateNow.format(date);
    }
}
