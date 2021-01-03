package entities;

import java.util.Date;

public class ErrandBuilder {
    private Errand errand;

    public ErrandBuilder(Employee employee, Date start, String place) {
        this.errand = new Errand(employee, start, place);
    }

    public ErrandBuilder id(Long id){
        errand.setId(id);
        return this;
    }

    public ErrandBuilder status(Errand.Status status){
        errand.setStatus(status);
        return this;
    }

    public ErrandBuilder matter(Errand.Matter matter){
        errand.setMatter(matter);
        return this;
    }

    public ErrandBuilder end(Date end){
        errand.setEnd(end);
        return this;
    }

    public ErrandBuilder comment(String comment){
        errand.setComment(comment);
        return this;
    }

    public ErrandBuilder createdBy(Employee createdBy){
        errand.setCreatedBy(createdBy);
        return this;
    }

    public ErrandBuilder confirmedOrRejectedBy(Employee confirmedOrRejectedBy){
        errand.setConfirmedOrRejectedBy(confirmedOrRejectedBy);
        return this;
    }

    public Errand create(){
        return errand;
    }
}
