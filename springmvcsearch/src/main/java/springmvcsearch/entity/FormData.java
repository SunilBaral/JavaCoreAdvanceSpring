package springmvcsearch.entity;

import java.util.List;

public class FormData {
    private String name;
    private String email;
    private String message;
    private String gender;
    private List<String> interest;
    private String country;

    public FormData(String name, String email, String message, String gender, List<String> interest, String country) {
        this.name = name;
        this.email = email;
        this.message = message;
        this.gender = gender;
        this.interest = interest;
        this.country = country;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ").append(name != null ? name : "").append("\n");
        stringBuilder.append("Email: ").append(email != null ? email : "").append("\n");
        stringBuilder.append("Message: ").append(message != null ? message : "").append("\n");
        stringBuilder.append("Gender: ").append(gender != null ? gender : "").append("\n");
        stringBuilder.append("interest: ").append(interest != null ? String.join(", ", interest) : "").append("\n");
        stringBuilder.append("Country: ").append(country != null ? country : "").append("\n");
        return stringBuilder.toString();
    }

    // Getters and setters if necessary
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getInterests() {
        return interest;
    }

    public void setInterests(List<String> interest) {
        this.interest = interest;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

