import lt.techin.philatelist.Philatelist;
import lt.techin.philatelist.PostStamp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PhilatelistImplementation implements Philatelist {

    private ArrayList<PostStamp> postStamps = new ArrayList<>();

    @Override
    public void addToCollection(PostStamp postStamp) {

        if(postStamp == null || postStamp.getName() == null || postStamp.getName().isEmpty()) {
            throw new IllegalArgumentException();
        }

        if(!postStamps.contains(postStamp)) {
            postStamps.add(postStamp);
        }
    }

    @Override
    public int getNumberOfPostStampsInCollection() {
        return postStamps.size();
    }

    @Override
    public void printAllPostStampNames() {
        for (PostStamp postStamp : postStamps) {
            System.out.println(postStamp.getName());
        }
    }

    @Override
    public void printPostStampsWithPriceGreaterThan(double v) {
        for (PostStamp postStamp : postStamps) {
            if(postStamp.getMarketPrice() > v) {
                System.out.println(postStamp.getName());
            }
        }
    }

    @Override
    public boolean isPostStampInCollection(PostStamp postStamp) {
        return postStamps.contains(postStamp);
    }

    @Override
    public boolean isPostStampWithNameInCollection(String s) {
        for (PostStamp postStamp : postStamps) {
            if(postStamp.getName().equals(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double calculateTotalMarketPrice() {
        double totalPrice = 0;
        for (PostStamp postStamp : postStamps) {
            totalPrice += postStamp.getMarketPrice();
        }
        return totalPrice;
    }

    @Override
    public double getAveragePostStampPrice() {
        return calculateTotalMarketPrice() / postStamps.size();
    }

    @Override
    public PostStamp getTheMostExpensivePostStampByMarketValue() {
        PostStamp mostExpensive = postStamps.get(0);
        double largestPrice = 0;
        for (PostStamp postStamp : postStamps) {
            if(postStamp.getMarketPrice() > largestPrice) {
                largestPrice = postStamp.getMarketPrice();
                mostExpensive = postStamp;
            }
        }
        return mostExpensive;
    }

    @Override
    public List<PostStamp> findPostStampsByNameContaining(String s) {
        List<PostStamp> postStampsByName = new ArrayList<>();
        for (PostStamp postStamp : postStamps) {
            if(postStamp.getName().contains(s)) {
                postStampsByName.add(postStamp);
            }
        }
        return postStampsByName;
    }

    @Override
    public List<PostStamp> getSortedPostStampsByName() {
//        postStamps.sort((a, b) -> a.getName().compareTo(b.getName()));
        postStamps.sort(Comparator.comparing(PostStamp::getName));
        return postStamps;
    }
}
