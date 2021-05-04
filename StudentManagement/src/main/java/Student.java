import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {


    @JsonProperty
    @Column(name = "ID")
    @Id
    private String id;

    @JsonProperty
    @Column(name = "NAME")
    private String name;

    @JsonProperty
    @Column(name = "AGE")
    private String age;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
