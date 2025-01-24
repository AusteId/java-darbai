package lt.techin;

import lt.vtvpmc.Article;
import lt.vtvpmc.NewsService;
import lt.vtvpmc.NewsServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class NewsServiceNewsService implements NewsService {

    private List<Article> articles;
    private List<Article> rightArticles;
    private ArrayList<Swearwords> swearwords;

    public NewsServiceNewsService() {
        NewsServiceImpl newsService = new NewsServiceImpl();
        this.articles = newsService.getArticles();
    }

    @Override
    public List<Article> getArticles() {
        String heading = "";
        String brief = "";

        for (int i = 0; i < articles.size(); i++) {
            for (int j = 0; j < swearwords.size(); j++) {
                if(!articles.get(i).getHeading().contains(swearwords.get(j).toString())) {
                    if(articles.get(i).getBrief().contains(swearwords.get(j).toString())) {
                        articles.replaceAll(a -> );
                    }
                }
            }

        }


        return List.of();
    }
}
