package com.basetravel.tour.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="tours")
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long travelId;
    private String name;
    private String description;
    private String location;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date endDate;
    private Long countLimit;

    @OneToMany(mappedBy = "travel", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Order> orders;

    public Travel() {
    }

    public Travel(String name, String description, String location, Date startDate, Date endDate, Long countLimit) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.countLimit = countLimit;
    }

    public Long getTravelId() {
        return travelId;
    }

    public void setTravelId(Long travelId) {
        this.travelId = travelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getCountLimit() {
        return countLimit;
    }

    public void setCountLimit(Long countLimit) {
        this.countLimit = countLimit;
    }


}
