package pack;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

/**
 * Created by minmi on 2016-10-24.
 */

class Main{

    public static void main(String args[]) throws IOException {

        Document doc = Jsoup.connect("https://kr.battle.net/forums/ko/overwatch/4989051/").get();
        Elements titles = doc.select("a.ForumTopic.has-blizzard-post div.ForumTopic-details span.ForumTopic-heading span.ForumTopic-title--wrapper span.ForumTopic-title");
        Elements links = doc.select("div.Forum-ForumTopicList a[href]").not("a.BlizzIcon-link").not("a.ForumTopic-timestamp--lastPost");
        int i = 0;
        for(Element e: titles){
            i++;
            System.out.println(i + " : " + e.text());
        }
        i = 0;
        for(Element l: links){
            i++;
            System.out.println(i + " : " + l.attr("abs:href"));
        }

    }
}
