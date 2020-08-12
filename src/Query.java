import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Query {
    private String type;
    private String service;
    private String question;
    private String answerType;
    private List<Long> date = new ArrayList<>();
    private String time = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public List<Long> getDate() {
        return date;
    }

    public void setDate(List<Long> date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    DateTimeFormatter df = DateTimeFormatter.ofPattern("d.MM.yyyy");

    public Query (String[] input) {
        this.type = input [0];
        this.service = input[1];
        this.question = input[2];
        this.answerType = input[3];
        //this.date = (LocalDate[]) Arrays.stream( input[4].split("-")).map(d ->  ).toArray();
        Arrays.stream(input[4].split("-")).forEach(d -> this.date.add( java.sql.Date.valueOf(LocalDate.parse(d, this.df) ).getTime()) );
        this.time = input.length == 6 ? input[5] : null;

    }

    public Boolean itemsEqual (String itemOne, String itemTwo) {//сравнивает данные стринга, для фльтра
        return itemOne.startsWith("*") || itemTwo.startsWith(itemOne);
    }

    @Override
    public String toString() {
        return "QueryC{" +
                "service='" + service + '\'' +
                ", question='" + question + '\'' +
                ", answerType='" + answerType + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
