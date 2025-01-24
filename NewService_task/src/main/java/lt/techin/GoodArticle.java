package lt.techin;

import lt.vtvpmc.Article;

public class GoodArticle implements Article {

    private String heading;
    private String brief;

    public GoodArticle(String heading, String brief) {
        this.heading = heading;
        this.brief = brief;
    }

    @Override
    public String getHeading() {
        return heading;
    }

    @Override
    public String getBrief() {
        return brief;
    }
}
