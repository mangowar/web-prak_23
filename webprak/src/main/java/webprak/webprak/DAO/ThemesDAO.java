package webprak.webprak.DAO;
import webprak.webprak.tables.themes;
import webprak.webprak.tables.topics;

import java.util.List;

public interface ThemesDAO extends TableDAO<themes, Long>{
    public abstract themes addTheme(String name, Long creator);
    public abstract void removeTheme(themes theme);
    public abstract List<Long> getTopics(themes theme);
}
