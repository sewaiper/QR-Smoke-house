package ru.sewaiper.smokehouse.model.bid;

import java.util.List;
import java.util.Objects;

public class ShishaBowl {
    protected String type;
    protected List<ShishaTobacco> tobacco;
    protected ShishaParameters parameters;
    protected String comment;
    protected String bowlType;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ShishaTobacco> getTobacco() {
        return tobacco;
    }

    public void setTobacco(List<ShishaTobacco> tobacco) {
        this.tobacco = tobacco;
    }

    public ShishaParameters getParameters() {
        return parameters;
    }

    public void setParameters(ShishaParameters parameters) {
        this.parameters = parameters;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBowlType() {
        return bowlType;
    }

    public void setBowlType(String bowlType) {
        this.bowlType = bowlType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShishaBowl)) return false;
        ShishaBowl that = (ShishaBowl) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(tobacco, that.tobacco) &&
                Objects.equals(parameters, that.parameters) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(bowlType, that.bowlType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, tobacco, parameters, comment, bowlType);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Shisha bowl {\n");
        builder.append("Type: ").append(type).append("\n");
        for (ShishaTobacco bowl : tobacco) {
            builder.append(bowl.toString()).append("\n");
        }
        builder.append(parameters.toString()).append("\n");
        builder.append("Comment: ").append(comment).append("\n");
        builder.append("Bowl type: ").append(bowlType).append("\n");
        builder.append("}").append("\n");

        return builder.toString();
    }
}
