import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Handler {


    public  void start() {



        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
       // int capacity = sc2.nextInt();
        List<Query> queryList = new ArrayList<>(sc2.nextInt());

        while (true) {
            Query query = new Query (sc.nextLine().split(" "));
            if (query.getType().equals("C")) {
                queryList.add(query);
            } else if (query.getType().equals("D")) {
                System.out.println(selectQuery(query, queryList));
            }

        }



    }

    public  Boolean dateCompare (List<Long> dateListOne, List<Long> dateListTwo) {

        return dateListOne.size() == 2 ? dateListOne.get(0) <= dateListTwo.get(0)
                && dateListTwo.get(0) <= dateListOne.get(1): dateListOne.get(0).equals(dateListTwo.get(0));

    }

    public  String selectQuery(Query query, List<Query> queryList) {

        Object[] preres = queryList.stream()
                .filter(q -> ( q.itemsEqual(query.getService(), q.getService()) &&
                        q.itemsEqual(query.getQuestion(), q.getQuestion()) &&
                        q.getAnswerType().equals(query.getAnswerType()) &&
                        dateCompare(query.getDate(), q.getDate())
                ))
                .map ( q -> Integer.parseInt( q.getTime()))
                .toArray();

        Integer sum = 0;
        for (Object i:preres) {

            sum += Integer.parseInt(i.toString());
        }
        Integer result = sum != 0 ? sum/preres.length : 0;
        return sum == 0 ? "-" : result.toString();
    }
}
