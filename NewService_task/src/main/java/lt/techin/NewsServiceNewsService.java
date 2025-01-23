package lt.techin;

import lt.vtvpmc.Article;
import lt.vtvpmc.NewsService;
import lt.vtvpmc.NewsServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NewsServiceNewsService implements NewsService {

    private List<Article> articles;
    private List<Article> rightArticles;
    Swearwords swearwords;

    public NewsServiceNewsService() {
        NewsServiceImpl newsService = new NewsServiceImpl();
        this.articles = newsService.getArticles();
    }

    @Override
    public List<Article> getArticles() {
        String heading = "";
        String brief = "";

        for (int i = 0; i < articles.size(); i++) {
            if(articles.get(i).getHeading(). )
        }


        return List.of();
    }
}
