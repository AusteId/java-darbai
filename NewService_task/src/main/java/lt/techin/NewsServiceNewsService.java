package lt.techin;

import lt.vtvpmc.Article;
import lt.vtvpmc.NewsService;
import lt.vtvpmc.NewsServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class NewsServiceNewsService implements NewsService {

    private List<Article> articles;
//    private List<Article> rightArticles = new ArrayList<>();
    private ArrayList<String> swearwords;

    public NewsServiceNewsService() {
        NewsServiceImpl newsService = new NewsServiceImpl();
        this.articles = newsService.getArticles();
        swearwords = Swearwords.getSwearwords();
    }

    @Override
    public List<Article> getArticles() {
        String brief = "";
        List<Article> rightArticles = new ArrayList<>();

        for (Article article : articles) {
            Article goods = article;
            boolean isSwearwordsInHeading = false;
            for (String swearword : swearwords) {

                if (article.getHeading().toLowerCase().contains(swearword)) {
                    isSwearwordsInHeading = true;
                }
            }

            if (!isSwearwordsInHeading) {
                for (String swearword : swearwords) {
                    if (article.getBrief().toLowerCase().contains(swearword)) {
                        brief = article.getBrief().replaceAll(swearword, "***");
                        goods = new GoodArticle(article.getHeading(), brief);
                    }
                }
                rightArticles.add(goods);
            }
        }
        return rightArticles;
    }
}
