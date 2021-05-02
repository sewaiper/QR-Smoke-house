package ru.sewaiper.smokehouse.model.bid;

import java.util.List;

public class ShishaBid {
    protected String status;
    protected List<ShishaBowl> bowls;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ShishaBowl> getBowls() {
        return bowls;
    }

    public void setBowls(List<ShishaBowl> bowls) {
        this.bowls = bowls;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Shisha bid status: ").append(status).append("\n");
        for (ShishaBowl bowl : bowls) {
            builder.append(" - - - - - - - - - - - - - - - - - - - - \n");
            builder.append(bowl.toString());
        }

        return builder.toString();
    }
}
