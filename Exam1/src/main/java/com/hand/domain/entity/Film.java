package com.hand.domain.entity;

import com.hand.infra.util.RatingTypeHandler;
import com.hand.infra.util.SpecialFeatureTypeHandler;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Id;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Film {

    @Id
    private Integer filmId;

    private String title;

    private String description;

    private String releaseYear;

    private Integer languageId;

    private Integer originalLanguageId;

    private Integer rentalDuration;

    private Double rentalRate;

    private Integer length;

    private Double replacementCost;

    @ColumnType(typeHandler = RatingTypeHandler.class)
    private RatingEnum rating;

    @ColumnType(typeHandler = SpecialFeatureTypeHandler.class)
    private Set<SpecialFeature> specialFeatures;

    private Date lastUpdate;

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Integer originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public Double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(Double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public void setRating(RatingEnum rating) {
        this.rating = rating;
    }

    public void setSpecialFeatures(Set<SpecialFeature> specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public RatingEnum getRating() {
        return rating;
    }

    public Set<SpecialFeature> getSpecialFeatures() {
        return specialFeatures;
    }
}
