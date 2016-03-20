package io.makototheknight.jormungandr.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Arrays;

@Entity(name = "tags")
public class Tag implements Serializable {

    @Id
    @Column
    private Long questionId;

    @Column
    private String[] tags;


    public Long getaQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String[] getTags() {
        return tags.clone();
    }

    public void setTags(String[] tags) {
        this.tags = tags.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        if (questionId != null ? !questionId.equals(tag.questionId) : tag.questionId != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(tags, tag.tags);

    }

    @Override
    public int hashCode() {
        int result = questionId != null ? questionId.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(tags);
        return result;
    }
}
