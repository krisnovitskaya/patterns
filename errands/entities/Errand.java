package krisnovitskaya.errands.entities;

import java.util.Date;

public class Errand {
    private Long id;
    private final Date createdAt;
    private Status status;
    private final Employee employee;
    private Matter matter;
    private final Date start;
    private Date end;
    private final String place;
    private String comment;
    private Employee createdBy;
    private Employee confirmedOrRejectedBy;



    public Errand(Employee employee, Date start, String place) {
        this.employee = employee;
        this.start = start;
        this.place = place;
        this.createdAt = new Date();
    }

    public enum Status{
        REQUESTED ("Запрошена"),
        CONFIRMED ("Подтверждена"),
        REJECTED ("Отклонена");

        private String title;
        Status(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }
    }

    public enum Matter{
        LOCAL ("Местная командировка"),
        PRIVATE ("Личный вопрос"),
        LONG ("Длительная командировка");

        private String title;
        Matter(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Matter getMatter() {
        return matter;
    }

    public void setMatter(Matter matter) {
        this.matter = matter;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getPlace() {
        return place;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
    }

    public Employee getConfirmedOrRejectedBy() {
        return confirmedOrRejectedBy;
    }

    public void setConfirmedOrRejectedBy(Employee confirmedOrRejectedBy) {
        this.confirmedOrRejectedBy = confirmedOrRejectedBy;
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        if(id != null) sb.append("Номер командировки " + id + "\n");
        sb.append("Создана "+ createdAt + "\n");
        if(status != null) sb.append(status.getTitle() + "\n");
        sb.append("Сотрудник " + employee.getFullName() + "\n");
        if(matter != null) sb.append(matter.getTitle()  + "\n");
        sb.append("Дата начала " + start + "\n");
        if(end != null) sb.append("Окончание " + end + "\n");
        sb.append("Место назначения " + place + "\n");
        if(comment != null) sb.append(comment + "\n");
        if(createdBy != null) sb.append("Создана " + createdBy.getName() + "\n");
        if(confirmedOrRejectedBy != null) sb.append("Подтверждена " + confirmedOrRejectedBy.getName() + "\n");
        System.out.println(sb.toString().trim());
    }
}
